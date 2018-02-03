package fr.intervia.domaine;

import fr.intervia.domaine.MoisCampagne.Etat.Mois;

public class MoisCampagne {

	private Mois mois;
	private int annee;
	private Etat etat;

	
	//Constructor
	public MoisCampagne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MoisCampagne(Mois mois, int annee, Etat etat) {
		super();
		this.mois = mois;
		this.annee = annee;
		this.etat = etat;
	}

	public MoisCampagne(Mois mois, int annee) {
		super();
		this.mois = mois;
		this.annee = annee;
	}


	//Getters and setters
	public Mois getMois() {
		return mois;
	}

	public void setMois(Mois mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	// methods
	public boolean inf(MoisCampagne mois) {
		return (this.getAnnee() < mois.getAnnee() || 
				(this.getAnnee() == mois.getAnnee()) && this.getMois().getNum() < mois.getMois().getNum());
	}
	
	public boolean equals(MoisCampagne mois) {
		return (this.getMois()==mois.getMois() && this.getAnnee()==mois.getAnnee()) ;
	}
	
	//Enum pour l'état du mois
	public enum Etat {

		O((String) "O", "Ouvert"),
		F((String) "F", "Fermé");

		private String libelle;
		private String code;

		private Etat(String code, String libelle) {
			this.code = code;
			this.libelle = libelle;
		}

		public String getLibelle() {
			return libelle;
		}

		public String getCode() {
			return code;
		}

		public static Etat of(String titre) {
			switch (titre) {
				case "O":
					return O;
				default:
					return F;
			}
		}
		
		//Enumération pour le mois
		public enum Mois {

			JAN(1, "JANVIER"),
			FEV(2, "FEVRIER"),
			MAR(3, "MARS"),
			AVR(4, "AVRIL"),
			MAI(5, "MAI"),
			JUIN(6, "JUIN"),
			JUIL(7, "JUILLET"),
			AOU(8, "AOUT"),
			SEP(9, "SEPTEMBRE"),
			OCT(10, "OCTOBRE"),
			NOV(11, "NOVEMBRE"),
			DEC(12, "DECEMBRE");
			

			private String libelle;
			private int num;

			private Mois(int num, String libelle) {
				this.num = num;
				this.libelle = libelle;
			}

			public String getLibelle() {
				return libelle;
			}

			public int getNum() {
				return num;
			}

			public static Mois of(int titre) {
				switch (titre) {
					case 1:
						return JAN;
					case 2:
						return FEV;
					case 3:
						return MAR;
					case 4:
						return AVR;
					case 5:
						return MAI;
					case 6:
						return JUIN;
					case 7:
						return JUIL;
					case 8:
						return AOU;
					case 9:
						return SEP;
					case 10:
						return OCT;
					case 11:
						return NOV;
					case 12:
						return DEC;	
					default:
						return DEC;
				}
			}
	}
	}

}
