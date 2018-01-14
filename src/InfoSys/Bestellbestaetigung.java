package InfoSys;

/**
 * Klasse welche den Eingang der Bestellung bestätigt.
 * 
 * @author dieu huyen
 *
 */
public class Bestellbestaetigung 
{
    private final boolean ausgefuehrt;
    
    private final double gesamtPreis;
    
    public Bestellbestaetigung(boolean ausgefuehrt, double gesamtPreis)
    {
	this.ausgefuehrt = ausgefuehrt;
	this.gesamtPreis = gesamtPreis;
    }
    
    
    public boolean isAusgefuehrt()
    {
        return ausgefuehrt;
    }
    
   
    public double getGesamtPreis()
    {
        return gesamtPreis;
    }
}
