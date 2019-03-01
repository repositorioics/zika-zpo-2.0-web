<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!--[if IE 8]> <html class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<jsp:include page="../fragments/headTag.jsp" />
<!-- BEGIN PAGE LEVEL STYLES -->
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
					<spring:message code="title" /> <small><spring:message code="pregnants" /> - <spring:message code="pregnantsdash" /> - <spring:message code="detail" /></small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="<spring:url value="/" htmlEscape="true "/>"><spring:message code="home" /></a>
							<i class="fa fa-angle-right"></i> <spring:message code="pregnants" />
                            <i class="fa fa-angle-right"></i> <a href="<spring:url value="/pregnants/dashboard" htmlEscape="true "/>"><spring:message code="pregnantsdash" /></a>
                            <i class="fa fa-angle-right"></i> <spring:message code="detail" />
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
            <div class="row">
            <div class="col-md-12">
            <!-- BEGIN FORM PORTLET-->
            <div class="portlet">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-user"></i>
                </div>
                <div class="tools">
                    <a href="javascript:;" class="collapse"></a>
                    <a href="javascript:;" class="remove"></a>
                </div>
            </div>
            <div class="portlet-body">
            <div class="table-toolbar">
                <div class="btn-group">
                    <spring:url value="/pregnants/dashboard"	var="pregnantsdash"/>
                    <button id="lista_pregnantsdash" onclick="location.href='${fn:escapeXml(pregnantsdash)}'" class="btn btn-info">
                        <spring:message code="pregnantsdash" /> <i class="fa fa-reply"></i>
                    </button>
                </div>
            </div>
            <!-- BEGIN FORM-->
            <form class="form-horizontal">
                <div class="form-body">
                    <h3 class="form-section"><c:out value="${detalle.codigo}" /></h3>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3"><spring:message code="diary.registerdate" />:</label>
                                <div class="col-md-9">
                                    <p class="form-control-static">
                                        <c:out value="${detalle.fechaIngreso}" />
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!--/span-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-3"><spring:message code="event" />:</label>
                                <div class="col-md-9">
                                    <p class="form-control-static">
                                        <spring:message code="${detalle.evento}" />
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- END FORM-->
            </div>
            </div>
            <!-- END FORM PORTLET-->
            </div>
            </div>
            <!-- START ROW -->
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN TABLE PORTLET-->
                    <div class="portlet">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-group"></i><spring:message code="form" />
                            </div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse"></a>
                                <a href="javascript:;" class="remove"></a>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-toolbar2">
                                <div class="btn-group">
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped table-hover table-bordered" id="lista_registros">
                                    <thead>
                                    <tr>
                                        <th><spring:message code="form" /></th>
                                        <th><spring:message code="status" /></th>
                                        <th><spring:message code="diary.registerdate" /></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${detalle.formularios}" var="formulario">
                                        <tr>
                                            <td><spring:message code="${formulario[0]}" /></td>
                                            <td><spring:message code="${formulario[1]}" /></td>
                                            <td><c:out value="${formulario[2]}" /></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- END TABLE PORTLET-->
                </div>
            </div>
            <!-- END ROW -->
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
<c:choose>
	<c:when test="${cookie.zikav2Lang.value == null}">
		<c:set var="lenguaje" value="es"/>
	</c:when>
	<c:otherwise>
		<c:set var="lenguaje" value="${cookie.zikav2Lang.value}"/>
	</c:otherwise>
</c:choose>

<!-- DATA TABLE-->
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
<spring:url value="/resources/plugins/select2/select2.min.js" var="Select2" />
<script type="text/javascript" src="${Select2}"></script>
<spring:url value="/resources/plugins/jquery-multi-select/js/jquery.multi-select.js" var="jQueryMultiSelect" />
<script type="text/javascript" src="${jQueryMultiSelect}"></script>
<spring:url value="/resources/plugins/jquery-validation/dist/jquery.validate.min.js" var="jQValidation" />
<script type="text/javascript" src="${jQValidation}"></script>
<spring:url value="/resources/plugins/jquery-validation/dist/additional-methods.min.js" var="jQValidationAdd" />
<script type="text/javascript" src="${jQValidationAdd}"></script>
<!-- jQuery Password Meter-->
<spring:url value="/resources/plugins/jquery.pwstrength.bootstrap/src/pwstrength.js" var="pwStrength" />
<script src="${pwStrength}" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<spring:url value="/resources/scripts/app.js" var="App" />
<script src="${App}" type="text/javascript"></script>
<spring:url value="/resources/plugins/jquery-validation/localization/messages_{language}.js" var="jQValidationLoc">
	<spring:param name="language" value="${lenguaje}" />
</spring:url>				
<script src="${jQValidationLoc}"></script>
<spring:url value="/resources/plugins/select2/select2_locale_{language}.js" var="Select2Loc">
	<spring:param name="language" value="${lenguaje}" />
</spring:url>				
<script src="${Select2Loc}"></script>
<spring:url value="/users/saveUser" var="saveUserUrl"/>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    $(function () {
    	$("li.start").addClass("active");
    });
</script>
<script>
	jQuery(document).ready(function() {
		App.init();
		$('#username').prop('readonly', true);
		$('#completeName').focus();
		var parametros = {dataTablesLang : "${dataTablesLang}"
		};
        $('#lista_registros').DataTable({
            "oLanguage": {
                "sUrl": "${dataTablesLang}"
            },
            "scrollX": true,
            "iDisplayLength": 10,
            "sPaginationType": "bootstrap",
            "bPaginate": true
        });
	});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>