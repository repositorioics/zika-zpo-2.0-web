package ni.org.ics.zpo.v2.movil.controller;

import ni.org.ics.zpo.v2.domain.ZpoInfantData;
import ni.org.ics.zpo.v2.service.ZpoInfantDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by FIRSTICT on 24/10/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpoInfantDataController {
    @Resource(name = "zpoInfantService")
    private ZpoInfantDataService zpoInfantDataService;
    private static final Logger logger = LoggerFactory.getLogger(ZpoInfantDataController.class);


    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoInfants", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoInfantData> getZpoInfantsData() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoInfantData");
        List<ZpoInfantData> zpoInfantData = zpoInfantDataService.getZpoInfantData();
        if (zpoInfantData == null){
            logger.debug("Nulo");
        }
        return zpoInfantData;
    }

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpoInfants/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpoInfantData> getZpoInfantsData(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpoInfantData el usuario " +username);
        List<ZpoInfantData> zpoInfantsDataByUser = zpoInfantDataService.getZpoInfantsDataByUser(username);
        if (zpoInfantsDataByUser == null){
            logger.debug("Nulo");
        }
        return zpoInfantsDataByUser;
    }
    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpoInfantData
     * @return String con el resultado
     */
    @RequestMapping(value = "zpoInfants", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    String saveZpoInfantsData(@RequestBody ZpoInfantData[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpoInfantData");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpoInfantData> zpoInfantDatas = Arrays.asList(envio);
            for (ZpoInfantData zpoInfantData : zpoInfantDatas){
                zpoInfantDataService.saveZpoInfantData(zpoInfantData);
            }
        }
        return "Datos recibidos!";
    }
}
