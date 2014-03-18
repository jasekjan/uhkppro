<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="content">
	<h2>Parcely:</h2>

	<ul class="vertical_menu_r">
		<li><a href="parcely/novy">Nová</a></li>
	</ul>

	<table>
		<thead>
			<th>Číslo parcely</th>
			<th>Výměra (ha)</th>
			<th>LV</th>
		</thead>
		<c:forEach var="parcela" items="${parcely.parcelaList}">
			<tr>
				<td><spring:url value="parcely/{parcelaId}" var="parcelaUrl">
						<spring:param name="parcelaId" value="${parcela.id}" />
					</spring:url> <a href="${fn:escapeXml(parcelaUrl)}">${parcela.kmenoveCislo}/${parcela.podlomeniCisla
						}</a></td>
				<td>${parcela.vymera}</td>
				<td>${parcela.lv.cislo } (${parcela.lv.katastr.nazev })
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
