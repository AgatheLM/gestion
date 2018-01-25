package fr.intervia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;

@Controller
public class ConsultantsController {

	@Autowired
	private ConsultantDAO consultantDAO;

	@GetMapping("/consultants")
	public String clients(Model model) {
		List<Consultant> consultants = consultantDAO.findAll();
		model.addAttribute("consultants", consultants);
		return "consultants";
	}
}
