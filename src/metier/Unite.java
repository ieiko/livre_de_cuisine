package metier;

public enum Unite {

	milligramme("milligramme"), gramme("gramme"), millilitre("millilitre"), litre("litre"), Oz("Oz"), NC("NC");
	
	private String libelle;
	
	Unite (String lib){ this.libelle = lib; }
	
	public String getLibelle() { return libelle; }
}
