<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="content">
	<h2>Katastry:</h2>

	<ul class="vertical_menu_r">
		<li><a href="katastry/novy">Nový</a></li>
	</ul>

	<table>
		<thead>
			<th>Kód</th>
			<th>Název</th>
			<th></th>
		</thead>
		<c:forEach var="katastr" items="${katastry.katastrList}">
			<tr>
				<td><spring:url value="katastry/{katastrId}" var="katastrUrl">
						<spring:param name="katastrId" value="${katastr.id}" />
					</spring:url> <a href="${fn:escapeXml(katastrUrl)}">${katastr.kod}</a></td>
				<td>${katastr.nazev}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
