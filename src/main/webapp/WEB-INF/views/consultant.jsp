<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
		<title>Intervia &ndash; Consultant</title>
	</head>
	<body>
		<h1>Informations consultant</h1>
		<c:if test="${not empty modification}">
			<p class="success">Le consultant a été modifié avec succès.</p>
		</c:if>
		<br />
		<strong>Consultant n<sup>o</sup> ${consultant.id}</strong>
		<ul>
			<li><label>Code :</label> ${consultant.codeConsultant}</li>
			<li><label>Nom :</label> ${consultant.nom}</li>
			<li><label>Prenom :</label> ${consultant.prenom}</li>
			<li><label>Etat : </label> ${consultant.statut}</li>
			<li><label>Client : </label> ${consultant.client}</li>
			
		</ul>
		<c:url var="url" value="/accueil" />
		<p><a href="${url}">Accueil</a> | <a href="<c:url value="/modification/${consultant.id}" />">Modifier consultant</a></p>
	</body>
</html>
