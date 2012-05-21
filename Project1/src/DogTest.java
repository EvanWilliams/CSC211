//package lab4; //Added to placate JBuilder and other IDEs
// ****************************************************************
// DogTest.java
//
// A simple test class that creates a Dog and makes it speak.
//          
// ****************************************************************

public class DogTest
{
    public static void main(String[] args)
    
    {
    	//Dog dog = new Dog("Spike");
    	//System.out.println(dog.getName() + " says " + dog.speak());
    	Labrador lab = new Labrador("Sam","Black");
    	Yorkshire york = new Yorkshire("Fluffy");
    	//poke(dog);
    	poke(york);
    	poke(lab);

    }
    
	public static void poke(Dog d) {
	    System.out.println(""+d+" says "+d.speak());
	    System.out.println("and its average weight is "+d.avgBreedWeight());
	  }
	
//  Program Output shown below
//  Fluffy says woof
//	and its average weight is 45
//	Sam says WOOF
//	and its average weight is 75

}
