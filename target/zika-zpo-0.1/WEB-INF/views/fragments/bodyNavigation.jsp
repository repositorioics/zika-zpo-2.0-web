<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
    <div class="page-sidebar-wrapper">
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu">
                <li class="sidebar-toggler-wrapper">
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                    <div class="sidebar-toggler">
                    </div>
                    <div class="clearfix">
                    </div>
                    <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                </li>
                <li class="start">
                    <a href="<spring:url value="/" htmlEscape="true "/>">
                        <i class="fa fa-home"></i>
					<span class="title">
						<spring:message code="home" />
					</span>
					<span class="selected">
					</span>
                    </a>
                </li>
                <sec:authorize url="/">
                    <li class="pregnants">
                        <a href="javascript:;">
                            <i class="fa fa-female"></i>
					<span class="title">
						<spring:message code="pregnants" />
					</span>
					<span class="arrow ">
					</span>
                        </a>
                        <ul class="sub-menu">
                            <li class="pregnantsdash">
                                <a href="<spring:url value="/pregnants/dashboard/" htmlEscape="true "/>">
                                    <i class="fa fa-tachometer"></i>
                                    <spring:message code="pregnantsdash" /></a>
                            </li>
                            <li class="diary">
                                <a href="<spring:url value="/pregnants/diary/" htmlEscape="true "/>">
                                    <i class="fa fa-calendar-o"></i>
                                    <spring:message code="diary" /></a>
                            </li>
                        </ul>
                    </li>
                </sec:authorize>
                <sec:authorize url="/admin/">
                    <li class="admin">
                        <a href="javascript:;">
                            <i class="fa fa-cogs"></i>
					<span class="title">
						<spring:message code="admin" />
					</span>
					<span class="arrow ">
					</span>
                        </a>
                        <ul class="sub-menu">
                            <li class="adminusers">
                                <a href="<spring:url value="/admin/users/" htmlEscape="true "/>">
                                    <i class="fa fa-group"></i>
                                    <spring:message code="adminusers" /></a>
                            </li>
                            <li class="query">
                                <a href="<spring:url value="/admin/query/" htmlEscape="true "/>">
                                    <i class="fa fa-question-circle"></i>
                                    <spring:message code="lbl.query" /></a>
                            </li>
                            <li class="editdata">
                                <a href="<spring:url value="/admin/editdata/" htmlEscape="true "/>">
                                    <i class="fa fa-pencil-square-o"></i>
                                    <spring:message code="editdata" /></a>
                            </li>
                        </ul>
                    </li>
                </sec:authorize>
				<sec:authorize url="/catalog/">
				<li class="catalog">
					<a href="javascript:;">
					<i class="fa fa-th-large"></i>
					<span class="title">
						<spring:message code="catalog" />
					</span>
					<span class="arrow ">
					</span>
					</a>
					<ul class="sub-menu">
						<li class="catalogcenter">
							<a href="<spring:url value="/catalog/centers/" htmlEscape="true "/>">
							<i class="fa fa-building"></i>
							<spring:message code="catalogcenter" /></a>
						</li>
						<li class="catalogsubjtype">
							<a href="<spring:url value="/catalog/subjectTypes/" htmlEscape="true "/>">
							<i class="fa fa-info-circle"></i>
							<spring:message code="catalogsubjtype" /></a>
						</li>
						<li class="catalogspeciality">
							<a href="<spring:url value="/catalog/specialities/" htmlEscape="true "/>">
							<i class="fa fa-stethoscope"></i>
							<spring:message code="catalogspeciality" /></a>
						</li>
						<li class="catalogapptype">
							<a href="<spring:url value="/catalog/appointmenttypes/" htmlEscape="true "/>">
							<i class="fa fa-sliders"></i>
							<spring:message code="catalogapptype" /></a>
						</li>
						<li class="catalogprovider">
							<a href="<spring:url value="/catalog/providers/" htmlEscape="true "/>">
							<i class="fa fa-group"></i>
							<spring:message code="catalogprovider" /></a>
						</li>
					</ul>
				</li>
				</sec:authorize>
                <li class="last ">
                    <a href="<spring:url value="/logout" htmlEscape="true" />">
                        <i class="fa fa-sign-out"></i>
					<span class="title">
						<spring:message code="logout" />
					</span>
                    </a>
                </li>
            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
    </div>
</div>
<!-- END SIDEBAR -->
