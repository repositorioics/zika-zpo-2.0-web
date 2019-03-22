package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2RecoleccionMuestra;
import ni.org.ics.zpo.v2.service.ZpoV2RecoleccionMuestraService;
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
public class ZpoV2RecoleccionMuestraController {

    @Resource(name = "zpoV2RecoleccionMuestraService")
    private ZpoV2RecoleccionMuestraService zpoV2RecoleccionMuestraService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2RecoleccionMuestraController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2Muestras", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2RecoleccionMuestra> getMuestras() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2RecoleccionMuestra");
        List<ZpoV2RecoleccionMuestra> muestras = zpoV2RecoleccionMuestraService.getMuestras();
        if (muestras == null){
            logger.debug("Nulo");
        }
        return muestras;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoV2RecoleccionMuestra
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoV2Muestras", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveMuestras(@RequestBody ZpoV2RecoleccionMuestra[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoV2RecoleccionMuestra");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2RecoleccionMuestra> muestras = Arrays.asList(envio);
            for (ZpoV2RecoleccionMuestra muestra : muestras){
                zpoV2RecoleccionMuestraService.saveOrUpdateMuestra(muestra);
            }
        }
        return "Datos recibidos!";
    }

}
