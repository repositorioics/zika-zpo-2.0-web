package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestSaludInfantil;
import ni.org.ics.zpo.v2.service.ZpoV2CuestSaludInfantilService;
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
public class ZpoV2CuestSaludInfantilController {


    @Resource(name = "zpoCuestSaludInfantilService")
    private ZpoV2CuestSaludInfantilService zpoCuestSaludInfantilService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2CuestSaludInfantil.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoCuestSaludInfantil", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2CuestSaludInfantil> getZpoCuestSaludInfantil() {
        logger.info("Descargando toda la informacion de los datos de Cuestionarios de Salud Infantil");
        List<ZpoV2CuestSaludInfantil> zpoCuestSaludInfantil = zpoCuestSaludInfantilService.getZpoCuestSaludInfantil();
        if (zpoCuestSaludInfantil == null){
            logger.debug("Nulo");
        }
        return zpoCuestSaludInfantil;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2CuestSaludInfantil
     * @return String con el resultado
     */
    @RequestMapping(value = "saveZpoCuestSaludInfantil", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoCuestSaludInfantil(@RequestBody ZpoV2CuestSaludInfantil[] envio) {
        logger.debug("Insertando/Actualizando Cuestionarios de Salud Infantil ");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2CuestSaludInfantil> zpoCuestSaludInfantil = Arrays.asList(envio);
            for (ZpoV2CuestSaludInfantil zpoCuestSaInf : zpoCuestSaludInfantil){
                zpoCuestSaludInfantilService.saveZpoCuestSaludInfantil(zpoCuestSaInf);
            }
        }
        return "Datos recibidos!";
    }

}
