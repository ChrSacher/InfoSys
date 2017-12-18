package InfoSys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lagerverwaltung {
	private Set<String> berechtigteMitarbeitere = new HashSet<String>();

	public Set<String> getBerechtigteMitarbeiter() {
		return berechtigteMitarbeitere;
	}

	Lagerverwaltung() {

	}

	public void berechtigungErteilen(Mitarbeiter mitarbeter) {

	}

	public void berechtgungZurueckziehen(Mitarbeiter mitarbeiter) {

	}

	public void lagerbestandAusgeben() {

	}

	public void wareneingangBuchen(Mitarbeiter mitarbeiter, Artikel artikel, int num) {

	}

	public Bestellbestaetigung bestellungAusfuehren(Mitarbeiter mitarbeiter, List<Bestellposten> bestellung) {
		return new Bestellbestaetigung(false, 0);
	}
}
