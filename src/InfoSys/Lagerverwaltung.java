package InfoSys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Christian Sacher
 *
 */
public class Lagerverwaltung
{
    /**
     * Liste aller Mitarbeiter die berechtigt sind Bestellungen(usw.) auszuführen.
     */
    private HashSet<String> berechtigteMitarbeiter = new HashSet<String>();
    /**
     * Liste aller Artikel die im Lager vorhanden sind.
     */
    private HashMap<String, Lagerposten> lagerListe = new HashMap<String, Lagerposten>();
    /**
     * Datei in welche der Log geschrieben wird
     */
    private final File file;
    /**
     * Printwriter der in die file schreibt
     */
    private final PrintWriter writer;

    public HashSet<String> getBerechtigteMitarbeiter()
    {
	return berechtigteMitarbeiter;
    }

    /**
     * @param berechtigteMitarbeiter Hashset aller neuen Mitarbeiter
     */
    public void setBerechtigteMitarbeiter(HashSet<String> berechtigteMitarbeiter)
    {
	this.berechtigteMitarbeiter = berechtigteMitarbeiter;
    }

    /**
     * 
     */
    public Lagerverwaltung()
    {
	//Date datum = new Date();
	//file = new File("Lagerbestand_" + datum.getTime() +".txt");
	file = new File("Logfile.txt");
	
	//wenn die Datei nicht existiert ,wird eine neue erstellt
	if (!file.exists())
	{

	    try
	    {
		file.createNewFile();
	    } catch (IOException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	PrintWriter testWriter = null;
	try
	{
	    //OutputStream für Append-Modus
	    testWriter = new PrintWriter(new FileOutputStream(
		    file, 
		    true));

	} catch (FileNotFoundException e)
	{

	    
	    e.printStackTrace();
	}
	//wenn die Datei nicht geöffnet werden kann, dann wird der normale System.Out stream benutzt(meist console)
	if (testWriter == null)
	{
	    testWriter = new PrintWriter(System.out);
	}
	writer = testWriter;
    }

    /**
     * @param mitarbeiter Mitarbeiter der Rechte erhalten soll
     */
    public void berechtigungErteilen(Mitarbeiter mitarbeiter)
    {
	berechtigteMitarbeiter.add(mitarbeiter.getId());
	Date datum = new Date();
	
	writer.println("Berechtigung erteilt an "+ mitarbeiter.getId() +  " " + mitarbeiter.getName() + " am "  + datum.toString());
	writer.flush();
    }

    /**
     * @param mitarbeiter Mitarbeiter der Rechte verlieren soll
     */
    public void berechtigungZurueckziehen(Mitarbeiter mitarbeiter)
    {
	berechtigteMitarbeiter.remove(mitarbeiter.getId());
	Date datum = new Date();
	
	writer.println("Berechtigung entzogen von "+ mitarbeiter.getId() +  " " + mitarbeiter.getName() + " am "  + datum.toString());
	writer.flush();
    }

    /**
     * Gibt den Lagerbestand auf der Console aus, im Format Artikelname | Anzahl im Lager | Preis
     */
    public void lagerbestandAusgeben()
    {
	Date datum = new Date();
	
	System.out.println("Lagerbestand vom " + datum.toString() + "\n");
	System.out.println("Artikelname | Anzahl im Lager | Preis \n");
	for (Map.Entry<String, Lagerposten> entry : lagerListe.entrySet())
	{
	    System.out.println(entry.getValue().getArtikel().getName() + " " + entry.getValue().getLagerbestand() + "  " + entry.getValue().getPreis());
	}

    }

    /**
     * @param mitarbeiter Mitarbeiter der die Buchung ausführt
     * @param artikel Artikel welcher im Lager platziert wird
     * @param anzahl Artikel Anzahl
     * @param preis Preis für alle Artikel zusammen
     */
    public void wareneingangBuchen(Mitarbeiter mitarbeiter, Artikel artikel, int anzahl, double preis)
    {
	//wenn der Mitarbeiter keine Rechte hat -> abbrechen
	if (!berechtigteMitarbeiter.contains(mitarbeiter.getId()))
	{
	    writer.println("Mitarbeiter " + mitarbeiter.getId() + " hat nicht die Berechtigung zum buchen von Artikeln.");
	    writer.flush();
	    return;
	}
	  
	//Überprüfen ob der Artikel bereits im Lager vorhanden ist
	Lagerposten artikelLager = lagerListe.get(artikel.getId());
	if (artikelLager == null)
	{
	    //Artikel ist noch nicht im Lager
	    artikelLager = new Lagerposten(artikel, anzahl, preis);
	    lagerListe.put(artikel.getId(), artikelLager);
	} 
	else
	{
	    //Artikel ist im Lager
	    artikelLager.setLagerbestand(artikelLager.getLagerbestand() + anzahl);
	    artikelLager.setPreis(artikelLager.getPreis() + preis);
	}
	
	
	Date datum = new Date();
	writer.println("Wareneingang gebucht von "+ mitarbeiter.getId() +" " + anzahl + "x " + artikel.getId() +  " für "  + preis + " am "  + datum.toString());
	writer.flush();
    }

    /**
     * @param mitarbeiter Mitarbeiter der die Bestellung ausführt
     * @param bestellung Liste aller Artikel die bestellt werden
     * @return
     */
    public Bestellbestaetigung bestellungAusfuehren(Mitarbeiter mitarbeiter, List<Bestellposten> bestellung)
    {
	//wenn der Mitarbeiter keine Rechte hat-> Abbruch
	if (!berechtigteMitarbeiter.contains(mitarbeiter.getId()))
	{
	    writer.println("Mitarbeiter " + mitarbeiter.getId() + " hat nicht die Berechtigung zum bestellen von Artikeln.");
	    writer.flush();
	    return new Bestellbestaetigung(false, 0);
	}
	//Überprüfen ob alle Bestellungen ausführbar sind 
	for (Bestellposten posten : bestellung)
	{
	    //Wenn der Artikel nicht im Lager ist oder weniger als gefordert vorhanden sind , dann wird die Bestellung abgelehnt
	    Lagerposten artikelLager = lagerListe.get(posten.getArtikelID());
	    if (artikelLager == null || artikelLager.getLagerbestand() < posten.getAnzahl())
		return new Bestellbestaetigung(false, 0);

	}
	
	//Ausführen der Bestellung
	float komplettPreis = 0;
	for (Bestellposten posten : bestellung)
	{
	    
	    Lagerposten artikelLager = lagerListe.get(posten.getArtikelID());
	    if (artikelLager.getLagerbestand() == 0)
		continue;
	    
	    //Preis berechnen
	    double preisProArtikel = artikelLager.getPreis() / artikelLager.getLagerbestand();
	    double endPreis = posten.getAnzahl() * preisProArtikel;
	    komplettPreis += endPreis;
	    
	    
	    //Bestand im Lager verändern
	    artikelLager.setPreis(artikelLager.getPreis() - endPreis);
	    artikelLager.setLagerbestand(artikelLager.getLagerbestand() - posten.getAnzahl());
	    
	    //In das Log schreiben
	    Date datum = new Date();
	    writer.println("Bestellung von " + posten.getAnzahl() + "x " + artikelLager.getArtikel().getName() + " am " + datum.toString());
	    writer.flush();
	}
	//Die Artikel konnten bestellt werden und komplettPreis beinhaltet den kompletten Preis
	return new Bestellbestaetigung(true, komplettPreis);
    }

}
