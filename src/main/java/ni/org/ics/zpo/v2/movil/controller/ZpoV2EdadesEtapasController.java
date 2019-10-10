package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2EdadesEtapas;
import ni.org.ics.zpo.v2.service.ZpoV2EdadesEtapasService;
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
public class ZpoV2EdadesEtapasController {
    @Resource(name = "zpoV2EdadesEtapasService")
    private ZpoV2EdadesEtapasService zpoV2EdadesEtapasService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2EdadesEtapasController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoV2EdadesEtapas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2EdadesEtapas> getZpoV2InfantOphthalmologicEvaluations() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoV2EdadesEtapas");
        List<ZpoV2EdadesEtapas> zpoV2EdadesEtapas = zpoV2EdadesEtapasService.getZpoV2EdadesEtapas();
        if (zpoV2EdadesEtapas == null){
            logger.debug("Nulo");
        }
        return zpoV2EdadesEtapas;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2EdadesEtapas
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoV2EE", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2EdadesEtapas(@RequestBody ZpoV2EdadesEtapas[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoV2EdadesEtapas");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2EdadesEtapas> zpoV2EdadesEtapas = Arrays.asList(envio);
            for (ZpoV2EdadesEtapas ee : zpoV2EdadesEtapas){
                zpoV2EdadesEtapasService.saverOrUpdateZpoV2EdadesEtapas(ee);
            }
        }
        return "Datos recibidos!";
    }

}
