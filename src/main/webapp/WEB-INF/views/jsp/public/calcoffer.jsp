<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<spring:message code="label_calcoffer_title" var="labelCalcofferTitle"/>
<spring:message code="label_yes" var="labelYes"/>
<spring:message code="label_no" var="labelNo"/>
<%--<spring:message code=""--%>

<!DOCTYPE html>
<html lang="uk">

<jsp:include page="../fragments/header.jsp" />


<center>
  <table>
    <tr>
      <td>
        <h2><b>${labelCalcofferTitle}</b></h2>
          <br/>
      </td>
    </tr>
    <tr>
      <td>
            <input type="button" value="${labelYes}" onclick="document.location='/calculator'"/>
            &nbsp;
            <input type="button" value="${labelNo}" onclick="document.location='/order/0/0'"/>
          </h3>
        </form>
      </td>
    </tr>
  </table>
</center>

<jsp:include page="../fragments/footer.jsp" />

</html>
