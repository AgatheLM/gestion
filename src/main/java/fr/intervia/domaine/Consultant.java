package fr.intervia.domaine;

public class Consultant {
	private int id;
	private String nom;
	private String prenom;
	private String code_consultant;
	public String getCode_consultant() {
		return code_consultant;
	}

	public void setCode_consultant(String code_consultant) {
		this.code_consultant = code_consultant;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}


	private Statut statut;
	private String client;
	public Consultant() {
		super();
	}

	public Consultant(int id, String code_consultant, String nom, String prenom, Statut statut, String client) {
		super();
		this.code_consultant=code_consultant;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.client= client;
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
