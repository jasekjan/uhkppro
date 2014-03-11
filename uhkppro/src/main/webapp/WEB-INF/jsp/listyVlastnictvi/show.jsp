<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Informace o LV</h2>

<table>
	<tr>
		<th>Číslo</th>
		<td><b>${listVlastnictvi.cislo}</b></td>
	</tr>
	<tr>
		<th>Katastr</th>
		<td>${listVlastnictvi.katastr.kod} ${listVlastnictvi.katastr.nazev}</td>
	</tr>
</table>
<table class="table-buttons">
	<tr>
		<td colspan="2" align="center"><spring:url value="{lvId}/edit"
				var="editUrl">
				<spring:param name="lvId" value="${listVlastnictvi.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav LV</a></td>
	</tr>
</table>
<a href="<spring:url value="/listyVlastnictvi" htmlEscape="true" />">Listy vlastnictví</a>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
