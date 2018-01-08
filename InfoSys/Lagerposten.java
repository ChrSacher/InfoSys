package InfoSys;

/**
 * Klasse die gebliebene Produkte im Lager enthält.
 * 
 * @author dieu huyen
 *
 */
public class Lagerposten {
	private Artikel artikel;

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public int getLagerbesstand() {
		return lagerbesstand;
	}

	public void setLagerbesstand(int lagerbesstand) {
		this.lagerbesstand = lagerbesstand;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	private int lagerbesstand;
	private double preis;

	public Lagerposten(Artikel Artikel, int lagerbesstand, double preis) {
		this.artikel = Artikel;
		this.lagerbesstand = lagerbesstand;
		this.preis = preis;

	}

}
