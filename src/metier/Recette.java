package metier;

public class Recette {
	private int id;
	private String name, resume;
	private Type type;
	
	public Recette(int id, String name, String resume, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.resume = resume;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	

}
