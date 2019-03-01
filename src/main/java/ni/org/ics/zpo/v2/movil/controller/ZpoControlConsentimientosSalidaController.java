package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoControlConsentimientosSalida;
import ni.org.ics.zpo.v2.service.ZpoControlConsentimientosSalidaService;
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
 * Manejo de las solicitudes a la aplicación mediante JSON para el formulario ZpoControlConsentimientosSalida
 * Created by FIRSTICT on 11/11/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoControlConsentimientosSalidaController {

    @Resource(name = "zpoControlConsentimientosSalidaService")
    private ZpoControlConsentimientosSalidaService zpoControlConsentimientosSalidaService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoControlConsentimientosSalidaController.class);

    
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoSalidaCons", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoControlConsentimientosSalida> getZpoControlConsentimientosSalida() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoControlConsentimientosSalida");
        List<ZpoControlConsentimientosSalida> mZpoControlConsentimientosSalida = zpoControlConsentimientosSalidaService.getZpoControlConsentimientosSalida();
        if (mZpoControlConsentimientosSalida == null){
            logger.debug("Nulo");
        }
        return mZpoControlConsentimientosSalida;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoControlConsentimientosSalida
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoSalidaCons", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoControlConsentimientosSalida(@RequestBody ZpoControlConsentimientosSalida[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoControlConsentimientosSalida");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoControlConsentimientosSalida> zpConsSal = Arrays.asList(envio);
            for (ZpoControlConsentimientosSalida zpPreScreening : zpConsSal){
            	zpoControlConsentimientosSalidaService.saveZpoControlConsentimientosSalida(zpPreScreening);
            }
        }
        return "Datos recibidos!";
    }
}
