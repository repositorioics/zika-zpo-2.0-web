package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2FormAudicion;
import ni.org.ics.zpo.v2.service.ZpoV2FormAudicionService;
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
public class ZpoV2FormAudicionController {


    @Resource(name = "zpoFormAudicionService")
    private ZpoV2FormAudicionService zpoFormAudicionService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2FormAudicionController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoFormAudiciones", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2FormAudicion> getZpoFormAudiciones() {
        logger.info("Descargando toda la informacion de los datos de Evaluaciones Auditivas");
        List<ZpoV2FormAudicion> zpoFormAudiciones = zpoFormAudicionService.getZpoFormAudiciones();
        if (zpoFormAudiciones == null){
            logger.debug("Nulo");
        }
        return zpoFormAudiciones;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2FormAudicion
     * @return String con el resultado
     */
    @RequestMapping(value = "saveFormAudiciones", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoFormAudiciones(@RequestBody ZpoV2FormAudicion[] envio) {
        logger.debug("Insertando/Actualizando Evaluaciones Auditivas");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2FormAudicion> zpoFormAudicion = Arrays.asList(envio);
            for (ZpoV2FormAudicion zpoFormAudi : zpoFormAudicion){
                zpoFormAudicionService.saveZpoFormAudicion(zpoFormAudi);
            }
        }
        return "Datos recibidos!";
    }
}
