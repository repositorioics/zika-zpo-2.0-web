package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2EvaluacionVisual;
import ni.org.ics.zpo.v2.service.ZpoV2EvalVisualService;
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
public class ZpoV2EvalVisualController {


    @Resource(name = "zpoEvalVisualService")
    private ZpoV2EvalVisualService zpoV2EvalVisualService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2EvalVisualController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEvalVisuales", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2EvaluacionVisual> getZpoEvalVisuales() {
        logger.info("Descargando toda la informacion de los datos de Evaluaciones Visuales");
        List<ZpoV2EvaluacionVisual> zpoEvalVisuales = zpoV2EvalVisualService.getZpoEvalVisuales();
        if (zpoEvalVisuales == null){
            logger.debug("Nulo");
        }
        return zpoEvalVisuales;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2EvaluacionVisual
     * @return String con el resultado
     */
    @RequestMapping(value = "saveEvalVisuales", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoEvalVisuales(@RequestBody ZpoV2EvaluacionVisual[] envio) {
        logger.debug("Insertando/Actualizando Evaluaciones Visuales");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2EvaluacionVisual> zpoEvVisual = Arrays.asList(envio);
            for (ZpoV2EvaluacionVisual zpoEV : zpoEvVisual){
                zpoV2EvalVisualService.saveZpoEvalVisual(zpoEV);
            }
        }
        return "Datos recibidos!";
    }
}
