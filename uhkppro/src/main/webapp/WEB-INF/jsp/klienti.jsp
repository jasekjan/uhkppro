<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<h2>Klienti:</h2>

<ul class="vertical_menu_r">
	<li><a href="klienti/novy">Nový</a></li>
</ul>

<table>
	<thead>
		<th>Jméno</th>
		<th>Obec</th>
		<th>Ulice</th>
		<th></th>
	</thead>
	<c:forEach var="klient" items="${klienti.klientList}">
		<tr>
			<td><spring:url value="klienti/{klientId}" var="klientUrl">
					<spring:param name="klientId" value="${klient.id}" />
				</spring:url> <a href="${fn:escapeXml(klientUrl)}">${klient.firstName}
					${klient.lastName}</a></td>
			<td>${klient.city}</td>
			<td>${klient.street }</td>
			<td colspan="2" align="center"><spring:url
					value="klienti/{klientId}/edit" var="editUrl">
					<spring:param name="klientId" value="${klient.id}" />
				</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav</a></td>
		</tr>
	</c:forEach>
</table>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>
