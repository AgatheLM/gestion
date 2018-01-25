package fr.intervia.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.intervia.dao.ConsultantDAO;
import fr.intervia.domaine.Consultant;

@Component
public class ConsultantConverter implements Converter<String, Consultant> {

	@Autowired
	private ConsultantDAO consultantDAO;

	@Override
	public 	Consultant convert(String id) {
		Consultant consultant = consultantDAO.find(Integer.valueOf(id));
		return consultant;
	}

}
