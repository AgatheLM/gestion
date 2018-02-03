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

import fr.intervia.domaine.MoisCampagne;
import fr.intervia.domaine.MoisCampagne.Etat;
import fr.intervia.domaine.MoisCampagne.Etat.Mois;

@Repository
public class MoisCampagneDAO extends JdbcDaoSupport {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Autowired
	private FluxActiviteRowMapper rowMapper;
	private JdbcTemplate template;

	private static final String SQL_CHARGE_MOIS = "select extract(month from mois) as mois, extract(year from mois) as annee, etat from campagne";

	@PostConstruct
	private void postConstruct() {
		this.template = new JdbcTemplate(dataSource);
	}

	public List<MoisCampagne> loadMois() {
		System.out.println(SQL_CHARGE_MOIS);
		return template.query(SQL_CHARGE_MOIS, rowMapper);

	}

	@Component
	public class FluxActiviteRowMapper implements RowMapper<MoisCampagne> {

		@Override
		public MoisCampagne mapRow(ResultSet rs, int rowNum) throws SQLException {
			MoisCampagne mois = new MoisCampagne();
			mois.setMois(Mois.of(rs.getInt("mois")));
			mois.setAnnee(rs.getInt("annee"));
			mois.setEtat(Etat.of(rs.getString("etat")));

			return mois;
		}
	}
}
