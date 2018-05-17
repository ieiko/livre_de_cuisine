package metier;

public class AssoIngredientRecette {

	private int id, idIngredient, idRecette, quantite;
	private Unite unite;

	public AssoIngredientRecette(int id, int idIngredient, int idRecette, int quantite, Unite unite) {
		super();
		this.id = id;
		this.idIngredient = idIngredient;
		this.idRecette = idRecette;
		this.quantite = quantite;
		this.unite = unite;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
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
