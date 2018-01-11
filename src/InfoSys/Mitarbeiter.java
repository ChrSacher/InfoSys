package InfoSys;


/**
 * Klasse, welche einen Mitarbeiter beschreibt.
 * 
 * @author dieu huyen
 *
 */
public class Mitarbeiter 
{
    public Mitarbeiter(String id, String name)
    {
	
	this.id = id;
	this.name = name;
    }

    private final String id;
    
    private String name = "ERROR";

  
    public String getName()
    {
        return name;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }

   
    public String getId()
    {
        return id;
    }
}
