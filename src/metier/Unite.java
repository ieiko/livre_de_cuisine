package metier;

public enum Unite {

	mG("milligramme"), G("gramme"), mL("millilitre"), L("litre"), Oz("Oz"), NC("");
	
	private String libelle;
	
	Unite (String lib){ this.libelle = lib; }
	
	public String getLibelle() { return libelle; }
}
