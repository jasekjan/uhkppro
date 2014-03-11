<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2>Owners:</h2>

<table>
  <thead>
    <th>Kód</th>
    <th>Název</th>
  </thead>
  <c:forEach var="katastr" items="${selections}">
    <tr>
      <td>
          <spring:url value="katastry/{katastrId}" var="katastrUrl">
              <spring:param name="katastrId" value="${katastr.id}"/>
          </spring:url>
          <a href="${fn:escapeXml(katastrUrl)}">${katastr.kod}</a>
      </td>
      <td>${katastr.nazev}</td>
    </tr>
  </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
