package fr.intervia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;
import fr.intervia.domaine.Consultant.Statut;

 

@Controller
@RequestMapping("/consultant")
public class NouveauConsultantController {

	@Autowired
	private ConsultantDAO consultantDao;

	//@Autowired
	//private ConsultantValidator consultantValidator;

	@ModelAttribute("statut")
	private Statut[] titres() {
		return Statut.values();
	}

	@GetMapping("/nouveau")
	public String nouveauConsultant(Model model) {
		model.addAttribute("consultant", new Consultant());
		return "nouveau-consultant";
	}

	@PostMapping("/nouveau")
	public String nouveauConsultantPost(@Valid Consultant consultant, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		//consultantValidator.validate(consultant, result);
		if (result.hasErrors()) {
			model.addAttribute("consultant", consultant);
			return "nouveau-consultant";
		}
		consultantDao.insert(consultant);
		redirectAttributes.addFlashAttribute("nouveauConsultant", consultant);
		return "redirect:/consultants";
	}
}
