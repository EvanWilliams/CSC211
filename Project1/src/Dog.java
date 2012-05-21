//package lab4; //Added to placate JBuilder and other IDEs
// ****************************************************************
// Dog.java
// A class that holds a dog's name and can make it speak.
// Evan Williams 
// E00887504
// COSC 211
// Project1
// ****************************************************************
public abstract class Dog
{
    protected String name;  // test
    protected int weight;  

    // ------------------------------------------------------------
    // Constructor -- store name
    // ------------------------------------------------------------
    public Dog(String n)
    {
    	name = n;
    }

    
    public abstract int avgBreedWeight();
    
    
    // ------------------------------------------------------------
    // Returns the dog's name
    // ------------------------------------------------------------
    public String getName()
    {
	return name;
    }

    // ------------------------------------------------------------
    // Returns a string with the dog's comments
    // ------------------------------------------------------------
    public String speak()
    {
	return "Woof";
    }

    public String toString()  {
    	return getName();
    	
    }


}
