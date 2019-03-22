package ni.org.ics.zpo.v2.movil.controller;

/**
 * Created by Miguel Salinas on 22/03/2019.
 * V1.0
 */

import ni.org.ics.zpo.v2.domain.ZpoV2InfantOtoacousticEmissions;
import ni.org.ics.zpo.v2.service.ZpoInfantOtoacousticEmissionsService;
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
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario ZpoInfantOtoacousticEmissions
 */

@Controller
@RequestMapping("/movil/*")
public class ZpoInfantOtoacousticEmissionsController {

    @Resource(name = "zpoInfantOtoacousticEmissionsService")
    private ZpoInfantOtoacousticEmissionsService zpoInfantOtoacousticEmissionsService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoInfantOtoacousticEmissionsController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoInfantOtoacousticEms", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2InfantOtoacousticEmissions> getZpoInfantOtoacousticEms() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoInfantOacousticEmissions");
        List<ZpoV2InfantOtoacousticEmissions> zpoInfantOtoacousticEms = zpoInfantOtoacousticEmissionsService.getZpoInfantOtoacousticEmissionses();
        if (zpoInfantOtoacousticEms == null){
            logger.debug("Nulo");
        }
        return zpoInfantOtoacousticEms;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoInfantOtoacousticEmissions
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoInfantOtoacousticEms", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoInfantOtoacousticEms(@RequestBody ZpoV2InfantOtoacousticEmissions[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoInfantOtoacousticEmissions");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2InfantOtoacousticEmissions> zpoInfantOtoacousticEms = Arrays.asList(envio);
            for (ZpoV2InfantOtoacousticEmissions zpoInfantOtoacousticEm : zpoInfantOtoacousticEms){
                zpoInfantOtoacousticEmissionsService.saveOrUpdateZpoInfantOtoEm(zpoInfantOtoacousticEm);
            }
        }
        return "Datos recibidos!";
    }

}
