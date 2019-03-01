package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoControlConsentimientosRecepcion;
import ni.org.ics.zpo.v2.service.ZpoControlConsentimientosRecepcionService;
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
 * Manejo de las solicitudes a la aplicación mediante JSON para el formulario ZpoControlConsentimientosRecepcion
 * Created by FIRSTICT on 12/2/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoControlConsentimientosRecepcionController {

    @Resource(name = "zpoControlConsentimientosRecepcionService")
    private ZpoControlConsentimientosRecepcionService zpoControlConsentimientosRecepcionService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoControlConsentimientosRecepcionController.class);

    
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoRecepcionCons", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoControlConsentimientosRecepcion> getZpoControlConsentimientosRecepcion() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoControlConsentimientosRecepcion");
        List<ZpoControlConsentimientosRecepcion> mZpoControlConsentimientosRecepcion = zpoControlConsentimientosRecepcionService.getZpoControlConsentimientosRecepcion();
        if (mZpoControlConsentimientosRecepcion == null){
            logger.debug("Nulo");
        }
        return mZpoControlConsentimientosRecepcion;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoControlConsentimientosRecepcion
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoRecepcionCons", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    String saveZpoControlConsentimientosRecepcion(@RequestBody ZpoControlConsentimientosRecepcion[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoControlConsentimientosRecepcion");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoControlConsentimientosRecepcion> zpConsRecepcion = Arrays.asList(envio);
            for (ZpoControlConsentimientosRecepcion consentimientosRecepcion : zpConsRecepcion){
                zpoControlConsentimientosRecepcionService.saveZpoControlConsentimientosRecepcion(consentimientosRecepcion);
            }
        }
        return "Datos recibidos!";
    }
}
