<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:choose>
	<c:when test="${listVlastnictvi['new']}">
		<c:set var="method" value="post" />
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put" />
	</c:otherwise>
</c:choose>
<div class="content">
	<h2>
		<c:choose>
			<c:when test="${listVlastnictvi['new']}">Nový LV</c:when>
			<c:otherwise>List vlastnictví</c:otherwise>
		</c:choose>
	</h2>
	<form:form modelAttribute="listVlastnictvi" method="${method}">
		<table>
			<tr>
				<td>Číslo:</td>
				<td><form:errors path="cislo" cssClass="errors" /> <br /> <form:input
						path="cislo" size="30" maxlength="80" /></td>
			</tr>
			<tr>
				<td>Název KÚ:</td>
				<td><form:select path="katastr" items="${katastry}" /></td>
			</tr>
			<tr>
				<td><c:choose>
						<c:when test="${listVlastnictvi['new']}">
							<p class="submit">
								<input type="submit" value="Přidat LV" />
							</p>
						</c:when>
						<c:otherwise>
							<p class="submit">
								<input type="submit" value="Upravit LV" />
							</p>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
