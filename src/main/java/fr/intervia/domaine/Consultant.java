package fr.intervia.domaine;

import java.util.Date;

public class Consultant {
	private int id;
	private String nom;
	private String prenom;
	private String codeConsultant;
	private Date dateAdhesion;
	private Date dateFinAdhesion;
	private String client;
	private String societe;
	private Statut statut;
	
	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}



	
	public Date getDateFinAdhesion() {
		return dateFinAdhesion;
	}

	public void setDateFinAdhesion(Date dateFinAdhesion) {
		this.dateFinAdhesion = dateFinAdhesion;
	}

	public String getCodeConsultant() {
		return codeConsultant;
	}

	public void setCodeConsultant(String code_consultant) {
		this.codeConsultant = code_consultant;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}




	public Consultant() {
		super();
	}

	public Consultant(int id, String code_consultant, String nom, String prenom, Statut statut, String client, Date dateDeb, Date dateFin, String societe) {
		this.codeConsultant=code_consultant;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.client= client;
		this.societe= societe;
		this.dateAdhesion=dateDeb;
		this.dateFinAdhesion=dateFin;
	}


	public Date getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	

	
	public enum Statut {

		A((String) "A", "Actif"),
		I((String) "I", "Inactif");

		private String libelle;
		private String code;

		private Statut(String code, String libelle) {
			this.code = code;
			this.libelle = libelle;
		}

		public String getLibelle() {
			return libelle;
		}

		public String getCode() {
			return code;
		}

		public static Statut of(String titre) {
			switch (titre) {
				case "I":
					return I;
				default:
					return A;
			}
		}
	}
}
