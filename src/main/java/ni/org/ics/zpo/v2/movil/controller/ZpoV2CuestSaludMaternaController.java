package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioSaludMaterna;
import ni.org.ics.zpo.v2.service.ZpoV2CuestSaludMaternaService;
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
public class ZpoV2CuestSaludMaternaController {


    @Resource(name = "zpoCuestSaludMaternaService")
    private ZpoV2CuestSaludMaternaService zpoCuestSaludMaternaService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2CuestionarioSaludMaterna.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoCuestSaludMaterna", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2CuestionarioSaludMaterna> getZpoCuestSaludMaterna() {
        logger.info("Descargando toda la informacion de los datos de Cuestionarios de Salud Materna");
        List<ZpoV2CuestionarioSaludMaterna> zpoCuestSaludMaterna = zpoCuestSaludMaternaService.getZpoCuestSaludMaterna();
        if (zpoCuestSaludMaterna == null){
            logger.debug("Nulo");
        }
        return zpoCuestSaludMaterna;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2CuestSaludMaterna
     * @return String con el resultado
     */
    @RequestMapping(value = "saveZpoCuestSaludMaterna", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoCuestSaludMaterna(@RequestBody ZpoV2CuestionarioSaludMaterna[] envio) {
        logger.debug("Insertando/Actualizando Cuestionarios de Salud Materna ");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2CuestionarioSaludMaterna> zpoCuestSaludMat = Arrays.asList(envio);
            for (ZpoV2CuestionarioSaludMaterna zpoCuestSaMat : zpoCuestSaludMat){
                zpoCuestSaludMaternaService.saveZpoCuestSaludMaterna(zpoCuestSaMat);
            }
        }
        return "Datos recibidos!";
    }

}
