<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:choose>
	<c:when test="${smlouva['new']}">
		<c:set var="method" value="post" />
	</c:when>
	<c:otherwise>
		<c:set var="method" value="put" />
	</c:otherwise>
</c:choose>

<div class="content">
	<h2>
		<c:choose>
			<c:when test="${smlouva['new']}">Nová smlouva</c:when>
			<c:otherwise>Smlouva</c:otherwise>
		</c:choose>
	</h2>
	<form:form modelAttribute="smlouva" method="${method}">
		<table>
			<tr>
				<td>Identifikátor:</td>
				<td><form:errors path="identifikator" cssClass="errors" /> <form:input
						path="identifikator" size="10" maxlength="50" /></td>

			</tr>
			<tr>
				<td>Klient:</td>
				<td><form:select path="klient" items="${klienti}" /></td>
				</br>
			</tr>
			<tr>
				<td>Účinnost od:</td>
				<td><form:errors path="ucinnostOd" cssClass="errors" /> <form:input
						path="ucinnostOd" size="10" maxlength="10" /> (den.měsíc.rok)</td>
				</br>

			</tr>
			<tr>
				<td>Účinnost do:</td>
				<td><form:errors path="ucinnostDo" cssClass="errors" /> <form:input
						path="ucinnostDo" size="10" maxlength="10" /> (den.měsíc.rok)</td>
				</br>

			</tr>
			<tr>
				<td>Sazba:</td>
				<td><form:input path="sazbaHa" size="10" maxlength="10" /> Kč</td>
				</br>
			</tr>
		</table>

		<h2">Parcely</h2>
		<INPUT type="button" value="Přidat" onclick="addRow('dataTable')" />
		<INPUT type="button" value="Smazat vybrané"
			onclick="deleteRow('dataTable')" />

		<table id="dataTable" border="1" style="border: 2px solid black;"
			align-right="210px">
			<thead>
				<th></th>
				<th align="right">Kmenové č. parc.</th>
				<th>Podlomení č. parc.</th>
				<th align="right">Výměra (m<sup>2</sup>)
				</th>
			</thead>
			<c:forEach var="parsm" items="${smlouva.parcely}">
				<tr>
					<TD><INPUT type="checkbox" name="chk" /></TD>
					<form:form modelAttribute="parcela" method="${method}}">
						<td align="right">${parsm.kmenoveCislo}</td>
						<td>${parsm.podlomeniCisla}</td>
						<td align="right">${parsm.vymera }</td>
						<td><p class="submit">
								<input type="submit" value="OK" />
							</p></td>
					</form:form>
				</tr>
			</c:forEach>
		</table>

		<c:choose>
			<c:when test="${smlouva['new']}">
				<p class="submit">
					<input type="submit" value="Přidat smlouvu" />
				</p>
			</c:when>
			<c:otherwise>
				<p class="submit">
					<input type="submit" value="Uložit změny" />
				</p>
			</c:otherwise>
		</c:choose>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
