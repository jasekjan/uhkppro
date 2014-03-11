<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2>Parcely:</h2>

<table>
  <thead>
    <th>Číslo parcely</th>
    <th>Výměra</th>
    <th>LV</th>
  </thead>
  <c:forEach var="parcela" items="${selections}">
    <tr>
      <td>
          <spring:url value="parcely/{parcelaId}" var="parcelaUrl">
              <spring:param name="parcelaId" value="${parcela.id}"/>
          </spring:url>
          <a href="${fn:escapeXml(parcelaUrl)}">${parcela.kmenoveCislo}/${parcela.podlomeniCisla }</a>
      </td>
      <td>${parcela.vymera}</td>
      <td>${parcela.lv.Cislo } (${parcela.lv.katastr.nazev})</td>
    </tr>
  </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
