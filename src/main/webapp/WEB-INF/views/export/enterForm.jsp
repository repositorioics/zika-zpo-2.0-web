<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--[if IE 8]> <html class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<jsp:include page="../fragments/headTag.jsp" />
<!-- BEGIN PAGE LEVEL STYLES -->
<spring:url value="/resources/plugins/select2/select2_conquer.css" var="sel2css" />
<link rel="stylesheet" type="text/css" href="${sel2css}"/>
<spring:url value="/resources/plugins/jquery-multi-select/css/multi-select.css" var="jqmscss" />
<link rel="stylesheet" type="text/css" href="${jqmscss}"/>
<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-fixed page-footer-fixed">
<!-- BEGIN HEADER -->
<jsp:include page="../fragments/bodyHeader.jsp" />
<!-- END HEADER -->
<!-- BEGIN CONTAINER -->
<div class="page-container">
<jsp:include page="../fragments/bodyNavigation.jsp" />
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN STYLE CUSTOMIZER -->
			<jsp:include page="../fragments/bodyCustomizer.jsp" />
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					<spring:message code="title" /> <small><spring:message code="export" /></small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="<spring:url value="/" htmlEscape="true "/>"><spring:message code="home" /></a>
                            <i class="fa fa-angle-right"></i> <a href="<spring:url value="/admin/export/" htmlEscape="true "/>"><spring:message code="export" /></a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN TABLE PORTLET-->
                    <div class="portlet">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-list"></i>
                            </div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse"></a>
                                <a href="javascript:;" class="remove"></a>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <form action="#" autocomplete="off" id="download-form" class="form-horizontal">
                                <div class="form-body">
                                    <div class="alert alert-danger display-hide">
                                        <button class="close" data-close="alert"></button>
                                        <spring:message code="form.errors" />
                                    </div>
                                    <div class="row">
                                        <div class="col col-sm-12 col-md-6 col-lg-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-4"><spring:message code="subjectId.start" />
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <input id="codigoInicio" name="codigoInicio" type="text" value="" class="form-control"/>
                                                            <span class="input-group-addon">
                                                                <i class="fa fa-sort-alpha-asc"></i>
                                                            </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col col-sm-12 col-md-6 col-lg-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-4"><spring:message code="subjectId.end" />
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <input id="codigoFin" name="codigoFin" type="text" value="" class="form-control"/>
                                                            <span class="input-group-addon">
                                                                <i class="fa fa-sort-alpha-asc"></i>
                                                            </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col col-sm-12 col-md-6 col-lg-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-4"><spring:message code="event" />
                                                <span class="required">
                                                     *
                                                </span>
                                                </label>
                                                <div class="col-md-8">
                                                    <select class="form-control" id="zpEvent" name="zpEvent">
                                                        <option value=""><spring:message code="lbl.select" /> ...</option>
                                                        <c:forEach items="${eventos}" var="evento">
                                                            <option value="${evento}"><spring:message code="${evento}" /></option>
                                                        </c:forEach>
                                                        <option value="all"><spring:message code="allforms" /></option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col col-sm-12 col-md-6 col-lg-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-4"><spring:message code="form" />
                                                <span class="required">
                                                     *
                                                </span>
                                                </label>
                                                <div class="col-md-8">
                                                    <select class="form-control" id="zpform" name="zpform">
                                                        <option value=""><spring:message code="lbl.select" /> ...</option>
                                                        <option value="ZpoV2CuestDemo"><spring:message code="zpov2_cuest_demo" /></option>
                                                        <option value="ZpoV2CuestDemoUpd"><spring:message code="zpov2_cuest_demo_upd" /></option>
                                                        <option value="ZpoV2StudyExit"><spring:message code="zpov2_study_exit" /></option>
                                                        <option value="ZpoV2CuestSocio"><spring:message code="zpov2_cuest_socioe" /></option>
                                                        <option value="ZpoV2CuestSaludInfantil"><spring:message code="zpov2_cuest_sa_inf" /></option>
                                                        <option value="ZpoV2CuestSaludInfantilUpd"><spring:message code="zpov2_cuest_sa_inf_upd" /></option>
                                                        <option value="ZpoV2ExamFisInf"><spring:message code="zpov2_exam_fis_inf" /></option>
                                                        <option value="ZpoV2CuestSaludMaterna"><spring:message code="zpov2_cuest_sa_mat" /></option>
                                                        <option value="ZpoV2CuestSaludMaternaUpd"><spring:message code="zpov2_cuest_sa_mat_upd" /></option>
                                                        <option value="ZpoV2IndCuidadoFamilia"><spring:message code="zpov2_ind_cuidado_fam" /></option>
                                                        <option value="ZpoV2BiosColl"><spring:message code="zpov2_biosp_coll" /></option>
                                                        <option value="ZpoV2Mullen"><spring:message code="zpov2_mullen" /></option>
                                                        <option value="ZpoV2EvalVisual"><spring:message code="zpov2_eval_visual" /></option>
                                                        <option value="ZpoV2EvalAuditiva"><spring:message code="zpov2_eval_audi" /></option>
                                                        <option value="ZpoV2EvalPsico"><spring:message code="zpov2_eval_psico" /></option>
                                                        <option value="ZpoV2EdadesEtapas42"><spring:message code="zpov2_edades_etapas42" /></option>
                                                        <option value="ZpoV2EdadesEtapas54"><spring:message code="zpov2_edades_etapas54" /></option>
                                                        <option value="all"><spring:message code="allforms" /></option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-actions fluid">
                                    <div class="col-md-offset-6 col-md-6">
                                        <button id="guardar" type="submit" class="btn btn-success"><spring:message code="download" /></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- END TABLE PORTLET-->
                </div>
            </div>
			<!-- END PAGE CONTENT -->
		</div>
	</div>
