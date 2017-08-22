<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="label_application_title" var="labelApplicationTitle"/>


<head>
  <title>${labelApplicationTitle}</title>
  <meta charset="UTF-8">
  <meta name="keywords" content="живорост, биогумат, заказать, органические удобрения"

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


