package metier;

public enum Type {
	
	Dessert("Dessert"), Plat("Plat"), Entree("Entree"), Boisson("Boisson");
	
	private String libelle;
	
	Type (String lib){ this.libelle = lib; }
	
	public String getLibelle() { return libelle; } 
}
