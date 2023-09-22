package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoV2CuestionarioSocioeconomico;
import ni.org.ics.zpo.v2.service.ZpoV2CuestSocioeconomicoService;
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
public class ZpoV2CuestSocioeconomicoController {


    @Resource(name = "zpoCuestSocieconomicoService")
    private ZpoV2CuestSocioeconomicoService zpoCuestSocieconomicoService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoV2CuestionarioSocioeconomico.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoCuestSocioecs", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoV2CuestionarioSocioeconomico> getZpoCuestSociecs() {
        logger.info("Descargando toda la informacion de los datos de Cuestionarios Socioeconomicos");
        List<ZpoV2CuestionarioSocioeconomico> zpoCuestSocioecs = zpoCuestSocieconomicoService.getZpoCuestSocieconomicos();
        if (zpoCuestSocioecs == null){
            logger.debug("Nulo");
        }
        return zpoCuestSocioecs;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoV2CuestionarioSocioeconomico
     * @return String con el resultado
     */
    @RequestMapping(value = "saveCuestSocioecs", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoV2CuestSocioeconomico(@RequestBody ZpoV2CuestionarioSocioeconomico[] envio) {
        logger.debug("Insertando/Actualizando Cuestionario Socioeconomico");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoV2CuestionarioSocioeconomico> zpoCuestSocioecons = Arrays.asList(envio);
            for (ZpoV2CuestionarioSocioeconomico zpoCuestSocioec : zpoCuestSocioecons){
                zpoCuestSocieconomicoService.saveZpoCuestSocioeconomico(zpoCuestSocioec);
            }
        }
        return "Datos recibidos!";
    }
}
