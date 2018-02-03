package fr.intervia.domaine;


import java.util.List;

public class CompteMensuel {

	private String code;
	private Flux forfait;
	private Flux frais;
	private Flux astreinte;
	private Flux prov;
	private MoisCampagne mois;
	private float taux;
	private List<CompteExploitation> comptes;


	// Constructeurs

	public CompteMensuel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteMensuel(String code, Flux forfait, Flux frais, Flux astreinte, Flux prov, MoisCampagne mois,
			float taux, List<CompteExploitation> comptes) {
		super();
		this.code = code;
		this.forfait = forfait;
		this.frais = frais;
		this.astreinte = astreinte;
		this.prov = prov;
		this.mois = mois;
		this.taux=taux;
		this.comptes=comptes;
	}	



	//Getter and Setter
	
	public float getTaux() {
		return taux;
	}
	public List<CompteExploitation> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteExploitation> comptes) {
		this.comptes = comptes;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
	public Flux getForfait() {
		return forfait;
	}
	public void setForfait(Flux forfait) {
		this.forfait = forfait;
	}
	public Flux getFrais() {
		return frais;
	}
	public void setFrais(Flux frais) {
		this.frais = frais;
	}
	public Flux getAstreinte() {
		return astreinte;
	}
	public void setAstreinte(Flux astreinte) {
		this.astreinte = astreinte;
	}
	public Flux getProv() {
		return prov;
	}
	public void setProv(Flux prov) {
		this.prov = prov;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public MoisCampagne getMois() {
		return mois;
	}
	public void setMois(MoisCampagne mois) {
		this.mois = mois;
	}
	
	
}
