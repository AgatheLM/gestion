package fr.intervia.domaine;

import java.sql.Date;

import fr.intervia.domaine.Consultant.Statut;

public class FluxActivite {
	
	private String nom;
	private double tarif;
	private double jours;
	private double prov_tarif;
	private double prov_jours;
	private double frais;
	private Date mois_date;
	private String mois;
	private String mois_files;
	
	
	public FluxActivite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public FluxActivite(String nom, double tarif, double jours, double prov_tarif, double prov_jours, double frais,
			Date mois_date, String mois, String mois_files) {
		super();
		this.nom = nom;
		this.tarif = tarif;
		this.jours = jours;
		this.prov_tarif = prov_tarif;
		this.prov_jours = prov_jours;
		this.frais = frais;
		this.mois_date = mois_date;
		this.mois = mois;
		this.mois_files = mois_files;
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public double getJours() {
		return jours;
	}
	public void setJours(double jours) {
		this.jours = jours;
	}
	public double getProv_tarif() {
		return prov_tarif;
	}
	public void setProv_tarif(double prov_tarif) {
		this.prov_tarif = prov_tarif;
	}
	public double getProv_jours() {
		return prov_jours;
	}
	public void setProv_jours(double prov_jours) {
		this.prov_jours = prov_jours;
	}
	public double getFrais() {
		return frais;
	}
	public void setFrais(double frais) {
		this.frais = frais;
	}
	public Date getMois_date() {
		return mois_date;
	}
	public void setMois_date(Date mois_date) {
		this.mois_date = mois_date;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public String getMois_files() {
		return mois_files;
	}
	public void setMois_files(String mois_files) {
		this.mois_files = mois_files;
	}

}
