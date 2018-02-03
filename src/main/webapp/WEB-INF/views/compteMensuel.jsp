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
		<h1>Tableau de flux pour ${consultant.nom} - ${consultant.prenom}</h1>		
		<table>
		<tr>			
			<th rowspan=2>Mois</th>
			<th rowspan=2>Taux</th>
			<th colspan=2>Forfait </th>
			<th colspan=2>Frais</th>
			<th colspan=2>Prov</th>
			<th colspan=2>Astreinte</th>
		</tr>
		<tr>
			<th>Tarif</th>
			<th>Jours </th>
			<th>Tarif</th>
			<th>Jours </th>
			<th>Tarif</th>
			<th>Jours </th>
			<th>Tarif</th>
			<th>Jours </th>
		</tr>	
		<c:forEach items="${fluxActivite}" var="fluxActivite">
			<tr>
				<td>${fluxActivite.mois.mois.num}</td>
				<td>${fluxActivite.taux}</td>
				<td>${fluxActivite.forfait.tarif}</td>
				<td>${fluxActivite.forfait.jours}</td>
				<td>${fluxActivite.frais.tarif}</td>
				<td>${fluxActivite.frais.jours}</td>
				<td>${fluxActivite.prov.tarif}</td>
				<td>${fluxActivite.prov.jours}</td>
				<td>${fluxActivite.astreinte.tarif}</td>
				<td>${fluxActivite.astreinte.jours}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=2> Cumul </td>		
			<td colspan=2> ${fluxCumul.forfait}</td>
			<td colspan=2> ${fluxCumul.frais}</td>
			<td colspan=2> ${fluxCumul.prov}</td>
			<td colspan=2> ${fluxCumul.astreinte}</td>
		</tr>
		</table>
		
			<h1>Tableau de paye pour ${consultant.nom} - ${consultant.prenom}</h1>		
		<table>
		<tr>			
			<td> Date d'adhésion </td>
			<td> ${consultant.dateAdhesion}</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td> période de calcul commission début </td>
			<td> ${consultant.dateAdhesion}</td>
			<td>NOM</td>
			<td>${consultant.nom}</td>
			<td></td>
		</tr>	
		<tr>
			<td> période de calcul commission fin </td>
			<td> ${consultant.dateFinAdhesion}</td>
			<td>PRENOM</td>
			<td>${consultant.prenom}</td>
			<td>${moisCourant.mois.libelle}</td>
			<!-- TODO : gérér le mois -->
		</tr>
		<tr>
			<td>CLIENT</td>
			<td>${consultant.client}</td>
			<td>${consultant.codeConsultant}</td>
			<td>an</td>
			<td>${moisCourant.annee}</td>
			<!-- TODO : gérér l'année -->
		</tr>
		<tr>
			<td> </td>
			<td></td>
			<td colspan=2>CREDIT</td>
			<td>DEBIT</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td>CA HT facturé</td>
			<td>CA encaissé</td>
			<td></td>
		</tr>
		<tr>
			<td>FACTURES</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>A FIN</td>
			<td>${moisCourant.mois.libelle}</td>
			<td>${factureHT}</td>
			<td>${factureHT}</td>
			<td></td>
		</tr>
		<tr>
			<td>FRAIS REFACTURES AU CLIENT</td>
			<td></td>
			<td>${fluxCumul.frais}</td>
			<td>${fluxCumul.frais}</td>
			<td></td>
		</tr>
		<tr>
			<td>FRAIS DIVERS PAYES PAR INTERMISSION</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>PROVISION DEPART</td>
			<td></td>
			<td></td>
			<td></td>
			<td>${fluxCumul.prov}</td>
		</tr>
		<tr>
			<td>AUTRES PROVISION</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>PRELEVEMENT INTERMISSION</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>			
			<td>Mission en cours</td>
			<td>${cmCourant.taux}</td>
			<td></td>
			<td></td>
			<td>${commission}</td>
		</tr>
		<tr>
			<td>PAIE DES MOIS ECOULES</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Coût REM mois précédents (salaire brut+charges patronales)</td>
			<td></td>
			<td></td>
			<td></td>
			<td>${cumulPaie.salaireEtChargeCum}</td>
		</tr>
		<tr>
			<td>Frais de déplacement</td>
			<td></td>
			<td></td>
			<td></td>
			<td>${cumulPaie.fraisCum}</td>
		</tr>
		<tr>
			<td>TOTAL</td>
			<td></td>
			<td></td>
			<td>${factureHT+fluxCumul.frais}</td>
			<td>${cumulPaie.fraisCum+cumulPaie.salaireEtChargeCum+commission+fluxCumul.prov}</td>
		</tr>
		<tr>
			<td>Solde disponible avant paie du mois en cours</td>
			<td>${moisCourant.mois.libelle}</td>
			<td></td>
			<td>${factureHT+fluxCumul.frais}</td>
			<td>${factureHT+fluxCumul.frais-(cumulPaie.fraisCum+cumulPaie.salaireEtChargeCum+commission+fluxCumul.prov)}</td>
		</tr>
		<c:forEach items="${cmCourant.comptes}" var="ce">
			<tr>
				<td>${ce.libCompte.libelle}</td>
				<td></td>
				<td></td>
				<td></td>
				<td>${ce.val}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>sous-total</td>
			<td></td>
			<td></td>
			<td></td>
			<td>${sousTotal}</td>
		</tr>
		<tr>
			<td>SOLDE disponible après paie du mois en cours</td>
			<td></td>
			<td></td>
			<td></td>
			<td>${factureHT+fluxCumul.frais-(cumulPaie.fraisCum+cumulPaie.salaireEtChargeCum+commission+fluxCumul.prov)-sousTotal}</td>
		</tr>
		</table>
		
		
		<p><a href="<c:url value="/accueil" />">Accueil</a> | <a href="<c:url value="/consultants" />">Retour à la liste des consultants</a></p>
	</body>
</html>