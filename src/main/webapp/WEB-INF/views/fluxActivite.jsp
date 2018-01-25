<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
		<title>Intervia &ndash; Flux d'activité</title>
	</head>
	<body>	
		<h1>Tableau pour ${consultant.nom} - ${consultant.prenom}</h1>
		
		<table>
		<tr>
			
			<th>Mois</th>
			<th>Tarif</th>
			<th>Jours</th>
			<th>Jours (provision)</th>
			<th>Tarif (provision)</th>
			<th>Frais</th>

		</tr>
		<c:forEach items="${fluxActivite}" var="fluxActivite">
			<tr>
				<td>${fluxActivite.mois}</td>
				<td>${fluxActivite.tarif}</td>
				<td>${fluxActivite.jours}</td>
				<td>${fluxActivite.prov_tarif}</td>
				<td>${fluxActivite.prov_jours}</td>
				<td>${fluxActivite.frais}</td>
			</tr>
		</c:forEach>
		</table>
		<p><a href="<c:url value="/accueil" />">Accueil</a> | <a href="<c:url value="/consultants" />">Retour à la liste des consultants</a></p>
	</body>
</html>