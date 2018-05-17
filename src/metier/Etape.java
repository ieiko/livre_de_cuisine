package metier;

public class Etape {

	private int id;
	private String name, body;
	
	public Etape(int id, String name, String body) {
		super();
		this.id = id;
		this.name = name;
		this.body = body;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
