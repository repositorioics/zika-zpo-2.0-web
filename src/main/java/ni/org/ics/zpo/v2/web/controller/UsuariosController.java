package ni.org.ics.zpo.v2.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.zpo.v2.domain.audit.AuditTrail;
import ni.org.ics.zpo.v2.domain.relationships.UserCenter;
import ni.org.ics.zpo.v2.service.AuditTrailService;
import ni.org.ics.zpo.v2.service.UsuarioService;
import ni.org.ics.zpo.v2.users.model.Authority;
import ni.org.ics.zpo.v2.users.model.UserAccess;
import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * Controlador web de peticiones relacionadas a usuarios
 * 
 * @author William Aviles
 */
@Controller
@RequestMapping("/users/*")
public class UsuariosController {
	@Resource(name="usuarioService")
	private UsuarioService usuarioService;
	@Resource(name="auditTrailService")
	private AuditTrailService auditTrailService;
	
	
	@RequestMapping(value="checkcredential", method=RequestMethod.GET)
	public @ResponseBody boolean getCredential(@RequestParam String userName) {
	    return this.usuarioService.checkCredential(userName);
	}
	
	@RequestMapping(value = "forcechgpass", method = RequestMethod.GET)
    public String initForceChangePassForm() {
	    return "forceChgPass";
    }
	
	/**
     * Custom handler for displaying a user.
     *
     * @param username the ID of the user to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("profile")
    public ModelAndView showUser() {
        ModelAndView mav = new ModelAndView("users/user");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserSistema user = this.usuarioService.getUser(authentication.getName());
        List<UserAccess> accesosUsuario = usuarioService.getUserAccess(authentication.getName());
        List<AuditTrail> bitacoraUsuario = auditTrailService.getBitacora(authentication.getName());
        mav.addObject("user",user);
        mav.addObject("accesses",accesosUsuario);
        mav.addObject("bitacora",bitacoraUsuario);
        List<Authority> rolesusuario = this.usuarioService.getRolesUsuarioTodos(authentication.getName());
        mav.addObject("rolesusuario", rolesusuario);
        List<UserCenter> centrosusuario = this.usuarioService.getCentersUser(authentication.getName());
        mav.addObject("centrosusuario", centrosusuario);
        return mav;
    }
    
    
    /**
     * Custom handler for editing a user.
     *
     * @param username the ID of the user to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("editUser")
    public ModelAndView editUser() {
        ModelAndView mav = new ModelAndView("users/enterForm");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserSistema user = this.usuarioService.getUser(authentication.getName());
        mav.addObject("user",user);
        return mav;
    }
    
    
    @RequestMapping( value="saveUser", method=RequestMethod.POST)
	public ResponseEntity<String> processUpdateUserForm( @RequestParam(value="username", required=true ) String userName
	        , @RequestParam( value="completeName", required=true ) String completeName
	        , @RequestParam( value="email", required=true, defaultValue="" ) String email
	        )
	{
    	try{
	    	UserSistema user = this.usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	    	user.setModifiedBy(user.getUsername());
			user.setCompleteName(completeName);
			user.setEmail(email);
			user.setModified(new Date());
			this.usuarioService.saveUser(user);
			return createJsonResponse(user);
    	}
    	catch(Exception e){
    		Gson gson = new Gson();
    	    String json = gson.toJson(e.toString());
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
	}
    
    @RequestMapping(value = "chgpass", method = RequestMethod.GET)
    public String initChangePassForm() {
	    return "users/chgpass";
    }
    
    @RequestMapping( value="chgPass", method=RequestMethod.POST)
	public ResponseEntity<String> processChangePassForm( @RequestParam( value="password", required=true ) String password
	        )
	{
    	try{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserSistema user = usuarioService.getUser(authentication.getName());
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String encodedPass = encoder.encode(password);
		user.setModifiedBy(authentication.getName());
		user.setModified(new Date());
		user.setPassword(encodedPass);
		user.setLastCredentialChange(new Date());
		user.setCredentialsNonExpired(true);
		this.usuarioService.saveUser(user);
		return createJsonResponse(user);
    	}
    	catch(Exception e){
    		Gson gson = new Gson();
    	    String json = gson.toJson(e.toString());
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
	}
    
    private ResponseEntity<String> createJsonResponse( Object o )
	{
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    Gson gson = new Gson();
	    String json = gson.toJson(o);
	    return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
	}
	
}
