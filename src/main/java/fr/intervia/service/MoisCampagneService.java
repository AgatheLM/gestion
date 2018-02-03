package fr.intervia.service;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.intervia.domaine.MoisCampagne;
import fr.intervia.domaine.MoisCampagne.Etat.Mois;

@Component
public class MoisCampagneService {
	
	public MoisCampagne getMoisCourant(List<MoisCampagne> listeMois) {
		MoisCampagne moisCourant=new MoisCampagne();
		for (MoisCampagne mois: listeMois) {
			if (mois.getEtat().getCode()=="O") {
				moisCourant=mois;
				break;
			}
		}
		return moisCourant;
	}
	
	public MoisCampagne getMoisPrecedent(List<MoisCampagne> listeMois) {
		MoisCampagne moisCourant=this.getMoisCourant(listeMois);
		MoisCampagne moisPrecedent= new MoisCampagne();
		for (MoisCampagne mois: listeMois) {
			if ((!(moisCourant.getMois().equals(Mois.JAN)) && mois.getMois().getNum()==moisCourant.getMois().getNum()-1 && mois.getAnnee()==moisCourant.getAnnee())
				||(moisCourant.getMois().equals(Mois.JAN) && mois.getMois().equals(Mois.DEC) && mois.getAnnee()+1==moisCourant.getAnnee())
				){
				moisPrecedent=mois;
				break;
			}
		}
		return moisPrecedent;
	}
	
}
