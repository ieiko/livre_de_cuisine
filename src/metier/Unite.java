package metier;

public enum Unite {

	mG("milligramme"), mL("millilitre"), Oz("Oz"), NC("");
	
	private String libelle;
	
	Unite (String lib){ this.libelle = lib; }
	
	public String getLibelle() { return libelle; }
}
