package ni.org.ics.zpo.v2.web.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ni.org.ics.zpo.v2.service.EditarDatosService;
import ni.org.ics.zpo.v2.service.ExportarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FIRSTICT on 2/16/2017.
 * V1.0
 */
@Controller
@RequestMapping("/admin/editdata/*")
public class EditarDatosController {

    private static final Logger logger = LoggerFactory.getLogger(EditarDatosController.class);

    @Resource(name="exportarService")
    private ExportarService exportarService;

    @Resource(name="editarDatosService")
    private EditarDatosService editarDatosService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerUsuarios(Model model) throws ParseException, Exception {
        logger.debug("Pantalla de inicio editar datos de formularios JSP");
        List<String> eventos = exportarService.getCompleteRedCapEvents();
        model.addAttribute("eventos",eventos);
        return "admin/editdata/enterForm";
    }

    @RequestMapping(value = "getPropertiesName", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<String> getPropertiesName(@RequestParam(value = "tabla", required = true) String tabla) throws Exception {
        return editarDatosService.getTableMetaData(tabla);
    }

    @RequestMapping(value = "updatePropertie", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    protected void updatePropertie(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String resultado = "";
        String error = "";
        String json = "";
        String tabla = null, evento=null,id=null,propiedad=null,valor = null;
        boolean setNull = false;
        String actorId = obtenerNombreUsuario();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF8"));
            json = br.readLine();
            //Recuperando Json enviado desde el cliente
            JsonObject jsonpObject = new Gson().fromJson(json, JsonObject.class);

            if(jsonpObject.get("tabla") != null && !jsonpObject.get("tabla").getAsString().isEmpty() ) {
                tabla = jsonpObject.get("tabla").getAsString();
            }
            if(jsonpObject.get("evento") != null && !jsonpObject.get("evento").getAsString().isEmpty() && !jsonpObject.get("evento").getAsString().equalsIgnoreCase("any") ) {
                evento = jsonpObject.get("evento").getAsString();
            }
            if(jsonpObject.get("id") != null && !jsonpObject.get("id").getAsString().isEmpty() ) {
                id = jsonpObject.get("id").getAsString();
            }
            if(jsonpObject.get("propiedad") != null && !jsonpObject.get("propiedad").getAsString().isEmpty() ) {
                propiedad = jsonpObject.get("propiedad").getAsString();
            }
            if(jsonpObject.get("valor") != null && !jsonpObject.get("valor").getAsString().isEmpty() ) {
                valor = jsonpObject.get("valor").getAsString();
            }
            if(jsonpObject.get("nulo") != null && !jsonpObject.get("nulo").getAsString().isEmpty() ) {
                setNull = jsonpObject.get("nulo").getAsBoolean();
            }

            int registroafectados = editarDatosService.updateProperty(tabla,evento,id,propiedad,valor, setNull, actorId);
            resultado = "se modificaron "+ String.valueOf(registroafectados) + " registros" ;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            ex.printStackTrace();
            resultado = resultado + ". \n " + ex.toString();
            error = "error";
        } finally {
            Map<String, String> map = new HashMap<String, String>();
            map.put("mensaje", resultado);
            map.put("error",error);
            map.put("tabla", "");
            map.put("evento", "");
            map.put("id", "");
            map.put("propiedad", "");
            map.put("valor", "");
            map.put("nulo", "");
            String jsonResponse = new Gson().toJson(map);
            response.getOutputStream().write(jsonResponse.getBytes());
            response.getOutputStream().close();
        }
    }

    public String obtenerNombreUsuario(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
