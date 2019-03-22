package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantPsychologicalEvaluation;
import ni.org.ics.zpo.v2.service.ZpoV2InfantPsychologicalEvalService;
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
public class ZpoV2InfantPsychologicalEvalController {
    @Resource(name = "zpoV2InfantPsychologicalEvalService")
    private ZpoV2InfantPsychologicalEvalService zpoV2InfantPsychologicalEvalService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2InfantPsychologicalEvalController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2InfantPsychoEvals", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2InfantPsychologicalEvaluation> getZpoV2InfantPsychologicalEvaluations() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2InfantPsychologicalEvaluation");
        List<ZpoV2InfantPsychologicalEvaluation> zpoV2InfantPsychologicalEvaluations = zpoV2InfantPsychologicalEvalService.getZpoV2InfantPsychologicalEvaluations();
        if (zpoV2InfantPsychologicalEvaluations == null){
            logger.debug("Nulo");
        }
        return zpoV2InfantPsychologicalEvaluations;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoV2InfantPsychologicalEvaluation
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoV2InfantPsychoEvals", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2InfantPsychologicalEvaluations(@RequestBody ZpoV2InfantPsychologicalEvaluation[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoV2InfantPsychologicalEvaluation");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2InfantPsychologicalEvaluation> psychologicalEvaluations = Arrays.asList(envio);
            for (ZpoV2InfantPsychologicalEvaluation psychologicalEvaluation : psychologicalEvaluations){
                zpoV2InfantPsychologicalEvalService.saveOrUpdateZpoV2InfantPsychologicalEval(psychologicalEvaluation);
            }
        }
        return "Datos recibidos!";
    }

}
