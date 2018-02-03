package fr.intervia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import fr.intervia.domaine.Consultant;
import fr.intervia.domaine.Consultant.Statut;
import fr.intervia.utils.Search;

@Repository
public class ConsultantDAO extends JdbcDaoSupport{

	@Autowired
	private DataSource dataSource;
	
	 @PostConstruct
	    private void initialize(){
	        setDataSource(dataSource);
	    }

	@Autowired
	private ConsultantRowMapper rowMapper;

	private JdbcTemplate template;

	private static final String SQL_COUNT = "select count(*) from public.consultants";
	private static final String SQL_FIND = "select * from public.consultants where id = ?";
	private static final String SQL_FIND_BY_NOM = "select * from public.consultants where nom = ?";
	private static final String SQL_SEARCH = "select * from public.consultants where nom like ? or prenom like ?";
	private static final String SQL_FIND_ALL = "select * from public.consultants order by nom";
	private static final String SQL_INSERT = "insert into public.consultants (id, code_consultant, nom, prenom, statut, client) values (nextval('public.consultant_id'), ?, ?, ?, ?,?)";
	private static final String SQL_UPDATE = "update public.consultants set code_consultant=?, nom = ?, prenom = ?, statut = ?, client=? where id = ?";

	@PostConstruct
	private void postConstruct() {
		this.template = new JdbcTemplate(dataSource);
	}

	public int getNbConsultants() {
		return  template.queryForObject(SQL_COUNT, null, int.class);

	}

	public Consultant find(int id) {
		Consultant consultant = (Consultant) template.queryForObject(SQL_FIND, new Object[]{id}, rowMapper);
		return consultant;

	}


	public Consultant findByNom(String nom) {
		System.out.println(SQL_FIND);
		Consultant consultant = (Consultant) template.queryForObject(SQL_FIND_BY_NOM, new Object[] {nom}, rowMapper);
		return consultant;

	}
	
	public List<Consultant> findAll() {
		return template.query(SQL_FIND_ALL, rowMapper);
	}

	public void insert(Consultant consultant) {
		template.update(SQL_INSERT, new Object[] {
			consultant.getCodeConsultant(),
			consultant.getNom(),
			consultant.getPrenom(),
			consultant.getStatut().getCode(),
			consultant.getClient()});
	}

	public void update(Consultant consultant) {
		template.update(SQL_UPDATE, new Object[] {
			consultant.getCodeConsultant(),
			consultant.getNom(),
			consultant.getPrenom(),
			consultant.getStatut().getCode(),
			consultant.getId()});
	}
	
	public List<Consultant> search(String search) {
		if (StringUtils.isBlank(search)) {
			return Lists.newArrayList();
		}
		String q = "%" + Search.normalize(search) + "%";
		return template.query(SQL_SEARCH,   new Object[] {q,q}, rowMapper);
	}


	@Component
	public class ConsultantRowMapper implements RowMapper<Consultant> {

		@Override
		public Consultant mapRow(ResultSet rs, int rowNum) throws SQLException {
			Consultant consultant = new Consultant();
			consultant.setCodeConsultant(rs.getString("code_consultant"));
			consultant.setId(rs.getInt("id"));
			consultant.setNom(rs.getString("nom"));
			consultant.setPrenom(rs.getString("prenom"));
			consultant.setClient(rs.getString("client"));
			consultant.setSociete(rs.getString("societe"));
			consultant.setStatut(Statut.of(rs.getString("statut")));
			consultant.setDateAdhesion(rs.getDate("date_adhesion"));
			consultant.setDateFinAdhesion(rs.getDate("date_fin_adhesion"));
			return consultant;
		}

	}
	
	

	
	

}
