package InfoSys;

/**
 * Klasse welche den Eingang der Bestellung bestätigt.
 * 
 * @author dieu huyen
 *
 */
public class Bestellbestaetigung {
	private final boolean ausgefuehrt;

	public boolean isAusgefuehrt() {
		return ausgefuehrt;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	private final double gesamtpreis;

	public Bestellbestaetigung(boolean ausgefuehrt, double gesamtpreis) {
		this.ausgefuehrt = ausgefuehrt;
		this.gesamtpreis = gesamtpreis;
	}

}
