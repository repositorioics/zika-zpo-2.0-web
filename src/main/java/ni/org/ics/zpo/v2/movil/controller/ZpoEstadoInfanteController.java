package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoEstadoInfante;
import ni.org.ics.zpo.v2.service.ZpoEstadoInfanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FIRSTICT on 2/10/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoEstadoInfanteController {

    @Resource(name = "zpoEstadoInfanteService")
    private ZpoEstadoInfanteService zpoEstadoInfanteService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoEstadoInfanteController.class);


    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEstadoInfantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoEstadoInfante> ZpoEstadoInfantes() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoEstadoInfante");
        List<ZpoEstadoInfante> zpoEstadoInfantes = zpoEstadoInfanteService.getZpoEstadoInfantes();
        if (zpoEstadoInfantes == null){
            logger.debug("Nulo");
        }
        return zpoEstadoInfantes;
    }

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEstadoInfantes/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoEstadoInfante> getZpoEstadoInfantes(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoEstadoInfante el usuario " +username);
        List<ZpoEstadoInfante> zpoEstadoInfantesByUser = zpoEstadoInfanteService.getZpoEstadoInfantesByUser(username);
        if (zpoEstadoInfantesByUser == null){
            logger.debug("Nulo");
        }
        return zpoEstadoInfantesByUser;
    }
    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoEstadoInfante
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoEstadoInfantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    String saveZpoEstadoInfantes(@RequestBody ZpoEstadoInfante[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoEstadoInfante");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoEstadoInfante> zpoEstadoInfantes = Arrays.asList(envio);
            for (ZpoEstadoInfante zpoEstadoInfante : zpoEstadoInfantes){
                zpoEstadoInfanteService.saveZpoEstadoInfante(zpoEstadoInfante);
            }
        }
        return "Datos recibidos!";
    }
}
