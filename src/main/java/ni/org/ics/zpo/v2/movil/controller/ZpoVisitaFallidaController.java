package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoVisitaFallida;
import ni.org.ics.zpo.v2.service.ZpoVisitaFallidaService;
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
 * Created by Miguel Salinas on 11/29/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoVisitaFallidaController {

    @Resource(name = "zpoVisitaFallidaService")
    private ZpoVisitaFallidaService zpoVisitaFallidaService;

    private static final Logger logger = LoggerFactory.getLogger(ZpoInfantDataController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoVisitasFallidas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoVisitaFallida> getZpoVisitasFallidas() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoVisitaFallida");
        List<ZpoVisitaFallida> zpoVisitasFallidas = zpoVisitaFallidaService.getZpoVisitasFallidas();
        if (zpoVisitasFallidas == null){
            logger.debug("Nulo");
        }
        return zpoVisitasFallidas;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoVisitaFallida
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoVisitasFallidas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    String saveZpoInfantsData(@RequestBody ZpoVisitaFallida[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoVisitaFallida");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoVisitaFallida> zpoVisitaFallidas = Arrays.asList(envio);
            for (ZpoVisitaFallida zpoVisitaFallida : zpoVisitaFallidas){
                zpoVisitaFallidaService.saveZpoVisitaFallida(zpoVisitaFallida);
            }
        }
        return "Datos recibidos!";
    }
}
