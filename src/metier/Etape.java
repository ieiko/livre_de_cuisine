package metier;

public class Etape {

	private int id, duration;
	private String name, body;

	
	public Etape(int id, String name, String body, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.body = body;
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
