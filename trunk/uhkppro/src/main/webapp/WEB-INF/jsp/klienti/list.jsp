<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2>Klienti:</h2>

<table width="500">
  <thead>
    <th>Jméno</th>
    <th>Ulice</th>
    <th>Obec</th>
    <th>Telefon</th>
  </thead>
  <c:forEach var="klient" items="${selections}">
    <tr>
      <td>
          <spring:url value="klienti/{klientId}" var="klientUrl">
              <spring:param name="klientId" value="${klient.id}"/>
          </spring:url>
          <a href="${fn:escapeXml(klientUrl)}">${klient.firstName} ${klient.lastName}</a>
      </td>
      <td>${klient.street}</td>
      <td>${klient.city}</td>
      <td>${klient.phoneContact}</td>
    </tr>
  </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
