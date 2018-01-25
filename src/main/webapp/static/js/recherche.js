$(document).ready(function() {
	
	var context = this;
	var $champ = $('#champ-recherche');
	var $suggestions = $('#suggestions');
	var $commande = $('#commande');
	var $bouton = $('#bouton-commander');
	var $prix = $('#prix');
	
	var initialiser = function(context){
		$suggestions.hide();
		$champ.keyup(function(){
			rechercher($champ.val());
		});
		$bouton.click(function() {
			commander();
		});
	};
	
	var rechercher = function(q){
		$.ajax({
			url: '/consultant/recherche',
			method: 'GET',
			data: {'q': encodeURI(q)}
		}).done(function(consultants) {
			afficherSuggestions(consultants);
		});
	};
	
	/*var commander = function() {
		var cocktails = cocktailsChoisis();
		$.ajax({
			url: '/cocktails/commande',
			method: 'POST',
			contentType : 'application/json; charset=utf-8',
			data: JSON.stringify(cocktails)
		}).done(function(prix) {
			afficherPrix(prix);
		});
	};*/
	
	/*var cocktailsChoisis = function() {
		var cocktails = [];
		$('#commande li.hidden').each(function(index, item) {
			cocktails.push({
				id: $(item).text()
			});
		});
		return cocktails;
	};*/
	
	var afficherSuggestions = function(consultants) {
		if(consultants.length > 0){
			suggerer(consultants);
			$suggestions.show();
		}
		else {
			$suggestions.hide();
		}
	};
	
	/*var afficherPrix = function(prix){
		$prix.text(': ' + prix + ' €');
	};*/
	
	var suggerer = function(consultants){
		$suggestions.empty();
		$.each(consultants, function(index, consultant) {
			$suggestions.append($('<li>').append(consultant.nom).append(" ").append(consultant.prenom));
			$suggestions.append($('<li class="hidden">').append(consultant.id));
		});
		$suggestions.find('li').each(function(index, item) {
			$item = $(item);
			$item.click(function() {
				var $libelle = $(this);
				var $id = $libelle.next();
				choisir($id.text(), $libelle.text());
			});
		})
	};
	
	var choisir = function(id, nom){
		var $item = $('<li>').append(nom);
		$item.click(function() {
			$(this).next().remove();
			$(this).remove();
		});
		$commande.append($item);
		$commande.append($('<li class="hidden">').append(id));
		$suggestions.empty();
		$suggestions.hide();
		$champ.val('');
		$champ.focus();
	};
	
	
	initialiser(context);
});