package fr.intervia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.dao.FluxActiviteDAO;
import fr.intervia.domaine.Consultant;
import fr.intervia.domaine.FluxActivite;

@Controller
public class FluxActiviteController {
	
	@Autowired
	private FluxActiviteDAO faDAO;
	@Autowired
	private ConsultantDAO consultantDAO;

	@GetMapping("/consultant/{id}/flux")
	public String flux(Model model, @PathVariable("id") int id) {
		Consultant consultant = consultantDAO.find(id);
		List<FluxActivite> fa = faDAO.findByNom(consultant.getNom());
		model.addAttribute("consultant", consultant);
		model.addAttribute("fluxActivite", fa);
		
		return "fluxActivite";
	}
	

}
