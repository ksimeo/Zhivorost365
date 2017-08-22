<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<spring:message code="label_gratitude_title" var="labelGratitudeTitle"/>
<spring:message code="label_yes" var="labelYes"/>
<spring:message code="label_no" var="labelNo"/>
<spring:message code="label_your_order" var="labelYourOrder" />
<spring:message code="label_product_name" var="labelProductName" />
<spring:message code="label_quantity" var="labelQuantity" />
<spring:message code="label_your_name" var="labelYourName" />
<spring:message code="label_your_phone" var="labelYourPhone" />
<spring:message code="label_customer_email" var="labelCustomerEmail" />
<spring:message code="buttonl_order_again" var="buttonOrderAgain" />
<spring:message code="label_liter" var="labelLiter" />


<!DOCTYPE html>
<html lang="uk">

<jsp:include page="../fragments/header.jsp" />

<div class="container">
    <h2><b>${labelGratitudeTitle}</b></h2>
    <br/>
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong><h2>${msg}</h2></strong>
        </div>
    </c:if>
    <br/>
    <br/>
    <c:if test="${not empty order}">
        <h4 class="title">${labelYourOrder}</h4>
        <br/>
        <br/>
        <div class="row">
            <label class="col-sm-2">${labelProductName}</label>
            <div class="col-sm-10">${order.product.name}</div>
        </div>
        <br/>
        <div class="row">
            <label class="col-sm-2">${labelQuantity}</label>
            <div class="col-sm-10">${order.amount} ${labelLiter}</div>
        </div>
        <br/>
        <c:if test="${not empty order.customer.name}">
            <div class="row">
                <label class="col-sm-2">${labelYourName}</label>
                <div class="col-sm-10">${order.customer.name}</div>
            </div>
        </c:if>
        <br/>
        <c:if test="${not empty order.customer.phoneNumber}">
            <div class="row">
                <label class="col-sm-2">${labelYourPhone}</label>
                <div class="col-sm-10">+380${order.customer.phoneNumber}</div>
            </div>
        </c:if>
        <br/>
        <c:if test="${not empty order.customer.email}">
            <div class="row">
                <label class="col-sm-2">${labelCustomerEmail}</label>
                <div class="col-sm-10">${order.customer.email}</div>
            </div>
        </c:if>
    </c:if>
    <br/>
    <button type="button" onclick="document.location='/'" class="btn-lg btn-primary pull-right">${buttonOrderAgain}
    </button>
</div>

<jsp:include page="../fragments/footer.jsp" />

</html>