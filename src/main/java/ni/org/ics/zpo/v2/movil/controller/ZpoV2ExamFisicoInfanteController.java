package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2ExamenFisicoInfante;
import ni.org.ics.zpo.v2.service.ZpoV2ExamenFisicoInfanteService;
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
public class ZpoV2ExamFisicoInfanteController {


    @Resource(name = "zpoExamFisicoInfanteService")
    private ZpoV2ExamenFisicoInfanteService zpoExamFisicoInfanteService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2ExamFisicoInfanteController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoExamFisicoInfantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2ExamenFisicoInfante> getZpoExamFisicoInfantes() {
        logger.info("Descargando toda la informacion de los datos de Examenes Fisicos de Infantes");
        List<ZpoV2ExamenFisicoInfante> zpoExamFisicoInfantes = zpoExamFisicoInfanteService.getZpoExamFisicoInfantes();
        if (zpoExamFisicoInfantes == null){
            logger.debug("Nulo");
        }
        return zpoExamFisicoInfantes;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2ExamenFisicoInfante
     * @return String con el resultado
     */
    @RequestMapping(value = "saveExamFisicoInfantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoExamFisicoInfantes(@RequestBody ZpoV2ExamenFisicoInfante[] envio) {
        logger.debug("Insertando/Actualizando Examenes Fisicos Infantes");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2ExamenFisicoInfante> zpoExamFisicoInfante = Arrays.asList(envio);
            for (ZpoV2ExamenFisicoInfante zpoExamFisInf : zpoExamFisicoInfante){
                zpoExamFisicoInfanteService.saveZpoExamFisicoInfante(zpoExamFisInf);
            }
        }
        return "Datos recibidos!";
    }
}
