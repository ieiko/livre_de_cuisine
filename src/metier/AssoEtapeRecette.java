package metier;

public class AssoEtapeRecette {

	private int id, idEtape, idRecette, ordre;

	public AssoEtapeRecette(int id, int idEtape, int idRecette, int ordre) {
		super();
		this.id = id;
		this.idEtape = idEtape;
		this.idRecette = idRecette;
		this.ordre = ordre;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}	
}
