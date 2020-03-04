package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2StudyExit;
import ni.org.ics.zpo.v2.service.ZpoV2StudyExitService;
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
public class ZpoV2StudyExitController {

    @Resource(name = "zpoV2StudyExitService")
    private ZpoV2StudyExitService zpoV2StudyExitService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2StudyExitController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoStudyExits", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2StudyExit> getZpoV2StudyExits() {
        logger.info("Descargando toda la informacion de los datos de Salida de Estudio");
        List<ZpoV2StudyExit> zpoV2StudyExits = zpoV2StudyExitService.getStudyExits();
        if (zpoV2StudyExits == null){
            logger.debug("Nulo");
        }
        return zpoV2StudyExits;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2StudyExit
     * @return String con el resultado
     */
    @RequestMapping(value = "saveStudyExit", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2StudyExit(@RequestBody ZpoV2StudyExit[] envio) {
        logger.debug("Insertando/Actualizando Salidas de Estudio");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2StudyExit> zpoStudyExit = Arrays.asList(envio);
            for (ZpoV2StudyExit zpoSE : zpoStudyExit){
                zpoV2StudyExitService.saveOrUpdateStudyExit(zpoSE);
            }
        }
        return "Datos recibidos!";
    }
}
