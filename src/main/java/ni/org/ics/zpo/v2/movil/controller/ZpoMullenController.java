package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoMullen;
import ni.org.ics.zpo.v2.service.ZpoMullenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author ics
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoMullenController {

    @Resource(name = "zpoMullenService")
    private ZpoMullenService zpoMullenService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoMullenController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoMullens", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoMullen> getZpoMullens() {
        logger.info("Descargando toda la informacion de los datos de los formularios Mullen");
        List<ZpoMullen> zpoMullens = zpoMullenService.getZpoMullens();
        if (zpoMullens == null){
            logger.debug("Nulo");
        }
        return zpoMullens;
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param envio Objeto serializado de ZpoMullen
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoMullens", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpoMullens(@RequestBody ZpoMullen[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoMullens");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoMullen> zpoMullens = Arrays.asList(envio);
            for (ZpoMullen zpoMullen : zpoMullens){
                zpoMullenService.saveZpoMullen( zpoMullen );
            }
        }
        return "Datos recibidos!";
    }
}
