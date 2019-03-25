package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOphtResults;
import ni.org.ics.zpo.v2.service.ZpoV2InfantOphtResultsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario ZpoV2InfantOphtResults
 * Created by FIRSTICT on 25/03/2019.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoV2InfantOphtResultsController {

    @Resource(name = "zpoV2InfantOphtResultsService")
    private ZpoV2InfantOphtResultsService zpoV2InfantOphtResultsService;

    private static final Logger logger = LoggerFactory.getLogger(ZpoV2InfantOphtResultsController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2InfantOphtResults", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2InfantOphtResults> getZpoV2InfantOphtResults() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2InfantOphtResults");
        List<ZpoV2InfantOphtResults> zpoV2InfantOphtResults = zpoV2InfantOphtResultsService.getZpoV2InfantOphtResults();
        if (zpoV2InfantOphtResults == null){
            logger.debug("Nulo");
        }
        return zpoV2InfantOphtResults;
    }

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2InfantOphtResults/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2InfantOphtResults> getZpoV2InfantOphtResultstByUser(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2InfantOphtResults para el usuario " +username);
        List<ZpoV2InfantOphtResults> zpoV2InfantOphtResultstByUser = zpoV2InfantOphtResultsService.getZpoV2InfantOphtResultstByUser(username);
        if (zpoV2InfantOphtResultstByUser == null){
            logger.debug("Nulo");
        }
        return zpoV2InfantOphtResultstByUser;
    }

    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param envio Objeto serializado de ZpoV2InfantOphtResults
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoV2InfantOphtResults", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2InfantOphtResults(@RequestBody ZpoV2InfantOphtResults[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoV2InfantOphtResults");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2InfantOphtResults> zpoV2InfantOphtResultses = Arrays.asList(envio);
            for (ZpoV2InfantOphtResults zpoV2InfantOphtResults : zpoV2InfantOphtResultses){
                zpoV2InfantOphtResultsService.saveZpoV2InfantOphtResults(zpoV2InfantOphtResults);
            }
        }
        return "Datos recibidos!";
    }
}
