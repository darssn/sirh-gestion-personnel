<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
</head>
<body>
	<h1>Les collaborateurs</h1>
	<ul>
		<%
			List<String> listeNoms = (List<String>) request.getAttribute("listeNoms");
		
			for (String nom : listeNoms) {
		%>
		<li><%= nom %></li>
		<%
			}
		%>
	</ul>
</body>
</html>