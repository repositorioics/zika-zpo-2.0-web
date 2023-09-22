package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestVisitaTerreno;
import ni.org.ics.zpo.v2.service.ZpoV2CuestVisitaTerrenoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author ics
 */

@Controller
@RequestMapping("/movil/*")
public class ZpoV2CuestVisitaTerrenoController {


    @Resource(name = "zpoCuestVisitaTerrenoService")
    private ZpoV2CuestVisitaTerrenoService zpoCuestVisitaTerrenoService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2CuestVisitaTerreno.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoCuestVisitasTerreno", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2CuestVisitaTerreno> getZpoCuestVisitasTerreno() {
        logger.info("Descargando toda la informacion de los datos de Cuestionarios de Visita Terreno");
        List<ZpoV2CuestVisitaTerreno> zpoCuestVisTer = zpoCuestVisitaTerrenoService.getZpoCuestionariosVisitaTerreno();
        if (zpoCuestVisTer == null){
            logger.debug("Nulo");
        }
        return zpoCuestVisTer;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2CuestVisitaTerreno
     * @return String con el resultado
     */
    @RequestMapping(value = "saveVisitaTerreno", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2CuestVisitaTerreno(@RequestBody ZpoV2CuestVisitaTerreno[] envio) {
        logger.debug("Insertando/Actualizando Cuestionarios de Visita Terreno");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2CuestVisitaTerreno> zpoCuestionariosVisTer = Arrays.asList(envio);
            for (ZpoV2CuestVisitaTerreno zpoCuestVisTer : zpoCuestionariosVisTer){
                zpoCuestVisitaTerrenoService.saveZpoV2CuestVisitaTerreno(zpoCuestVisTer);
            }
        }
        return "Datos recibidos!";
    }
}
