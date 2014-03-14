<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Informace o smlouvě</h2>

<table>
	<tr>
		<th>Číslo smlouvy</th>
		<td><b>${smlouva.identifikator }</b></td>
	</tr>
	<tr>
		<th>Účinnost od</th>
		<td><fmt:formatDate value="${smlouva.ucinnostOd}" pattern="d.M.yyyy"/></td>
	</tr>
	<tr>
		<th>Účinnost do</th>
		<td><fmt:formatDate value="${smlouva.ucinnostDo}" pattern="d.M.yyyy"/></td>
	</tr>
	<tr>
		<th>Klient</th>
		<td>${smlouva.klient.lastName} ${smlouva.klient.firstName}</td>
	</tr>
	<tr>
		<th>Sazba</th>
		<td>${smlouva.sazbaHa} Kč/ha</td>
	</tr>
</table>

<h2>Parcely</h2>

<table border="1" style="border: 2px solid black;">
	<thead>
		<th>Číslo parcely</th>
		<th>Výměra</th>
		<th></th>
	</thead>
	<c:forEach var="parsm" items="${smlouva.parcely}">
		<tr>
			<td>${parsm.kmenoveCislo}/${parsm.podlomeniCisla
				}</td>
			<td>${parsm.vymera }</td>
			<td>Uprav</td>
		</tr>
	</c:forEach>
</table>

<table class="table-buttons">
	<tr>
		<td colspan="2" align="center"><spring:url
				value="{smlouvaId}/edit" var="editUrl">
				<spring:param name="smlouvaId" value="${smlouva.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav smlouvu</a></td>
		<td colspan="2" align="center"><spring:url value="novy"
				var="novyUrl">
				<spring:param name="smlouvaId" value="${smlouva.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Přidat smlouvu</a></td>
	</tr>
</table>

<td><a href="<spring:url value="/smlouvy" htmlEscape="true" />">Smlouvy</a></td>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
