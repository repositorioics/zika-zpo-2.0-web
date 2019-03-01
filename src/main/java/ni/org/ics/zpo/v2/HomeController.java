package ni.org.ics.zpo.v2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import ni.org.ics.zpo.v2.service.DashboardService;
import ni.org.ics.zpo.v2.service.UsuarioService;
import ni.org.ics.zpo.v2.users.model.UserSistema;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/*")
public class HomeController {
    @Resource(name="dashboardService")
	private DashboardService dashboardService;
	@Resource(name="usuarioService")
	private UsuarioService usuarioService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Estudio ZPO Continuación Iniciada");
        UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        DateTime dt2 = new DateTime();
        DateTime dt1 = dt2.minusDays(30);
        long d1 =dt1.getMillis();
        long d2 =dt2.getMillis();
        List<Object> tamizajesDia = dashboardService.tamizajesDia(usuario,d1,d2);
        model.addAttribute("tamizajesDia", tamizajesDia);
        model.addAttribute("usuario", usuario);
        return "home";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
    
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
    	model.addAttribute("error", "true");
		return "login";
	}
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String noAcceso() {
		return "403"; 
	}
	
	@RequestMapping(value="/404", method = RequestMethod.GET)
	public String noEncontrado() { 
		return "404";
	}
    
	@RequestMapping( value="keepsession")
	public @ResponseBody String keepSession()
	{	
		return "OK";
	}
    
    /**
     * Acepta una solicitud GET para JSON
     * @return Un arreglo JSON
	 * @throws ParseException 
     */
	@RequestMapping(value = "updateDashboard", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, List<Object>> fetchDashboardJson(@RequestParam(value = "start", required = true) String fec1,
    		@RequestParam(value = "end", required = true) String fec2) throws ParseException {
        logger.info("Actualizando dashboard");
        UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(fec1);
        Date date2 = formatter.parse(fec2);
        Map<String, List<Object>> mapModel = new HashMap<String, List<Object>>();
        List<Object> tamizajesDia = dashboardService.tamizajesDia(usuario,date1.getTime(),date2.getTime());
        mapModel.put("lista1", tamizajesDia);
        return mapModel;
    }
    
}
