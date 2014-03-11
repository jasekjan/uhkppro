<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h2>Informace o katastru</h2>

  <table>
    <tr>
      <td>Kód</td>
      <td><b>${katastr.kod}</b></td>
    </tr>
    <tr>
      <td>Název</td>
      <td>${katastr.nazev}</td>
    </tr>
  </table>
  <table class="table-buttons">
    <tr>
      <td colspan="2" align="center">
        <spring:url value="{katastrId}/edit" var="editUrl">
        	<spring:param name="katastrId" value="${katastr.id}" />
        </spring:url>
        <a href="${fn:escapeXml(editUrl)}">Uprav katastr</a>
      </td>
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
  						<tr><td>${podil.citatel}/${podil.jmenovatel }	${podil.klient.lastName } ${podil.klient.firstName }</td></tr>
  					</c:forEach>
  				</table>
  			</td>
  		</tr>
  	</c:forEach>
  </table>
  
<td><a href="<spring:url value="/katastry" htmlEscape="true" />">Katastry</a></td>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
