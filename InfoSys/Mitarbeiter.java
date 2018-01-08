package InfoSys;

/**
 * Mitarbeiter Constructor
 * 
 * @author dieu huyen
 *
 */
public class Mitarbeiter {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	private final String id;
	private String name;

	public Mitarbeiter(String id, String name) {
		this.id = id;
		this.name = name;
	}

}
