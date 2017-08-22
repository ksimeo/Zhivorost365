<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<spring:message code="label_welcome_title" var="labelWelcomeTitle"/>
<spring:message code="label_welcome_subtitle" var="labelWelcomeSubtitle"/>
<spring:message code="button_send" var="buttonSend"/>
<spring:message code="label_do_order_title" var="labelDoOrderTitle" />
<spring:message code="label_do_order_subtitle" var="labelDoOrderSubtitle" />
<spring:message code="label_brand" var="labelBrand" />
<spring:message code="label_select_brand" var="labelSelectBrand" />
<spring:message code="label_product_amount" var="labelProductAmount" />
<spring:message code="button_do_order" var="buttonDoOrder" />

<!DOCTYPE html>
<html lang="uk">

<jsp:include page="../fragments/header.jsp" />

<spring:url value="/order" var="userActionUrl" />

<div class="container">
    <br/>
    <h2 class="title">${labelDoOrderTitle}</h2>
    <br/>
    <br/>
    <h3>${labelDoOrderSubtitle}</h3>
    <br/>
</div>

<form:form class="form-horizontal" method="post"
           modelAttribute="orderForm" action="${userActionUrl}">

<div class="form-group" >
  <label class="col-sm-2 control-label">${labelBrand}</label>
  <div class="col-sm-10">
    <select id="prodName" name="product" size="1" onchange="changeProd()">
      <option name="prodName" id="prod0" value="NaN">${labelSelectBrand}</option>
      <c:forEach items="${prods}" var="item">
        <option name="type" value="${item.id}" ${item.id == prodType ? 'selected="selected"' : ''}>
            ${item.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<spring:bind path="amount">
  <div class="form-group ${status.error ? 'has-error' : ''}">
    <label class="col-sm-2 control-label">${labelProductAmount}</label>
    <div class="col-sm-10">
      <form:input path="amount" type="number" class="form-control"
                  id="amount" style='width: 2em important;' />
      <form:errors path="amount" class="control-label" />
    </div>
  </div>
</spring:bind>

<div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn-lg btn-primary pull-right">${buttonDoOrder}</button>
  </div>
</div>
</form:form>

<jsp:include page="../fragments/footer.jsp" />

</html>
