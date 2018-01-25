package fr.intervia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;

@Controller
public class ConsultantController {
	
	@Autowired
	ConsultantDAO consultantDAO;

	@GetMapping("/consultant/{id}")
	public String consultant(Model model, @PathVariable("id") int id) {
		Consultant consultant = consultantDAO.find(id);
		model.addAttribute("consultant", consultant);
		return "consultant";
	}
	
	@GetMapping("/consultant/recherche")
	@ResponseBody
	public List<Consultant> recherche(@RequestParam("q") String q) {
		return consultantDAO.search(q);
	}
}
