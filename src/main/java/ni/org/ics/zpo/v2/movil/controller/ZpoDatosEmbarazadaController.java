package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoDatosEmbarazada;
import ni.org.ics.zpo.v2.service.ZpoDatosEmbarazadaService;
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
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario ZpoScreening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoDatosEmbarazadaController {
    @Resource(name = "zpoDatosEmbarazadaService")
    private ZpoDatosEmbarazadaService zpoDatosEmbarazadaService;

    private static final Logger logger = LoggerFactory.getLogger(ZpoDatosEmbarazadaController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpDatosEmb", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoDatosEmbarazada> getZpoDatosEmbarazadas() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoDatosEmbarazada");
        List<ZpoDatosEmbarazada> zpoDatosEmbarazadas = zpoDatosEmbarazadaService.getZpoDatosEmbarazadas();
        if (zpoDatosEmbarazadas == null){
            logger.debug("Nulo");
        }
        return zpoDatosEmbarazadas;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoDatosEmbarazada
     * @return String con el resultado
     */
    @RequestMapping(value = "zpDatosEmb", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoDatosEmbarazada(@RequestBody ZpoDatosEmbarazada[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoDatosEmbarazada");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoDatosEmbarazada> zpoDatosEmbarazadas = Arrays.asList(envio);
            for (ZpoDatosEmbarazada zpoDatosEmbarazada : zpoDatosEmbarazadas){
            	zpoDatosEmbarazadaService.saveZpoDatosEmbarazada(zpoDatosEmbarazada);
            }
        }
        return "Datos recibidos!";
    }
}
