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

import fr.intervia.dao.ConsultantDAO.ConsultantRowMapper;
import fr.intervia.domaine.Consultant;
import fr.intervia.domaine.FluxActivite;

@Repository
public class FluxActiviteDAO extends JdbcDaoSupport{
	
	@Autowired
	private DataSource dataSource;
	
	 @PostConstruct
	    private void initialize(){
	        setDataSource(dataSource);
	    }

	@Autowired
	private FluxActiviteRowMapper rowMapper;

	private JdbcTemplate template;


	private static final String SQL_FIND_BY_NOM = "select * from public.flux_activite where nom = ?";
	
	@PostConstruct
	private void postConstruct() {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<FluxActivite> findByNom(String nom) {
		System.out.println(SQL_FIND_BY_NOM);
		return template.query(SQL_FIND_BY_NOM, new Object[] {nom}, rowMapper);

	}
	
	@Component
	public class FluxActiviteRowMapper implements RowMapper<FluxActivite> {

		@Override
		public FluxActivite mapRow(ResultSet rs, int rowNum) throws SQLException {
			FluxActivite fa = new FluxActivite();
			fa.setFrais(rs.getDouble("frais"));
			fa.setJours(rs.getDouble("jours"));
			fa.setMois(rs.getString("mois"));
			fa.setMois_date(rs.getDate("mois_date"));
			fa.setMois_files(rs.getString("mois_files"));
			fa.setNom(rs.getString("nom"));
			fa.setProv_jours(rs.getDouble("prov_jours"));
			fa.setProv_tarif(rs.getDouble("prov_tarif"));
			fa.setTarif(rs.getDouble("tarif"));
			return fa;
		}

	}

}
