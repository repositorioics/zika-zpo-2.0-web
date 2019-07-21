package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2IndCuidadoFamilia;
import ni.org.ics.zpo.v2.service.ZpoV2IndCuidadoFamiliarService;
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
public class ZpoV2IndCuidadoFamiliaController {


    @Resource(name = "zpoIndCuidadoFamService")
    private ZpoV2IndCuidadoFamiliarService zpoIndCuidadoFamService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2IndCuidadoFamilia.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoIndCuidadoFams", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2IndCuidadoFamilia> getZpoIndCuidadoFams() {
        logger.info("Descargando toda la informacion de los datos de formularios de Indicadores de Familia");
        List<ZpoV2IndCuidadoFamilia> zpoIndCuidadoFams = zpoIndCuidadoFamService.getZpoIndCuidadFams();
        if (zpoIndCuidadoFams == null){
            logger.debug("Nulo");
        }
        return zpoIndCuidadoFams;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2IndCuidadoFamilia
     * @return String con el resultado
     */
    @RequestMapping(value = "saveZpoIndCuidadoFams", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoIndCuidadoFams(@RequestBody ZpoV2IndCuidadoFamilia[] envio) {
        logger.debug("Insertando/Actualizando formularios de Indicadores de Familia");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2IndCuidadoFamilia> zpoIndCuidadoFams = Arrays.asList(envio);
            for (ZpoV2IndCuidadoFamilia zpoIndCuidadoFam : zpoIndCuidadoFams){
                zpoIndCuidadoFamService.saveZpoIndCuidadoFamilia(zpoIndCuidadoFam);
            }
        }
        return "Datos recibidos!";
    }

}
