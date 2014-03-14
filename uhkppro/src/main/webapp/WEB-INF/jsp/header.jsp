<!--
	Správa nájemních smluv
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="<spring:url value="/static/projekt.css" htmlEscape="true" />"
	type="text/css" />
<title>Správa pozemků</title>
</head>
<SCRIPT language="javascript">
	function addRow(tableID) {

		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);	
		
	    var cell1 = row.insertCell(0);
	    var element1 = document.createElement("input");
	    element1.type = "checkbox";
		element1.name = "chkbox[]";
	    cell1.appendChild(element1);
	    
	    var cell2 = row.insertCell(1);
	    var element2 = document.createElement("input");
	    element2.type = "text";
	    cell2.appendChild(element2);
	    
	    var cell3 = row.insertCell(2);
	    var element3 = document.createElement("input");
	    element3.type= "text";
	    cell3.appendChild(element3);
	    
	    cell4 = row.insertCell(3);
	    var element4 = document.createElement("input");
	    element4.type = "text";
	    cell4.appendChild(element4);
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for ( var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}

			}
		} catch (e) {
			alert(e);
		}
	}
</SCRIPT>
<body>
	<div id="main">
		<ul class="vertical_menu">
			<li><a href="<spring:url value="/klienti" htmlEscape="true" />">Klienti</a></li>
			<li><a href="<spring:url value="/katastry" htmlEscape="true" />">Katastry</a></li>
			<li><a href="<spring:url value="/parcely" htmlEscape="true" />">Pronajaté
					parcely</a></li>
			<li><a
				href="<spring:url value="/listyVlastnictvi" htmlEscape="true" />">Listvy
					vlastnictví</a></li>
			<li><a href="<spring:url value="/smlouvy" htmlEscape="true" />">Smlouvy</a></li>
		</ul>

		<ul class="vertical_menu_r">
		</ul>