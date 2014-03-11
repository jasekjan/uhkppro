<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<h2>Najít katastr:</h2>

<spring:url value="/katastry" var="formUrl"/>
<form:form modelAttribute="katastr" action="${fn:escapeXml(formUrl)}" method="get">
  <table>
    <tr>
      <th>
        Kód: <form:errors path="*" cssClass="errors"/>
        <br/> 
        <form:input path="kod" size="30" maxlength="80" />
      </th>
    </tr>
    <tr>
      <td><p class="submit"><input type="submit" value="Najít klienta"/></p></td>
    </tr>
  </table>
</form:form>

<br/>
<a href='<spring:url value="/klienti/novy" htmlEscape="true"/>'>Nový klient</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
