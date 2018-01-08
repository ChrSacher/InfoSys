package InfoSys;

/**
 * Klasse, die alle Produkt beschreibt.
 * 
 * @author dieu huyen
 *
 */
public class Artikel {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getId() {
		return id;
	}

	private final String id;
	private String name;
	private String beschreibung;

	public Artikel(String id, String name, String beschreibung) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
	}

}
