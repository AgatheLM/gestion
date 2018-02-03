package fr.intervia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.stereotype.Component;

import fr.intervia.domaine.CompteMensuel;
import fr.intervia.domaine.MoisCampagne;

@Component
public class CompteMensuelService {



	//Calculer les cumuls
	//pour toute la liste somme(jours*tarifs)
	public Map<String, Float> calculerCumul (List<CompteMensuel> Listefa, MoisCampagne mois) {

		Map<String, Float> hm= new HashMap<>();
		float fluxCumulForfait=0;
		float fluxCumulFrais=0;
		float fluxCumulAstreinte=0;
		float fluxCumulAProv=0;

		for (CompteMensuel fa : Listefa) {

			if (fa.getMois().inf(mois)) {

				fluxCumulForfait += fa.getForfait().calculPdt();
				fluxCumulFrais += fa.getFrais().calculPdt();	
				fluxCumulAstreinte += fa.getAstreinte().calculPdt();	
				fluxCumulAProv += fa.getProv().calculPdt();
				
			}
		} 
		hm.put("forfait", fluxCumulForfait);
		hm.put("frais", fluxCumulFrais);
		hm.put("astreinte", fluxCumulAstreinte);
		hm.put("prov", fluxCumulAProv);
		return hm;
	}

	//Calculer facture_HT
	public float calculerFactureHT(List<CompteMensuel> listefa, MoisCampagne mois){
		float facture;
		Map<String, Float> cumuls = this.calculerCumul(listefa, mois);
		float forfaitCum= cumuls.get("forfait");
		float astreinteCum= cumuls.get("astreinte");
		facture=forfaitCum+astreinteCum;
		return facture;
	}


	//Calculer commission
	public float calculerCommission (List<CompteMensuel> Listefa) {			
		float fluxCumulForfaitTaux=0;
		float fluxCumulAstreinteTaux=0;

		for (CompteMensuel fa : Listefa) {
			fluxCumulForfaitTaux += fa.getForfait().calculPdt()*fa.getTaux();
			fluxCumulAstreinteTaux += fa.getAstreinte().calculPdt()*fa.getTaux();	
		} 
		return fluxCumulForfaitTaux+fluxCumulAstreinteTaux;
	}

	public CompteMensuel getCompte(List<CompteMensuel> lCm, MoisCampagne moisCourant) {

		CompteMensuel cm = new CompteMensuel();

		for (CompteMensuel cmCurrent : lCm) {

			MoisCampagne moisCampagne = cmCurrent.getMois();

			if (moisCampagne.equals(moisCourant)) {
				cm = cmCurrent;
				break;
			}

		}

		return cm;

	}




}
