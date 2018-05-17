package metier;

public class AssoIngredientRecette {

	private int id, idIngredient, idRecette, quantite;

	public AssoIngredientRecette(int id, int idIngredient, int idRecette, int quantite) {
		super();
		this.id = id;
		this.idIngredient = idIngredient;
		this.idRecette = idRecette;
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

}
