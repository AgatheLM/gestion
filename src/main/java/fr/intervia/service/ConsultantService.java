package fr.intervia.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;

public class ConsultantService {

	@Autowired
	private ConsultantDAO consultantDao;

	public boolean nomDejaUtilise(Consultant consultant) {
		Consultant c = consultantDao.findByNom(consultant.getNom());
		if (c!=null) {
			return true;
		}else {
			return false;
		}
	}
}
