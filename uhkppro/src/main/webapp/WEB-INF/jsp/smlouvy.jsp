<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2>Smlouvy:</h2>

<ul class="vertical_menu_r">
	<li><a href="smlouvy/novy">Nová</a></li>
</ul>

<table>
  <thead>
    <th width="120">Číslo smlouvy</th>
    <th width="120">Účinnost od</th>
    <th width="120">Účinnost do</th>
    <th width="220">Klient</th>
    <th></th>
  </thead>
  <c:forEach var="smlouva" items="${smlouvy.smlouvaList}">
    <tr>
      <td>
          <spring:url value="smlouvy/{smlouvaId}" var="smlouvaUrl">
              <spring:param name="smlouvaId" value="${smlouva.id}"/>
          </spring:url>
          <a href="${fn:escapeXml(smlouvaUrl)}">${smlouva.identifikator}</a>
      </td>
      <td><fmt:formatDate value="${smlouva.ucinnostOd}" pattern="d.M.yyyy"/></td>
      <td><fmt:formatDate value="${smlouva.ucinnostDo}" pattern="d.M.yyyy"/></td>
      <td>${smlouva.klient.lastName } ${smlouva.klient.firstName }</td>
    </tr>
  </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
