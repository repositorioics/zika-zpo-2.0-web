package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoEstadoEmbarazada;
import ni.org.ics.zpo.v2.service.ZpoEstadoEmbarazadaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario Zpo00Screening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoEstadoEmbarazadaController {
    @Resource(name = "zpoEstadoEmbarazadaService")
    private ZpoEstadoEmbarazadaService zpoEstadoEmbarazadaService;

    private static final Logger logger = LoggerFactory.getLogger(ZpoEstadoEmbarazadaController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEstadoEmb", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoEstadoEmbarazada> getZpoEstadoEmbarazadas() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoEstadoEmbarazada");
        List<ZpoEstadoEmbarazada> zpoEstadoEmbarazada = zpoEstadoEmbarazadaService.getZpoEstadoEmbarazada();
        if (zpoEstadoEmbarazada == null){
            logger.debug("Nulo");
        }
        return zpoEstadoEmbarazada;
    }
    
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoEstadoEmb/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoEstadoEmbarazada> getZpoEstadoEmbarazadas(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoEstadoEmbarazadapara el usuario " +username);
        List<ZpoEstadoEmbarazada> zpoEstadoEmbarazada = zpoEstadoEmbarazadaService.getZpEstadoEmbarazadByUser(username);
        if (zpoEstadoEmbarazada == null){
            logger.debug("Nulo");
        }
        return zpoEstadoEmbarazada;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoEstadoEmbarazada
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoEstadoEmb", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoEstadoEmbarazada(@RequestBody ZpoEstadoEmbarazada[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoEstadoEmbarazada");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoEstadoEmbarazada> zpoEstadoEmbarazadas = Arrays.asList(envio);
            for (ZpoEstadoEmbarazada zpoEstadoEmbarazada : zpoEstadoEmbarazadas){
            	zpoEstadoEmbarazadaService.saveZpoEstadoEmbarazada(zpoEstadoEmbarazada);
            }
        }
        return "Datos recibidos!";
    }
}
