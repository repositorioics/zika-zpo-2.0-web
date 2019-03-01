package ni.org.ics.zpo.v2.movil.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.zpo.v2.service.UsuarioService;
import ni.org.ics.zpo.v2.users.model.Authority;
import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/movil/*")
public class UsuariosMovilController {
	@Resource(name="usuarioService")
	private UsuarioService usuarioService;
	private static final Logger logger = LoggerFactory.getLogger(UsuariosMovilController.class);
	
	
	@RequestMapping(value = "ingreso/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UserSistema getMessage(@PathVariable String username) {
    	logger.info("Accessando a la aplicacion " + username);
    	UserSistema user = usuarioService.getUser(username);
    	return user;
    }
	
    /**
     * Retorna roles. Acepta una solicitud GET para JSON
     * @return barrios JSON
     */
    @RequestMapping(value = "roles/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Authority> descargarRolesUsuario(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los roles para el usuario "+username);
        List<Authority> roles = usuarioService.getRolesUsuario(username);
        if (roles == null){
        	logger.debug(new Date() + " - Nulo");
        }
        else{
        	for (Authority auth : roles) {
        		auth.setUser(null);
        		auth.setRol(null);
        	}
        }
        return roles;	
    }
       
}
