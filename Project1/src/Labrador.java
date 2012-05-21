//package lab4; //Added to placate JBuilder and other IDEs
// ****************************************************************
// Labrador.java
//
// A class derived from Dog that holds information about
// a labrador retriever.  Overrides Dog speak method and includes
// information about avg weight for this breed.
//          
// ****************************************************************


/**
 * @author Evan
 * Extends Dog
 *
 */
public class Labrador extends Dog
{
    private String color; //black, yellow, or chocolate?
    private int breedWeight = 75;

    /**
     * @param name - Dog's Name
     * @param color - String with Dog's color
     */
    public Labrador(String name,  String color)
    {
    	
    	super(name);
    	this.color = color;
    }

    // ------------------------------------------------------------
    // Big bark -- overrides speak method in Dog
    // ------------------------------------------------------------
    public String speak()
    {
    	return "WOOF";
    }


    // ------------------------------------------------------------
    // Returns weight
    // ------------------------------------------------------------
    public int avgBreedWeight()
    {
	return breedWeight;
    }


}