</div>
<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<jsp:include page="../fragments/bodyFooter.jsp" />
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<jsp:include page="../fragments/corePlugins.jsp" />
<jsp:include page="../fragments/bodyUtils.jsp" />
<!-- BEGIN PAGE LEVEL PLUGINS -->

<!-- DATA TABLE-->
<c:choose>
    <c:when test="${cookie.zikav2Lang.value == null}">
        <c:set var="lenguaje" value="es"/>
    </c:when>
    <c:otherwise>
        <c:set var="lenguaje" value="${cookie.zikav2Lang.value}"/>
    </c:otherwise>
</c:choose>
<spring:url value="/resources/plugins/data-tables/jquery.dataTables.js" var="jQueryDataTables" />
<script type="text/javascript" src="${jQueryDataTables}"></script>
<spring:url value="/resources/plugins/data-tables/DT_bootstrap.js" var="dataTablesBS" />
<script type="text/javascript" src="${dataTablesBS}"></script>
<spring:url value="/resources/plugins/data-tables/TableTools/js/dataTables.tableTools.js" var="dataTablesTT" />
<script type="text/javascript" src="${dataTablesTT}"></script>
<spring:url value="/resources/plugins/data-tables/TableTools/swf/copy_csv_xls_pdf.swf" var="dataTablesTTSWF" />
<spring:url value="/resources/plugins/data-tables/i18n/label_{language}.json" var="dataTablesLang">
    <spring:param name="language" value="${lenguaje}" />
</spring:url>

<!-- Select 2-->
<spring:url value="/resources/plugins/select2/select2.min.js" var="Select2" />
<script type="text/javascript" src="${Select2}"></script>
<spring:url value="/resources/plugins/select2/select2_locale_{language}.js" var="Select2Loc">
    <spring:param name="language" value="${lenguaje}" />
</spring:url>
<script src="${Select2Loc}"></script>

<!-- bootstrap datepicker -->
<spring:url value="/resources/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" var="datepickerPlugin" />
<script src="${datepickerPlugin}"></script>
<spring:url value="/resources/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.{languagedt}.js" var="datePickerLoc">
    <spring:param name="languagedt" value="${lenguaje}" /></spring:url>
<script src="${datePickerLoc}"></script>

<!-- VALIDATOR-->
<spring:url value="/resources/plugins/jquery-validation/dist/jquery.validate.min.js" var="jQValidation" />
<script type="text/javascript" src="${jQValidation}"></script>
<spring:url value="/resources/plugins/jquery-validation/dist/additional-methods.min.js" var="jQValidationAdd" />
<script type="text/javascript" src="${jQValidationAdd}"></script>
<spring:url value="/resources/plugins/jquery-validation/localization/messages_{language}.js" var="jQValidationLoc">
    <spring:param name="language" value="${lenguaje}" />
