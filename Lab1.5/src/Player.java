// **********************************************************
// Player.java
//
// Defines a Player class that holds information about an athlete.
// **********************************************************

import java.util.Scanner;

public class Player
{
    private String name;
    private String team;
    private int jerseyNumber;

    //-----------------------------------------------------------
    // Prompts for and reads in the player's name, team, and 
    // jersey number.
    //-----------------------------------------------------------
    public void readPlayer()
    {
    Scanner scan = new Scanner(System.in);	
	System.out.print("Name: ");
	name = scan.nextLine();
	System.out.print("Team: ");
	team = scan.nextLine();
	System.out.print("Jersey number: ");
	jerseyNumber = scan.nextInt();
    }
    
    //Overridden equals method comparing player1 to player2
    
    public boolean equals(Player player2 )
    {
    	if (player2 == null)
    		return false;
    	else if (!(player2 instanceof Player))
    		return false;
    	else
    	{
    		return (name.equals(player2.name)
    				&& jerseyNumber==player2.jerseyNumber 
    				&& team.equals(player2.team));	
    	}
    }
    	public String toString()
    	{
    		return (name+ ", " + "of the "+team+ " ,"+"#" +jerseyNumber);
    	}

    	
    	{
    }
    	
    	}
    	
    
    

