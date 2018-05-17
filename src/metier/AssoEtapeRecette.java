package metier;

public class AssoEtapeRecette {
	private int id, idRecette, idEtape;

	public AssoEtapeRecette(int id, int idRecette, int idEtape) {
		super();
		this.id = id;
		this.idRecette = idRecette;
		this.idEtape = idEtape;
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
