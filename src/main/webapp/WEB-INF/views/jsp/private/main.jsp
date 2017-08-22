<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<script type="application/javascript" >
  function ajaxDoReader(orderId) {
    $.ajax({
      type:'GET',
      url:'/orders/read/' + orderId,
      success: function(servletResult) {
        console.log("Date:" + servletResult.date + "State:" + servletResult.state);
        document.getElementById('orderRead-' + orderId).innerHTML = "<h6>Переглянуто: " + servletResult.date + "</h6>";
        document.getElementById("orderRead-" + orderId).style.display = "true";
        document.getElementById('state-' + orderId).innerHTML = servletResult.state;
//                document.getElementById('order-' + orderId).style.color = "gray !important";
      },
      error: function() {
        console.log('error');
      }
    });
  }
</script>

<body>
<div class="container">

  <c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert"
              aria-label="Close">
        <span aria-hidden="true">×</span>
      </button>
      <strong>${msg}</strong>
    </div>
  </c:if>

  <c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert"
              aria-label="Close">
        <span aria-hidden="true">×</span>
      </button>
      <strong>${msg}</strong>
    </div>
  </c:if>

  <c:choose>
    <c:when test="${orders != null}">
      <h1>Замовлення що надійшли на цей момент</h1>
      <br/>
      <table class="table table-striped">
        <thead>
        <tr>
          <th>#ID</th>
          <th>Дата/час</th>
          <th>Ім'я</th>
          <th>Номер телефону</th>
          <th>Ел.адреса</th>
          <th>Марка продукту</th>
          <th>Кількість продукту</th>
          <th></th>
          <th></th>
        </tr>
        </thead>
        <c:forEach var="order" items="${orders}">
          <div>
            <tr id="order-${order.id}" ${order.readDate == null ? " " : "style = \'color: grey !important;\'"}>
              <td>${order.id}</td>
              <td>
                <div>
                  <c:if test="${not empty order.createDate}">
                    ${order.createDate}
                  </c:if>
                  <c:if test="${empty order.createDate}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              <td>
                <div>
                  <c:if test="${not empty order.name}">
                    ${order.name}
                  </c:if>
                  <c:if test="${empty order.name}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              <td>
                <div>
                  <c:if test="${not empty order.tel}">
                    ${order.tel}
                  </c:if>
                  <c:if test="${empty order.tel}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              </td>
              <td>
                <div>
                  <c:if test="${not empty order.email}">
                    ${order.email}
                  </c:if>
                  <c:if test="${empty order.email}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              </td>
              <td>
                <div>
                  <c:if test="${not empty order.prodName}">
                    ${order.prodName}
                  </c:if>
                  <c:if test="${empty order.prodName}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              </td>
              <td>
                <div>
                  <c:if test="${not empty order.amount}">
                    ${order.amount}
                  </c:if>
                  <c:if test="${empty order.amount}">
                    <h6><i>Не вказано</i></h6>
                  </c:if>
                </div>
              </td>
              <td>
                <div id="orderRead-${order.id}">
                  <c:if test="${empty order.readDate}">
                    <input id = "orderId-${order.id}" class="btn btn-success" type="button"
                           value="Переглянуто" onclick="ajaxDoReader(${order.id})"/>
                  </c:if>
                  <c:if test="${not empty order.readDate}">
                    Переглянуто:&nbsp;${order.readDate}
                  </c:if>
                </div>
              </td>
              <td>
                <button class="btn btn-warning"
                        onclick="document.location='/orders/delete/${order.id}/${page}'">
                  Видалити
                </button>
              </td>
            </tr>
          </div>
        </c:forEach>
      </table>

      <ul class="pagination pull-center">
        <c:forEach var="pagenumb" items="${pagin}">
          <li>${pagenumb == page ? '<li class="active">' : ''} <a href="/orders/${pagenumb}">${pagenumb}</a>
              ${pagenumb == page ? '<li class="active">' : ''}</li>
        </c:forEach>
      </ul>
    </c:when>
    <c:otherwise>
      <h3>Журнал замовлень доки що порожній.</h3>
    </c:otherwise>
  </c:choose>
  <br/>
  <button class="btn-lg btn-primary pull-right" onclick="document.location='/products'">До листу продуктів</button>
</div>

<jsp:include page="../fragments/footer.jsp" />