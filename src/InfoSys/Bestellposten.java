package InfoSys;

/**
 * Klasse welche eine bestimmten Menge des Produktes jeder Bestellung enthält.
 * 
 * @author dieu huyen
 *
 */
public class Bestellposten 
{
    public Bestellposten(String artikelID, int anzahl)
    {
	
	this.artikelID = artikelID;
	this.anzahl = anzahl;
    }

    private final String artikelID;
    
    private final int anzahl;
   
    public String getArtikelID()
    {
        return artikelID;
    }
  
    public int getAnzahl()
    {
        return anzahl;
    }
    
    
}
