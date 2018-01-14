package InfoSys;

/**
 * Klasse, die alle Produkt beschreibt.
 * 
 * @author dieu huyen
 *
 */
public class Artikel 
{
	public Artikel(String newId, String newName, String newBeschreibung)
        {
	    id = newId;
	    setData(newName,newBeschreibung);
        }
	/*
	 * Variable, die den Artikel identifiezirt
	 */
	private final String id;
	
	/*
	 * Name des Artikels
	 */
	private String name = "ERROR";
	
	/*
	 * Beschreibung des Artikels
	 */
	private String beschreibung = "ERROR";
	
	
	public String getId()
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getBeschreibung() 
	{
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) 
	{
		this.beschreibung = beschreibung;
	}
	
	void setData(String newName, String newBeschreibung)
	{
	    
	    setName(newName);
	    setBeschreibung(newBeschreibung);
	}
	
	
}
