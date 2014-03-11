<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<h2>Najít LV:</h2>

<spring:url value="/listyVlastnictvi" var="formUrl"/>
<form:form modelAttribute="listVlastnictvi" action="${fn:escapeXml(formUrl)}" method="get">
  <table>
    <tr>
      <th>
        Číslo: <form:errors path="*" cssClass="errors"/>
        <br/> 
        <form:input path="cislo" size="30" maxlength="80" />
      </th>
    </tr>
    <tr>
      <td><p class="submit"><input type="submit" value="Najít LV"/></p></td>
    </tr>
  </table>
</form:form>

<br/>
<a href='<spring:url value="/klienti/novy" htmlEscape="true"/>'>Nový klient</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
