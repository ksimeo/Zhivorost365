<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="label_application_title" var="labelApplicationTitle"/>


<head>
    <title>${labelApplicationTitle}</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>
