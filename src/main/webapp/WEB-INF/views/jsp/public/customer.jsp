<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<spring:message code="placeholder_desirable" var="placeholderDesirable"/>
<spring:message code="placeholder_necessarily" var="placeholderNecessarily"/>
<spring:message code="label_customer_title" var="labelCustomerTitle"/>
<spring:message code="label_customer_subtitle" var="labelCustomerSubtitle"/>
<spring:message code="button_confirm" var="buttonConfirm"/>
<spring:message code="label_your_name" var="labelYourName"/>
<spring:message code="label_your_surname" var="labelYourSurname"/>
<spring:message code="label_customer_email" var="labelCustomerEmail"/>
<spring:message code="" var=""/>

<!DOCTYPE html>
<html lang="uk">

<html>

<jsp:include page="../fragments/header.jsp" />

<body>
  <h2>${labelCustomerTitle}</h2>
  <br/>
  <h3>${labelCustomerSubtitle}</h3>

  <form:form class="form-horizontal" method="post"
             modelAttribute="orderForm" action="/order">

  <form:hidden path="id" />

  <spring:bind path="name">
      <div class="form-group ${status.error ? 'has-error' : ''}">
          <label class="col-sm-2 control-label">${labelYourName}</label>
          <div class="col-sm-10">
              <form:input path="name" type="text" class="form-control"
                          id="name" placeholder="${placeholderNecessarily}" />
              <form:errors path="name" class="control-label" />
          </div>
      </div>
  </spring:bind>

  <spring:bind path="surname">
      <div class="form-group ${status.error ? 'has-error' : ''}">
          <label class="col-sm-2 control-label">${labelYourSurname}</label>
          <div class="col-sm-10">
              <form:input path="surname" type="text" class="form-control"
                          id="surname" placeholder="${placeholderDesirable}" />
              <form:errors path="surname" class="control-label" />
          </div>
      </div>
  </spring:bind>

  <spring:bind path="email">
      <div class="form-group ${status.error ? 'has-error' : ''}">
          <label class="col-sm-2 control-label">${labelCustomerEmail}</label>
          <div class="col-sm-10">
              <form:input path="email" class="form-control"
                          id="email" placeholder="${placeholderDesirable}" />
              <form:errors path="email" class="control-label" />
          </div>
      </div>
  </spring:bind>

      <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn-lg btn-primary pull-right">${buttonConfirm}</button>
          </div>
      </div>
  </form:form>

  <jsp:include page="../fragments/footer.jsp" />

</body>
</html>
