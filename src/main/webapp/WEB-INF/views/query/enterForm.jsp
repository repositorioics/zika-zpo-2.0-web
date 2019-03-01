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
					<spring:message code="title" /> <small><spring:message code="consult" /></small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="<spring:url value="/" htmlEscape="true "/>"><spring:message code="home" /></a>
                            <i class="fa fa-angle-right"></i> <a href="<spring:url value="/admin/query/" htmlEscape="true "/>"><spring:message code="consult" /></a>
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
                                    <div class="alert alert-info">
                                        <spring:message code="query.help" />
                                    </div>
                                    <div class="alert alert-danger display-hide">
                                        <button class="close" data-close="alert"></button>
                                        <spring:message code="form.errors" />
                                    </div>
                                    <div class="row">
                                        <div class="col col-sm-12 col-md-12 col-lg-12">
                                            <div class="form-group">
                                                <label class="control-label col-md-2"><spring:message code="lbl.query" />
                                                    <span class="required">
                                                        *
                                                    </span>
                                                </label>
                                                <div class="col-md-10">
                                                        <textarea class="form-control" rows="5" name="query" id="query"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-actions fluid">
                                    <div class="col-md-offset-6 col-md-6">
                                        <button id="guardar" type="submit" class="btn btn-success"><spring:message code="run" /></button>
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
<spring:url value="/resources/scripts/query/process-query.js" var="queryScript" />
<script src="${queryScript}" type="text/javascript"></script>

<spring:url value="/admin/query/getResulQuery"	var="queryUrl"/>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
    $(function () {
        $("li.admin").removeClass("open").addClass("active");
        $("li.query").removeClass("query").addClass("active");
    });
</script>
<script>
	jQuery(document).ready(function() {
		App.init();
		var parametros = {queryUrl : "${queryUrl}"};

        Query.init(parametros);
        $('#query').focus();
	});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>