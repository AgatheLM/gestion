package fr.intervia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.intervia.dao.CompteExploitationDAO;
import fr.intervia.dao.CompteMensuelDAO;
import fr.intervia.dao.ConsultantDAO;
import fr.intervia.dao.MoisCampagneDAO;
import fr.intervia.domaine.CompteExploitation;
import fr.intervia.domaine.CompteMensuel;
import fr.intervia.domaine.Consultant;
import fr.intervia.domaine.MoisCampagne;
import fr.intervia.service.CompteExploitationService;
import fr.intervia.service.CompteMensuelService;
import fr.intervia.service.MoisCampagneService;

@Controller
public class CompteMensuelController {
	
	@Autowired
	private CompteMensuelDAO faDAO;
	@Autowired
	private MoisCampagneDAO moisDAO;
	@Autowired
	private ConsultantDAO consultantDAO;
	@Autowired
	private CompteMensuelService fService;
	@Autowired
	private MoisCampagneService moisService;
	@Autowired
	private CompteExploitationService ceService;


	@GetMapping("/consultant/{id}/flux")
	public String flux(Model model, @PathVariable("id") int id) {
		
		//On initialise les infos sur le consultant
		Consultant consultant = consultantDAO.find(id);
		// On réccupère les infos sur le mois
		List<MoisCampagne> listeMois= moisDAO.loadMois();
		MoisCampagne moisCourant= moisService.getMoisCourant(listeMois);
		// On récupère les comptes mensuels
		List<CompteMensuel> fa = faDAO.findByCode(consultant.getCodeConsultant());
		// 	o	n identifie le compte courant
		CompteMensuel cmCourant = fService.getCompte(fa, moisCourant);
		Map<String,Float> cumuls = fService.calculerCumul(fa, moisCourant);
		Map<String,Double> cumulPaie = ceService.calculerCum(fa, moisCourant);

		model.addAttribute("consultant", consultant);
		model.addAttribute("fluxActivite", fa);;
		model.addAttribute("fluxCumul", cumuls);
		//Données nécessaire au compte d'exploitation
		model.addAttribute("factureHT", fService.calculerFactureHT(fa, moisCourant));
		model.addAttribute("commission", fService.calculerCommission(fa));
		model.addAttribute("moisCourant", moisCourant);
		model.addAttribute("cmCourant", cmCourant);
		model.addAttribute("sousTotal", ceService.calculerSousTotal(cmCourant.getComptes()));
		model.addAttribute("cumulPaie", cumulPaie);
				
		return "compteMensuel";
	}
	

}
