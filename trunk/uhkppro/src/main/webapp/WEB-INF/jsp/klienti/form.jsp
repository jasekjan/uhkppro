<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<c:choose>
	<c:when test="${klient['new']}">
		<c:set var="method" value="post" />
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put" />
	</c:otherwise>
</c:choose>
<div class="content">
	<h2>
		<c:choose>
			<c:when test="${klient['new']}">Nový klient</c:when>
			<c:otherwise>Klient</c:otherwise>
		</c:choose>
	</h2>
	<form:form modelAttribute="klient" method="${method}">
		<table>
			<tr>
				<td>Jméno:</td>
				<td><form:errors path="firstName" cssClass="errors" /> <form:input
						path="firstName" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Příjmení:</td>
				<td><form:errors path="lastName" cssClass="errors" /> <form:input
						path="lastName" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Ulice:</td>
				<td><form:errors path="street" cssClass="errors" /> <form:input
						path="street" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Obec:</td>
				<td><form:errors path="city" cssClass="errors" /> <form:input
						path="city" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Telefon:</td>
				<td><form:errors path="phoneContact" cssClass="errors" /> <form:input
						path="phoneContact" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td><c:choose>
						<c:when test="${klient['new']}">
							<p class="submit">
								<input type="submit" value="Přidat klienta" />
							</p>
						</c:when>
						<c:otherwise>
							<p class="submit">
								<input type="submit" value="Upravit klienta" />
							</p>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
