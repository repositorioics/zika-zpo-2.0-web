package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.Zpo00Screening;
import ni.org.ics.zpo.v2.service.Zpo00ScreeningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario Zpo00Screening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class Zpo00ScreeningController {
    @Resource(name = "zpo00ScreeningService")
    private Zpo00ScreeningService zpo00ScreeningService;

    private static final Logger logger = LoggerFactory.getLogger(Zpo00ScreeningController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpo00Screenings", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Zpo00Screening> getZpo00Screenings() {
        logger.info("Descargando toda la informacion de los datos de los formulario Zpo00Screening");
        List<Zpo00Screening> zpo00Screenings = zpo00ScreeningService.getZpo00Screening();
        if (zpo00Screenings == null){
            logger.debug("Nulo");
        }
        return zpo00Screenings;
    }
    
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpo00Screenings/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Zpo00Screening> getZpo00Screenings(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario Zpo00Screening para el usuario " +username);
        List<Zpo00Screening> zpo00Screenings = zpo00ScreeningService.getZpo00ScreeningByUser(username);
        if (zpo00Screenings == null){
            logger.debug("Nulo");
        }
        return zpo00Screenings;
    }


    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de Zpo00Screening
     * @return String con el resultado
     */
    @RequestMapping(value = "zpo00Screenings", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpo00Screenings(@RequestBody Zpo00Screening[] envio) {
        logger.debug("Insertando/Actualizando formularios Zpo00Screenings");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<Zpo00Screening> zpo00Screenings = Arrays.asList(envio);
            for (Zpo00Screening zpo00Screening : zpo00Screenings){
                zpo00ScreeningService.saveZpo00Screening(zpo00Screening);
            }
        }
        return "Datos recibidos!";
    }
}
