<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="content">
	<ul class="vertical_menu_r">
		<li><a href="klienti/novy">Nový</a></li>
	</ul>

	<table>
		<tr>
			<td><a href="<spring:url value="/klienti/search" htmlEscape="true" />">Hledat klienta</a></td>
		</tr>
	</table>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
