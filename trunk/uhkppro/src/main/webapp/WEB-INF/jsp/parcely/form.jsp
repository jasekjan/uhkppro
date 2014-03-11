<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:choose>
	<c:when test="${parcela['new']}">
		<c:set var="method" value="post" />
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put" />
	</c:otherwise>
</c:choose>

<h2>
	<c:choose>
		<c:when test="${parcela['new']}">Nová parcela</c:when>
		<c:otherwise>Parcela</c:otherwise>
	</c:choose>
</h2>
<form:form modelAttribute="parcela" method="${method}">
			Číslo parcely:
	<form:input path="kmenoveCislo" size="5" maxlength="5" float="right" /> /
	<form:input path="podlomeniCisla" size="5" maxlength="3" align="right" />

	<br />
			Výměra:
	<form:input path="vymera" size="5" maxlength="80" align="center" />
	<br />


	<c:choose>
			<c:when test="${parcela['new']}">
				<p class="submit">
					<input type="submit" value="Přidat parcelu" />
				</p>
			</c:when>
			<c:otherwise>
				<p class="submit">
					<input type="submit" value="Upravit parcelu" />
				</p>
			</c:otherwise>
		</c:choose>
	</tr>
	</table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
