package ni.org.ics.zpo.v2.web.controller;

import ni.org.ics.zpo.v2.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by FIRSTICT on 11/14/2016.
 * V1.0
 */
@Controller
@RequestMapping("/admin/query/*")
public class QueryController {
    private static final Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Resource(name="queryService")
    private QueryService queryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerUsuarios(Model model) throws ParseException, Exception {
        logger.debug("Pantalla de inicio exportación JSP");
        return "query/enterForm";
    }

    @RequestMapping(value = "getResulQuery", method = RequestMethod.GET)
    public void getResulQuery(@RequestParam(value = "query", required = false) String query,
                        HttpServletResponse response) throws Exception {
        StringBuffer registros = queryService.getResultQuery(query);
        InputStream inputStream = new ByteArrayInputStream(registros.toString().getBytes());
        String mimeType = "text/csv";
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + "query.csv" +"\""));
        response.setContentLength(registros.length());
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
