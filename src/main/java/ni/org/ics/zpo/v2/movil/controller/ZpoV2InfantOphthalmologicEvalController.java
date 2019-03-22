package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOphthalmologicEvaluation;
import ni.org.ics.zpo.v2.service.ZpoV2InfantOphthalmologicEvalService;
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
 * Created by Miguel Salinas on 22/03/2019.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoV2InfantOphthalmologicEvalController {
    @Resource(name = "zpoV2InfantOphthalmologicEvalService")
    private ZpoV2InfantOphthalmologicEvalService zpoV2InfantOphthalmologicEvalService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2InfantOphthalmologicEvalController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2InfantOphthaEvals", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2InfantOphthalmologicEvaluation> getZpoV2InfantOphthalmologicEvaluations() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2InfantOphthalmologicEvaluation");
        List<ZpoV2InfantOphthalmologicEvaluation> zpoV2InfantOphthalmologicEvaluations = zpoV2InfantOphthalmologicEvalService.getZpoV2InfantOphthalmologicEvaluations();
        if (zpoV2InfantOphthalmologicEvaluations == null){
            logger.debug("Nulo");
        }
        return zpoV2InfantOphthalmologicEvaluations;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoV2InfantOphthalmologicEvaluation
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoV2InfantOphthaEvals", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2InfantOphthalmologicEvaluations(@RequestBody ZpoV2InfantOphthalmologicEvaluation[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoV2InfantOphthalmologicEvaluation");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2InfantOphthalmologicEvaluation> ophthalmologicEvaluations = Arrays.asList(envio);
            for (ZpoV2InfantOphthalmologicEvaluation ophthalmologicEvaluation : ophthalmologicEvaluations){
                zpoV2InfantOphthalmologicEvalService.saverOrUpdateZpoV2InfantOphthalmologicEval(ophthalmologicEvaluation);
            }
        }
        return "Datos recibidos!";
    }

}
