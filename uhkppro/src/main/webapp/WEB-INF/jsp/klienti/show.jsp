<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<h2>Informace o klientovi</h2>

	<ul class="vertical_menu_r">
		<li><spring:url value="{klientId}/edit" var="editUrl">
				<spring:param name="klientId" value="${klient.id}" />
			</spring:url> <a href="${fn:escapeXml(editUrl)}">Uprav klienta</a></li>
	</ul>

	<table class="klitab">
		<tr>
			<th><b>Jméno</b></th>
			<td>${klient.firstName} ${klient.lastName}</td>
		</tr>
		<tr>
			<th><b>Ulice<b></b></th>
			<td>${klient.street}</td>
		</tr>
		<tr>
			<th><b>Obec</b></th>
			<td>${klient.city}</td>
		</tr>
		<tr>
			<th><b>Telefon</b></th>
			<td>${klient.phoneContact}</td>
		</tr>
	</table>


	<h2>Smlouvy</h2>

	<table border="1">
		<thead>
			<th width="120">Číslo smlouvy</th>
			<th width="120">Účinnost od</th>
			<th width="120">Účinnost do</th>
			<th width="320">Parcely</th>
		</thead>
		<c:forEach var="smlouva" items="${klient.smlouvy}">
			<tr>
				<td>${smlouva.identifikator}</td>
				<td><fmt:formatDate value="${smlouva.ucinnostOd}"
						pattern="d.M.yyyy" /></td>
				<td><fmt:formatDate value="${smlouva.ucinnostDo}"
						pattern="d.M.yyyy" /></td>
				<td>
					<table>
						<c:forEach var="parsml" items="${smlouva.parcely}">
							<tr>
								<td>${parsml.kmenoveCislo}/${parsml.podlomeniCisla} <c:forEach
										var="podil" items="${parsml.lv.podily}">
										<c:if test="${podil.klient.id == klient.id}">
											<td align="left">( ${parsml.lv.cislo} -
												${parsml.lv.katastr.nazev} ) --
												${podil.citatel}/${podil.jmenovatel}</td>
										</c:if>
									</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td><spring:url value="/smlouvy/{smlouvaId}/edit"
						var="smlouvaUrl">
						<spring:param name="smlouvaId" value="${smlouva.id}" />
					</spring:url> <a href="${fn:escapeXml(smlouvaUrl)}">Uprav</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
