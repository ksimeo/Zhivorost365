<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="label_application_title" var="labelApplicationTitle"/>


<head>
    <title>${labelApplicationTitle}</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="живорост, биогумат, заказать, органические удобрения" />

    <spring:url value="/resources/core/css/style.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/images/ico/favicon.ico" var="favIcon" />
    <spring:url value="/resources/core/js/customer.js" var="custJS" />
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJS" />

    <%--<link rel="shortcut icon" href="img/favicon2.png" type="image/x-icon"/>--%>
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
    <link href="${favIcon}" rel="icon">
    <link href="${custJS}" rel="script">
    <link href="${bootstrapJS}" rel="script">
</head>
<body style="color: darkslategray; background-color: lightcyan;">

<div id="header" xmlns:jsp="http://java.sun.com/JSP/Page"
     xmlns:spring="http://www.springframework.org/tags"
     xmlns:sec="http://www.springframework.org/security/tags"
     version="2.0">
    <jsp:directive.page contentType="text/html;charset=UTF-8" />
    <jsp:output omit-xml-declaration="yes" />

    <spring:message code="header_text" var="headerText"/>
    <spring:message code="label_logout" var="labelLogout"/>
    <spring:message code="label_welcome" var="labelWelcome"/>
    <spring:url var="logoutUrl" value="/j_spring_security_logout" />

    <div id="appname">
        <h1>${headerText}</h1>
    </div>

    <div id="userinfo">
        <sec:authorize access="isAuthenticated()">${labelWelcome}
            <sec:authentication property="principal.username" />
            <br/>
            <a href="${logoutUrl}">${labelLogout}</a>
        </sec:authorize>
    </div>
</div>
