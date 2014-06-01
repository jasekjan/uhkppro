<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="content">
	<h2>Najít klienta:</h2>

	<spring:url value="/klients" var="formUrl" />
	<form:form modelAttribute="klient" action="${fn:escapeXml(formUrl)}"
		method="post">
		<table>
			<tr>
				<th>Příjmení: <br /> <form:errors path="lastName"
						cssClass="errors" /> <form:input accept-charset="UTF-8"
						path="lastName" size="30" maxlength="80" />
				</th>
			</tr>
			<tr>
				<td><p class="submit">
						<input type="submit" value="Najít klienta" />
					</p></td>
			</tr>
		</table>
	</form:form>

	<br /> <a href='<spring:url value="/klienti/novy" htmlEscape="true"/>'>Nový
		klient</a>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
