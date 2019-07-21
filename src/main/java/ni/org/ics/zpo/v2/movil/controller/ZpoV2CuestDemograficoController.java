package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioDemografico;
import ni.org.ics.zpo.v2.service.ZpoV2CuestDemograficoService;
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
public class ZpoV2CuestDemograficoController {


    @Resource(name = "zpoCuestDemograficoService")
    private ZpoV2CuestDemograficoService zpoCuestDemograficoService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2CuestionarioDemografico.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoCuestDemograficos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2CuestionarioDemografico> getZpoCuestDemos() {
        logger.info("Descargando toda la informacion de los datos de Cuestionarios Demográficos");
        List<ZpoV2CuestionarioDemografico> zpoCuestDemograficos = zpoCuestDemograficoService.getZpoCuestDemograficos();
        if (zpoCuestDemograficos == null){
            logger.debug("Nulo");
        }
        return zpoCuestDemograficos;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2CuestionarioDemografico
     * @return String con el resultado
     */
    @RequestMapping(value = "saveCuestDemograficos", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoIndCuidadoFams(@RequestBody ZpoV2CuestionarioDemografico[] envio) {
        logger.debug("Insertando/Actualizando Cuestionario Demográfico");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2CuestionarioDemografico> zpoCuestDemograficos = Arrays.asList(envio);
            for (ZpoV2CuestionarioDemografico zpoCuestDemog : zpoCuestDemograficos){
                zpoCuestDemograficoService.saveZpoCuestDemografico(zpoCuestDemog);
            }
        }
        return "Datos recibidos!";
    }
}
