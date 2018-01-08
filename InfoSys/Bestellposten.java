package InfoSys;

/**
 * Klasse welche eine bestimmten Menge des Produktes jeder Bestellung enthält.
 * 
 * @author dieu huyen
 *
 */
public class Bestellposten {
	private final String artikelID;
	private final int anzahl;

	public Bestellposten(String artikelID, int anzahl) {
		this.artikelID = artikelID;
		this.anzahl = anzahl;
	}

	public String getArtikelID() {
		return artikelID;
	}

}
