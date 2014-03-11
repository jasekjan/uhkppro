<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<h2>Smlouvy:</h2>

<table>
	<thead>
		<th>Číslo smlouvy</th>
		<th>Účinnost od</th>
		<th>Účinnost do</th>
	</thead>
	<c:forEach var="smlouva" items="${selections}">
		<tr>
			<td><spring:url value="smlouvy/{smlouvaId}" var="smlouvaUrl">
					<spring:param name="smlouvaId" value="${smlouva.id}" />
				</spring:url> <a href="${fn:escapeXml(smlouvaUrl)}">${smlouva.identifikator}</a>
			</td>
			<td><fmt:formatDate value="${smlouva.ucinnostOd}"
					pattern="d.M.Yyyy" /></td>
			<td><fmt:formatDate value="${smlouva.ucinnostDo}"
					pattern="d.M.yyyy" /></td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
