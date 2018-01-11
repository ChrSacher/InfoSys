package InfoSys;

/**
 * Klasse die gebliebene Produkte im Lager enthält.
 * 
 * @author dieu huyen
 *
 */
public class Lagerposten
{
    public Lagerposten(Artikel artikel,int lagerbestand, double preis)
    {
	this.artikel = artikel;
	this.lagerbestand = lagerbestand;
	this.preis = preis;
    }
    private final Artikel artikel;
    
    private int lagerbestand = 0;
    
    private double preis = 0;
    
       public Artikel getArtikel()
       {
           return artikel;
       }
       
    public int getLagerbestand()
    {
        return lagerbestand;
    }
   
    public void setLagerbestand(int lagerbestand)
    {
        this.lagerbestand = lagerbestand;
    }
    
    public double getPreis()
    {
        return preis;
    }
   
    public void setPreis(double preis)
    {
        this.preis = preis;
    }
}
