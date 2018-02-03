package fr.intervia.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.intervia.dao.CompteMensuelDAO;
import fr.intervia.domaine.CompteMensuel;

@Component
public class FluxActiviteConverter implements Converter<String, List<CompteMensuel>> {

	@Autowired
	private CompteMensuelDAO faDAO;

	@Override
	public 	List<CompteMensuel> convert(String code) {
		List<CompteMensuel> fa = faDAO.findByCode(code);
		return fa;
	}

	

}
