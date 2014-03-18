<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<h2>Informace o parcele</h2>

	<ul class="vertical_menu_r">
		<li><spring:url value="{parcelaId}/edit" var="editUrl">
				<spring:param name="parcelaId" value="${parcela.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav parcelu</a></li>
	</ul>

	<table class="partab">
		<tr>
			<td><b>Číslo parcely</b></td>
			<td>${parcela.kmenoveCislo}/${parcela.podlomeniCisla }</td>
		</tr>
		<tr>
			<td><b>Výměra</b></td>
			<td>${parcela.vymera} ha</td>
		</tr>
	</table>

</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
