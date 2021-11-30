package ni.org.ics.zpo.v2.web.controller;

import ni.org.ics.zpo.v2.service.ExportarService;
import ni.org.ics.zpo.v2.utils.Constants;
import ni.org.ics.zpo.v2.utils.ExportParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Created by FIRSTICT on 11/10/2016.
 * V1.0
 */
@Controller
@RequestMapping("/admin/export/*")
public class ExportarController {

    private static final Logger logger = LoggerFactory.getLogger(ExportarController.class);

    @Resource(name="exportarService")
    private ExportarService exportarService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerUsuarios(Model model) throws ParseException, Exception {
        logger.debug("Pantalla de inicio exportación JSP");
        List<String> eventos = exportarService.getEventsExport();
        model.addAttribute("eventos",eventos);
        return "export/enterForm";
    }

    @RequestMapping(value = "getZpoV2CuestDemo", method = RequestMethod.GET)
    public void getZpoV2CuestDemo (@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                @RequestParam(value = "event", required = false) String event,
                                HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "ZpoV2DemoQuestionnaire.csv" +"\""));
        PrintWriter w = res.getWriter();
        //String ev = Constants.MONTHS24;
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_DEMO,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestDemoExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2CuestDemoUpd", method = RequestMethod.GET)
    public void getZpoV2CuestDemoUpdate (@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                @RequestParam(value = "event", required = false) String event,
                                HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "ZpoV2DemoQuestionnaireUpd.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_DEMO_UPD,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestDemoUpdExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2StudyExit", method = RequestMethod.GET)
    public void getZpoV2StudyForm (@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                         @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                         @RequestParam(value = "event", required = false) String event,
                                         HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "ZpoV2DiscontinuationForm.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_STUDY_EXIT,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2StudyExitExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2CuestSocio", method = RequestMethod.GET)
    public void getZpoV2CuestSocio(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                   @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                   @RequestParam(value = "event", required = false) String event,
                                   HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "ZpoV2SocioeQuestionnaire.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_CUEST_SOCIO,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestSocioExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }


    @RequestMapping(value = "getZpoV2CuestSaludInfantil", method = RequestMethod.GET)
    public void getZpoV2CuestSaludInfantil(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                   @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                   @RequestParam(value = "event", required = false) String event,
                                   HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2ChildHealthQuestionnaire.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_SA_INF,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestSaInfExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2CuestSaludInfantilUpd", method = RequestMethod.GET)
    public void getZpoV2CuestSaludInfantilUpd(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                           @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                           @RequestParam(value = "event", required = false) String event,
                                           HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2ChildHealthQuestionnaireUpd.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_SA_INF_UPD,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestSaInfUpdExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }


    @RequestMapping(value = "getZpoV2ExamFisInf", method = RequestMethod.GET)
    public void getZpoV2ExamFisInf(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                              @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                              @RequestParam(value = "event", required = false) String event,
                                              HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2ChildPhysicalExam.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_EXAM_FIS_INF,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2ExamFisInfExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2CuestSaludMaterna", method = RequestMethod.GET)
    public void getZpoV2CuestSaludMaterna(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                           @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                           @RequestParam(value = "event", required = false) String event,
                                           HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2MaternalHealthQuestionnaire.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_SA_MAT,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestSaMatExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2CuestSaludMaternaUpd", method = RequestMethod.GET)
    public void getZpoV2CuestSaludMaternaUpd(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                              @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                              @RequestParam(value = "event", required = false) String event,
                                              HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2MaternalHealthQuestionnaireUpd.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_CUEST_SA_MAT_UPD,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2CuestSaludMaternaUpdExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2IndCuidadoFamilia", method = RequestMethod.GET)
    public void getZpoV2IndCuidadoFamilia(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                             @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                             @RequestParam(value = "event", required = false) String event,
                                             HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2FamilyCareIndQuestionnaire.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_IND_CUI_FAM,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2IndCuidadoFamiliaExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2Mullen", method = RequestMethod.GET)
    public void getZpoV2Mullen(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                          @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                          @RequestParam(value = "event", required = false) String event,
                                          HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2Mullen.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_MULLEN,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2MullenExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2EvalVisual", method = RequestMethod.GET)
    public void getZpoV2EvalVisual(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                               @RequestParam(value = "codigoFin", required = false) String codigoFin,
                               @RequestParam(value = "event", required = false) String event,
                               HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2OphtForm.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_EVAL_VISUAL,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2EvalVisualExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2EvalAuditiva", method = RequestMethod.GET)
    public void getZpoV2EvalAuditiva(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                   @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                   @RequestParam(value = "event", required = false) String event,
                                   HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2HearingForm.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_EVAL_AUDITIVA,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2EvalAuditivaExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2EvalPsico", method = RequestMethod.GET)
    public void getZpoV2EvalPsico(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                     @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                     @RequestParam(value = "event", required = false) String event,
                                     HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2PsychologicalEval.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_PSYC_EVAL,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2EvalPsicoExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2EdadesEtapas42", method = RequestMethod.GET)
    public void getZpoV2EdadesEtapas(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                  @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                  @RequestParam(value = "event", required = false) String event,
                                  HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2ASQ42.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_EDADES_ETAPAS_42,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2EdadesEtapasExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getZpoV2BiosColl", method = RequestMethod.GET)
    public void getZpoV2BiosColl(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                     @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                     @RequestParam(value = "event", required = false) String event,
                                     HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2BloodSample.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.TABLE_ZPOV2_BIOS_COLL,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2BiosCollExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public void getAllFormsNuevo(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                 @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                 @RequestParam(value = "event", required = false) String event,
                                 HttpServletResponse res) throws Exception {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "allFormsZpoV2.csv" +"\""));
        PrintWriter w = res.getWriter();
        String todasTablas = null;
        StringBuffer registros = null;
        todasTablas = Constants.VIEW_ZPOV2_CUEST_DEMO + "," + Constants.VIEW_ZPOV2_CUEST_DEMO_UPD + "," + Constants.TABLE_ZPOV2_STUDY_EXIT + "," + Constants.TABLE_ZPOV2_CUEST_SOCIO + "," + Constants.VIEW_ZPOV2_CUEST_SA_INF + "," + Constants.VIEW_ZPOV2_CUEST_SA_INF_UPD + "," + Constants.TABLE_ZPOV2_EXAM_FIS_INF + "," + Constants.VIEW_ZPOV2_CUEST_SA_MAT + "," + Constants.VIEW_ZPOV2_CUEST_SA_MAT_UPD  + "," + Constants.TABLE_ZPOV2_IND_CUI_FAM + "," + Constants.TABLE_ZPOV2_BIOS_COLL + "," + Constants.VIEW_ZPOV2_MULLEN  + "," + Constants.TABLE_ZPOV2_EVAL_VISUAL  + "," + Constants.VIEW_ZPOV2_EVAL_AUDI + "," + Constants.TABLE_ZPOV2_PSYC_EVAL + "," + Constants.VIEW_ZPOV2_EDADES_ETAPAS_42 ;
        ExportParameters ep = new ExportParameters(todasTablas,codigoInicio,codigoFin,event);

        try {
            if (!event.equalsIgnoreCase("all")) {
                ep.setAddHeader(true);
                registros = exportarService.getAllExportData(ep);
            } else {
                registros = new StringBuffer();
                List<String> events = exportarService.getEventsExport();
                for (String evento : events) {
                    ep.setEvent(evento);
                    if (evento.equalsIgnoreCase(Constants.MONTHS24)) ep.setAddHeader(true);
                    else ep.setAddHeader(false);
                    registros.append(exportarService.getAllExportData(ep));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }


    @RequestMapping(value = "getZpoV2EdadesEtapas54", method = RequestMethod.GET)
    public void getZpoV2EdadesEtapas54(@RequestParam(value = "codigoInicio", required = false) String codigoInicio,
                                     @RequestParam(value = "codigoFin", required = false) String codigoFin,
                                     @RequestParam(value = "event", required = false) String event,
                                     HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/csv");
        res.setHeader("Content-Disposition", String.format("inline; filename=\"" + "getZpoV2ASQ54.csv" +"\""));
        PrintWriter w = res.getWriter();
        ExportParameters ep = new ExportParameters(Constants.VIEW_ZPOV2_EDADES_ETAPAS_54,codigoInicio,codigoFin,event);
        StringBuffer registros = null;
        try {
            registros = exportarService.getZpoV2EdadesEtapas54ExportData(ep);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w.println(registros);
        w.flush();
        w.close();
    }



}
