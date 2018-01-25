package fr.intervia.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;

@Controller
public class ModificationConsultantController {

	@Autowired
	private ConsultantDAO consultantDao;

	//@Autowired
	//private ConsultantValidator consultantValidator;

	@GetMapping("/modification/{consultant}")
	public String modificationConsultant(@PathVariable("consultant") Consultant consultant, Model model) {
		model.addAttribute("consultant", consultant);
		return "modification-consultant";
	}

	@PostMapping("/modification/{consultant}")
	public String modificationConsultantPost(@Valid Consultant consultant, BindingResult result, Model model, RedirectAttributes attributes) {
		//consultantValidator.validate(consultant, result);
		if (result.hasErrors()) {
			model.addAttribute("consultant", consultant);
			return "modification-consultant";
		}
		consultantDao.update(consultant);
		attributes.addFlashAttribute("modification", true);
		return "redirect:/consultant/" + consultant.getId();
	}
}
