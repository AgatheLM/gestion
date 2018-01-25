<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/static/css/application.css">
		<title>Spring MVC &ndash; Nouveau consultant</title>
	</head>
	<body>
		<h1>Nouveau consultant</h1>
		<c:url value="/consultant/nouveau" var="url" />
		<form:form action="${url}" modelAttribute="consultant" method="post" >

			
			<label>Nom&nbsp;:</label>
			<form:input type="text" path="nom" /><br/>
			<form:errors cssClass="error" path="nom" /><br/>
			
			<label>Prenom&nbsp;:</label>
			<form:input type="text" path="prenom" /><br/>
			<form:errors cssClass="error" path="prenom" /><br/>
			
			
			<label>Statut&nbsp;:</label>
			<form:select path="statut" >
				<form:options itemLabel="libelle" />
			</form:select><br/>
			<form:errors cssClass="error" path="statut" /><br/>
			
			<button type="submit">Créer</button>
		</form:form>
	</body>
</html>
