package fr.intervia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.intervia.dao.ConsultantDAO;


@Controller
@PropertySource("classpath:application.properties")
public class AccueilController {

	@Value("${name}")
	private String name;
	
	@Autowired
	ConsultantDAO consultantDao;

	@RequestMapping("/")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public String welcome() {
		return "redirect:/accueil";
	}
	
	
	

	@RequestMapping(value = "/accueil")
	public String hello(Model model) {
		model.addAttribute("message", this.message());
		int nbcon = consultantDao.getNbConsultants();
		System.out.println("Le nombre de consultants est de" + nbcon);
		return "accueil";
	}

	private String message() {
		return "Bienvenue dans l'application de gestion " + name;
	}
}
