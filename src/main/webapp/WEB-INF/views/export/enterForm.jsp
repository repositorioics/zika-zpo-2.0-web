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
                                                        <option value="Zp00"><spring:message code="zp00" /></option>
                                                        <option value="Zp01AD"><spring:message code="zp01AD" /></option>
                                                        <option value="Zp01E"><spring:message code="zp01E" /></option>
                                                        <option value="Zp01FK"><spring:message code="zp01FK" /></option>
                                                        <option value="Zp02"><spring:message code="zp02" /></option>
                                                        <option value="Zp03"><spring:message code="zp03" /></option>
                                                        <option value="Zp04AD"><spring:message code="zp04AD" /></option>
                                                        <option value="Zp04E"><spring:message code="zp04E" /></option>
                                                        <option value="Zp04FH"><spring:message code="zp04FH" /></option>
                                                        <option value="Zp05"><spring:message code="zp05" /></option>
                                                        <option value="Zp06"><spring:message code="zp06" /></option>
                                                        <option value="Zp08"><spring:message code="zp08" /></option>
                                                        <option value="Zp07"><spring:message code="zp07" /></option>
                                                        <option value="Zp02d"><spring:message code="zp02d" /></option>
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
<spring:url value="/admin/export/getZp01AD"	var="getZp01AD"/>
<spring:url value="/admin/export/getZp01E"	var="getZp01E"/>
<spring:url value="/admin/export/getZp01FK"	var="getZp01FK"/>
<spring:url value="/admin/export/getZp02"	var="getZp02"/>
<spring:url value="/admin/export/getZp03"	var="getZp03"/>
<spring:url value="/admin/export/getZp04AD"	var="getZp04AD"/>
<spring:url value="/admin/export/getZp04E"	var="getZp04E"/>
<spring:url value="/admin/export/getZp04FH"	var="getZp04FH"/>
<spring:url value="/admin/export/getZp05"	var="getZp05"/>
<spring:url value="/admin/export/getZp06"	var="getZp06"/>
<spring:url value="/admin/export/getZp08"	var="getZp08"/>
<spring:url value="/admin/export/getAll"	var="getAll"/>
<spring:url value="/admin/export/getZp07"	var="getZp07"/>
<spring:url value="/admin/export/getZp02d"	var="getZp02d"/>

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
		var parametros = {getZp00 : "${getZp00}",
            getZp01AD : "${getZp01AD}",
            getZp01E : "${getZp01E}",
            getZp01FK : "${getZp01FK}",
            getZp02 : "${getZp02}",
            getZp03 : "${getZp03}",
            getZp04AD : "${getZp04AD}",
            getZp04E : "${getZp04E}",
            getZp04FH : "${getZp04FH}",
            getZp06 : "${getZp06}",
            getZp05 : "${getZp05}",
            getZp08 : "${getZp08}",
            getZp07 : "${getZp07}",
            getZp02d : "${getZp02d}",
            getAll : "${getAll}"
        };

        Export.init(parametros);
	});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>