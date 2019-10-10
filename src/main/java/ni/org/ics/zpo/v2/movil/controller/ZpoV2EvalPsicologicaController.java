package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2EvaluacionPsicologica;
import ni.org.ics.zpo.v2.service.ZpoV2EvalPsicologicaService;
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
public class ZpoV2EvalPsicologicaController {


    @Resource(name = "zpoEvalPsicologicaService")
    private ZpoV2EvalPsicologicaService zpoEvalPsicologicaService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2EvaluacionPsicologica.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEvalPsicologicas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2EvaluacionPsicologica> getZpoEvalPsicologicas() {
        logger.info("Descargando toda la informacion de los datos de Evaluación Psicológica");
        List<ZpoV2EvaluacionPsicologica> zpoEvalPsicologicas = zpoEvalPsicologicaService.getZpEvalPsicologicas();
        if (zpoEvalPsicologicas == null){
            logger.debug("Nulo");
        }
        return zpoEvalPsicologicas;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2EvalPsicologica
     * @return String con el resultado
     */
    @RequestMapping(value = "saveEvalPsicologicas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoEvalPsicologicas(@RequestBody ZpoV2EvaluacionPsicologica[] envio) {
        logger.debug("Insertando/Actualizando Evaluacion Psiocologica");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2EvaluacionPsicologica> zpoEvalPsicologica = Arrays.asList(envio);
            for (ZpoV2EvaluacionPsicologica zpoEvalPsico : zpoEvalPsicologica){
                zpoEvalPsicologicaService.saveZpoEvalPsicologica(zpoEvalPsico);
            }
        }
        return "Datos recibidos!";
    }
}
