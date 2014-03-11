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