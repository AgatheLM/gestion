package fr.intervia.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.intervia.dao.FluxActiviteDAO;
import fr.intervia.domaine.FluxActivite;

@Component
public class FluxActiviteConverter implements Converter<String, List<FluxActivite>> {

	@Autowired
	private FluxActiviteDAO faDAO;

	@Override
	public 	List<FluxActivite> convert(String nom) {
		List<FluxActivite> fa = faDAO.findByNom(nom);
		return fa;
	}

	

}
