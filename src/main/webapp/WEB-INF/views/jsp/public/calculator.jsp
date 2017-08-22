<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<spring:message code="label_calculator_title" var="labelCalculatorTitle"/>
<spring:message code="label_calculator_subtitle" var="labelCalculatorSubtitle"/>
<spring:message code="label_select_irrigation" var="labelSelectIrrigation"/>
<spring:message code="label_slaughter_processing" var="labelSlaughterProcessing"/>
<spring:message code="label_posterrail_treatment" var="labelPosterrailTreatment"/>
<spring:message code="label_drip_irrigation" var="labelDripIrrigation"/>
<spring:message code="label_select_brand" var="labelSelectBrand"/>
<spring:message code="label_select_product" var="labelSelectProduct"/>
<spring:message code="label_select_dimensional" var="labelSelectDimensional"/>
<spring:message code="label_sq_m" var="labelSqM"/>
<spring:message code="label_ar" var="labelAr"/>
<spring:message code="label_ha" var="labelHa"/>


<!DOCTYPE html>
<div lang="uk">

  <jsp:include page="../fragments/header.jsp" />

  <div class="container">
    <br/>
    <h3 class="title">${labelCalculatorTitle}</h3>
    <br/>
    <br/>
  </div>
  <div class="container">
    <h4>${labelCalculatorSubtitle}</h4>
    <br/>
    <label>
      <select id="irrigation" name="irrigation" size="1" onchange="irrTypeChange()">
        <option id="i0" value="0">${labelSelectIrrigation}</option>
        <option id="i1" value="0.14">${labelSlaughterProcessing}</option>
        <option id="i2" value="0.24">${labelPosterrailTreatment}</option>
        <option id="i3" value="0.34">${labelDripIrrigation}</option>
      </select>
    </label>
  </div>
  <br/>
  <div сlass="container">
    <h4>
      <output id="product">
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
      </output>
    </h4>
  </div>
  <br/>
  <div id="proxy">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
  </div>
  <div id = "producttype" class="container" hidden>
    <h4>${labelSelectBrand}</h4>
    <br/>
    <label>
      <select id="prodType" name="prodType" onchange="changeProdType()" size="1">
        <option name="prodName" id="prod0" value="NaN">${labelSelectProduct}</option>
        <c:forEach items="${prods}" var="item">
          <option name="prodName" id="${item.id}" value="${item.coeff}">${item.name}</option>
        </c:forEach>
      </select>
      <input type="number" id="amount" min="1" max="999999" onchange="changeAmount()" required>
      <select id="dimension" name="dimension" size="1"  onchange="changeDim()">
        <option id="dim0" value="NaN">${labelSelectDimensional}</option>
        <option value="1">${labelSqM}</option>
        <option value="100">${labelAr}</option>
        <option value="10000">${labelHa}</option>
      </select>
    </label>
    <output id="result">
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
      <br/>
    </output>
  </div>
  <br/>
  <br/>
</div>

<jsp:include page="../fragments/footer.jsp" />
