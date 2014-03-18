<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<h2>Informace o LV</h2>

	<ul class="vertical_menu_r">
		<li><spring:url value="{lvId}/edit" var="editUrl">
				<spring:param name="lvId" value="${listVlastnictvi.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav LV</a></li>

	</ul>
	<table class="lvtab">
		<tr>
			<td><b>Číslo</b></td>
			<td>${listVlastnictvi.cislo}</td>
		</tr>
		<tr>
			<td><b>Katastr</b></td>
			<td>${listVlastnictvi.katastr.kod}
				${listVlastnictvi.katastr.nazev}</td>
		</tr>
	</table>
	<table>
		<c:forEach var="podil" items="${listVlastnictvi.podily}">
			<tr>
				<td>${podil.citatel}/${podil.jmenovatel }</td>
				<td>${podil.klient.lastName } ${podil.klient.firstName }</td>
			</tr>
		</c:forEach>

	</table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>