</spring:url>
<script src="${jQValidationLoc}"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<spring:url value="/resources/scripts/app.js" var="App" />
<script src="${App}" type="text/javascript"></script>
<spring:url value="/resources/scripts/utils/handleDatePickers.js" var="handleDatePickers" />
<script src="${handleDatePickers}" type="text/javascript"></script>
<spring:url value="/resources/scripts/export/process-export.js" var="procExportScript" />
<script src="${procExportScript}" type="text/javascript"></script>

<spring:url value="/admin/export/getZp00"	var="getZp00"/>
<spring:url value="/admin/export/getZpoV2CuestDemo"	var="getZpoV2CuestDemo"/>
<spring:url value="/admin/export/getZpoV2CuestDemoUpd" var="getZpoV2CuestDemoUpd"/>
<spring:url value="/admin/export/getZpoV2StudyExit"	var="getZpoV2StudyExit"/>
<spring:url value="/admin/export/getZpoV2CuestSocio" var="getZpoV2CuestSocio"/>
<spring:url value="/admin/export/getZpoV2CuestSaludInfantil" var="getZpoV2CuestSaludInfantil"/>
<spring:url value="/admin/export/getZpoV2CuestSaludInfantilUpd"	var="getZpoV2CuestSaludInfantilUpd"/>
<spring:url value="/admin/export/getZpoV2ExamFisInf" var="getZpoV2ExamFisInf"/>
<spring:url value="/admin/export/getZpoV2CuestSaludMaterna" var="getZpoV2CuestSaludMaterna"/>
<spring:url value="/admin/export/getZpoV2CuestSaludMaternaUpd" var="getZpoV2CuestSaludMaternaUpd"/>
<spring:url value="/admin/export/getZpoV2IndCuidadoFamilia"	var="getZpoV2IndCuidadoFamilia"/>
<spring:url value="/admin/export/getZpoBiospColl" var="getZpoBiospColl"/>
<spring:url value="/admin/export/getZpoV2Mullen" var="getZpoV2Mullen"/>
<spring:url value="/admin/export/getZpoV2EvalVisual" var="getZpoV2EvalVisual"/>
<spring:url value="/admin/export/getZpoV2EvalAuditiva" var="getZpoV2EvalAuditiva"/>
<spring:url value="/admin/export/getZpoV2EvalPsico"	var="getZpoV2EvalPsico"/>
<spring:url value="/admin/export/getZpoV2EdadesEtapas42"	var="getZpoV2EdadesEtapas42"/>
<spring:url value="/admin/export/getZpoV2EdadesEtapas54"	var="getZpoV2EdadesEtapas54"/>
<spring:url value="/admin/export/getZpoV2BiosColl"	var="getZpoV2BiosColl"/>
<spring:url value="/admin/export/getAll" var="getAll"/>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    $(function () {
        $("li.admin").removeClass("open").addClass("active");
        $("li.export").removeClass("addres").addClass("active");
    });
</script>
<script>
	jQuery(document).ready(function() {
		App.init();
		var parametros = {getZpoV2CuestDemo : "${getZpoV2CuestDemo}",
            getZpoV2CuestDemoUpd : "${getZpoV2CuestDemoUpd}",
            getZpoV2StudyExit : "${getZpoV2StudyExit}",
            getZpoV2CuestSocio : "${getZpoV2CuestSocio}",
            getZpoV2CuestSaludInfantil : "${getZpoV2CuestSaludInfantil}",
            getZpoV2CuestSaludInfantilUpd : "${getZpoV2CuestSaludInfantilUpd}",
            getZpoV2ExamFisInf : "${getZpoV2ExamFisInf}",
            getZpoV2CuestSaludMaterna : "${getZpoV2CuestSaludMaterna}",
            getZpoV2CuestSaludMaternaUpd : "${getZpoV2CuestSaludMaternaUpd}",
            getZpoV2IndCuidadoFamilia : "${getZpoV2IndCuidadoFamilia}",
            getZpoBiospColl : "${getZpoBiospColl}",
            getZpoV2Mullen : "${getZpoV2Mullen}",
            getZpoV2EvalVisual : "${getZpoV2EvalVisual}",
            getZpoV2EvalAuditiva : "${getZpoV2EvalAuditiva}",
            getZpoV2EvalPsico : "${getZpoV2EvalPsico}",
            getZpoV2EdadesEtapas42 : "${getZpoV2EdadesEtapas42}",
            getZpoV2EdadesEtapas54 : "${getZpoV2EdadesEtapas54}",
            getZpoV2BiosColl : "${getZpoV2BiosColl}",
            getAll : "${getAll}"
        };

        Export.init(parametros);
	});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>