<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<h2>Listy vlastnictví:</h2>

<ul class="vertical_menu_r">
	<li><a href="listyVlastnictvi/novy">Nový</a></li>
</ul>

<table>
	<thead>
		<th>Číslo</th>
		<th>Kód KÚ</th>
		<th>Název KÚ</th>
	</thead>
	<c:forEach var="lv" items="${listyVlastnictvi.listVlastnictviList}">
		<tr>
			<td><spring:url value="listyVlastnictvi/{lvId}" var="lvUrl">
					<spring:param name="lvId" value="${lv.id}" />
				</spring:url> <a href="${fn:escapeXml(lvUrl)}">${lv.cislo}</a></td>
			<td>${lv.katastr.kod}</td>
			<td>${lv.katastr.nazev}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
