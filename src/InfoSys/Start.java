package InfoSys;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	    Mitarbeiter peter = new Mitarbeiter("peter","Peter");
	    Lagerverwaltung verwaltung = new Lagerverwaltung();
	    Artikel cola = new Artikel("cola", "Coca Cola", "Leckere Coca Cola");
	    Artikel fanta = new Artikel("fanta","Fanta", "Leckere Fanta");
	    //test der Rechte und des Lagers
	    verwaltung.wareneingangBuchen(peter, cola, 20, 36.50);
	    
	    verwaltung.berechtigungErteilen(peter);
	    verwaltung.wareneingangBuchen(peter, cola, 20, 36.50);
	    verwaltung.wareneingangBuchen(peter, fanta, 10, 16.50);
	    verwaltung.wareneingangBuchen(peter, fanta, 10, 16.50);
	    verwaltung.berechtigungZurueckziehen(peter);
	    verwaltung.wareneingangBuchen(peter, fanta, 10, 16.50);
	    
	    verwaltung.lagerbestandAusgeben();
	    
	    verwaltung.berechtigungErteilen(peter);
	    ArrayList<Bestellposten> liste =  new ArrayList<Bestellposten>();
	    liste.add(new Bestellposten("cola", 20));
	    liste.add(new Bestellposten("fanta", 20));
	    
	    Bestellbestaetigung best = verwaltung.bestellungAusfuehren(peter, liste);
	    System.out.println("Ausgefuehrt: " + best.isAusgefuehrt() + " Preis: " + best.getGesamtPreis());
	}

}
