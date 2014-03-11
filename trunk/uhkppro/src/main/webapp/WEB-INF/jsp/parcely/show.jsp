<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Informace o parcele</h2>

<table>
	<tr>
		<th>Číslo parcely</th>
		<td><b>${parcela.kmenoveCislo}/${parcela.podlomeniCisla }</b></td>
	</tr>
	<tr>
		<th>Výměra</th>
		<td>${parcela.vymera}</td>
	</tr>
</table>
<table class="table-buttons">
	<tr>
		<td colspan="2" align="center"><spring:url
				value="{parcelaId}/edit" var="editUrl">
				<spring:param name="parcelaId" value="${parcela.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav parcelu</a></td>

	</tr>
</table>

<a href="<spring:url value="/parcely" htmlEscape="true" />">Parcely</a>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
