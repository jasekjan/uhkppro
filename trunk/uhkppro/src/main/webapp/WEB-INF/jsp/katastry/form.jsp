<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:choose>
	<c:when test="${katastr['new']}">
		<c:set var="method" value="post" />
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put" />
	</c:otherwise>
</c:choose>
<div class="content">
	<h2>
		<c:choose>
			<c:when test="${katastr['new']}">Nový katastr</c:when>
			<c:otherwise>Katastr</c:otherwise>
		</c:choose>
	</h2>
	<form:form modelAttribute="katastr" method="${method}">
		<table>
			<tr>
				<td>Kód:</td>
				<td><form:errors path="kod" cssClass="errors" /> <form:input
						path="kod" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Nazev:</td>
				<td><form:errors path="nazev" cssClass="errors" /> <form:input
						path="nazev" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td><c:choose>
						<c:when test="${katastr['new']}">
							<p class="submit">
								<input type="submit" value="Přidat katastr" />
							</p>
						</c:when>
						<c:otherwise>
							<p class="submit">
								<input type="submit" value="Uložit změny" />
							</p>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
