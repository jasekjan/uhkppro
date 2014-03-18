<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<h2>Informace o katastru</h2>

	<ul class="vertical_menu_r">
		<li><spring:url value="{katastrId}/edit" var="editUrl">
				<spring:param name="katastrId" value="${katastr.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav katastr</a></li>
	</ul>

	<table class="kattab">
		<tr>
			<td><b>Kód</b></td>
			<td>${katastr.kod}</td>
		</tr>
		<tr>
			<td><b>Název</b></td>
			<td>${katastr.nazev}</td>
		</tr>
	</table>


	<h2>Listy vlastnictví:</h2>
	<table border="1">
		<head>
		<th>Číslo</th>
		<th>Podílníci</th>
		</head>
		<c:forEach var="lv" items="${katastr.lvs }">
			<tr>
				<td>${lv.cislo }</td>
				<td>
					<table>
						<c:forEach var="podil" items="${lv.podily}">
							<tr>
								<td>${podil.citatel}/${podil.jmenovatel }
									${podil.klient.lastName } ${podil.klient.firstName }</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>

</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
