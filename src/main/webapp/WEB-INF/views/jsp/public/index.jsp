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
<%--<spring:message code=""--%>

<!DOCTYPE html>
<html lang="uk">

<jsp:include page="../fragments/header.jsp" />

<%--<div >--%>
<%--<center>--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<h2><b>${labelWelcomeTitle}</b></h2>--%>
            <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<h3>${labelWelcomeSubtitle}</h3>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<form action="/phone" method="post">--%>
                        <%--<h3>+38 (0--%>
                            <%--<input type="text" name="domain" align="center" tabindex="1" autofocus maxlength="2"--%>
                                   <%--size="1" placeholder="--"/>--%>
                            <%--) &nbsp;--%>
                            <%--<input type="text" name="number" align="center" tabindex="2" maxlength="7" size="5"--%>
                                   <%--placeholder="--- -- --"/>--%>
                            <%--&nbsp;--%>
                            <%--<input type="submit" value="Відправити">--%>
                        <%--</h3>--%>
                    <%--</form>--%>
                <%--</td>--%>
            <%--</tr>--%>
    <%--</table>--%>
<%--</center>--%>
<%--</div>--%>
<form:form class="form-horizontal" method="post"
           modelAttribute="phoneForm" action="/phone">
    <h2><b>${labelWelcomeTitle}</b></h2>
    <br/>
    <h3>${labelWelcomeSubtitle}</h3>
    <span>
<spring:bind path="domain">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <label class="col-sm-2 control-label">+38 (0</label>
        <div class="col-sm-10">
            <form:input path="domain" class="form-control"
                        id="domain" placeholder="--" maxlength="2" size="1"/>
            <form:errors path="domain" class="control-label" />
        </div>
    </div>
</spring:bind>

<spring:bind path="number">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <label class="col-sm-2 control-label">) </label>
        <div class="col-sm-10">
            <form:input path="number" class="form-control"
                        id="number" size="3" maxlength="7" placeholder="--- -- --" />
            <form:errors path="number"  class="control-label" />
        </div>
    </div>
</spring:bind>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn-lg btn-primary pull-right">${buttonSend}</button>
        </div>
    </div>
</form:form>
    </span>

<jsp:include page="../fragments/footer.jsp" />

<%--</body>--%>
</html>
