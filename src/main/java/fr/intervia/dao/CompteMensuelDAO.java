package fr.intervia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.intervia.domaine.CompteExploitation;
import fr.intervia.domaine.Flux;
import fr.intervia.domaine.MoisCampagne;
import fr.intervia.domaine.MoisCampagne.Etat.Mois;
import fr.intervia.domaine.CompteMensuel;

@Repository
public class CompteMensuelDAO extends JdbcDaoSupport{
	
	@Autowired
	private DataSource dataSource;
	
	 @PostConstruct
	    private void initialize(){
	        setDataSource(dataSource);
	    }

	@Autowired
	private FluxActiviteRowMapper rowMapper;
	
	@Autowired
	private CompteExploitationDAO ceDAO;

	private JdbcTemplate template;


	private static final String SQL_FIND_BY_CODE = "select code_consultant, "
			+ "extract(month from mois_date) as mois, extract(year from mois_date) as annee, "
			+ "forfait_tarif, forfait_jours, frais_tarif, frais_jours, prov_tarif, prov_jours, astreinte_tarif, astreinte_jours, taux " 
			+ "from public.flux_activite where code_consultant = ? order by mois_date;";
	
	@PostConstruct
	private void postConstruct() {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<CompteMensuel> findByCode(String code) {
		System.out.println(SQL_FIND_BY_CODE);
		return template.query(SQL_FIND_BY_CODE, new Object[] {code}, rowMapper);

	}
	
	@Component
	public class FluxActiviteRowMapper implements RowMapper<CompteMensuel> {

		@Override
		public CompteMensuel mapRow(ResultSet rs, int rowNum) throws SQLException {
			CompteMensuel fa = new CompteMensuel();
			MoisCampagne mois = new MoisCampagne(Mois.of(rs.getInt("mois")), rs.getInt("annee"));
			fa.setMois(mois);
			fa.setCode(rs.getString("code_consultant"));
			fa.setTaux(rs.getFloat("taux"));
			//les flux			
			//Forfait
			Flux forfait = new Flux();
			forfait.setTypeFlux("Forfait");
			forfait.setJours(rs.getFloat("forfait_jours"));
			forfait.setTarif(rs.getFloat("forfait_tarif"));
			fa.setForfait(forfait);
			// Frais
			Flux frais = new Flux();
			frais.setTypeFlux("Frais");
			frais.setJours(rs.getFloat("frais_jours"));
			frais.setTarif(rs.getFloat("frais_tarif"));
			fa.setFrais(frais);
			// Prov
			Flux prov = new Flux();
			prov.setTypeFlux("prov");
			prov.setJours(rs.getFloat("prov_jours"));
			prov.setTarif(rs.getFloat("prov_tarif"));
			fa.setProv(prov);
			//Astreinte
			Flux astreinte = new Flux();
			astreinte.setTypeFlux("astreinte");
			astreinte.setJours(rs.getFloat("astreinte_jours"));
			astreinte.setTarif(rs.getFloat("astreinte_tarif"));
			fa.setAstreinte(astreinte);
            // Ajout de la liste de comptes d'exploitation
			List<CompteExploitation> ce;
			String code=rs.getString("code_consultant");
			ce = ceDAO.findByCode(code, mois);
			fa.setComptes(ce);
			
			return fa;
		}

	}

}
