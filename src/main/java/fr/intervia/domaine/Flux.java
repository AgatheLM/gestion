package fr.intervia.domaine;

public class Flux {
	
	private String typeFlux;
	private float jours;
	private float tarif;
	
	//Constructeur
	public Flux(String type_flux, int jours, int tarif) {
		super();
		this.typeFlux=type_flux;
		this.jours = jours;
		this.tarif = tarif;
	}
	
	public Flux() {
		super();
	}
	
	//Get et Set
	public float getJours() {
		return jours;
	}

	public void setJours(float f) {
		this.jours = f;
	}
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	
	public String getTypeFlux() {
		return typeFlux;
	}

	public void setTypeFlux(String type_flux) {
		this.typeFlux = type_flux;
	}

	// Methode getCumul
	public float calculPdt() {
		return jours*tarif;
	}

}
