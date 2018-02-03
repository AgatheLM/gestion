<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
		<title>Intervia &ndash; Consultants</title>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="/static/js/recherche.js"></script>
		
	</head>
	<body>	
		<h1>Rechercher un consultant</h1>
		<div class="consultant">
			<div id="bloc-recherche">
				<input id="champ-recherche" type="text" placeholder="Rechercher un consultant" autocomplete="off" /><br/>
				<ul id="suggestions"></ul>				
			</div>
		</div>
		<h1>Liste des consultants</h1>
		<c:if test="${not empty nouveauConsultant}">
			<p class="success">Le consultant <c:out value="${nouveauConsultant.nom}" /> a été créé avec succès.</p>
		</c:if>
		<table>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Statut</th>
			<th>Flux - Activité</th>
		</tr>
		<c:forEach items="${consultants}" var="consultant">
			<c:url var="url" value="consultant/${consultant.id}" />
			<c:url var="urlFlux" value="consultant/${consultant.id}/flux" />
			<tr>
				<td><a href="${url}">${consultant.nom}</a></td>
				<td>${consultant.prenom}</td>
				<td>${consultant.statut}</td>
				<td><a href="${urlFlux}">Consulter</a></td>
			</tr>
		</c:forEach>
		</table>
		<p><a href="<c:url value="/accueil" />">Accueil</a> | <a href="<c:url value="/consultant/nouveau" />">Nouveau consultant</a></p>
	</body>
</html>