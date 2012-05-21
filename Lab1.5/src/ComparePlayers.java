// **********************************************************
// ComparePlayers
//
// Reads in two Player objects and tells whether they represent
// the same player.
// **********************************************************

public class ComparePlayers
{
    public static void main(String[] args)
    {
	Player player1 = new Player();
	Player player2 = new Player();
	

	//Prompt for and read in information for player 1
	
	System.out.println("Enter in the Name of the player1 followed by the name of their team followed by their jersey number, all seperated by a new line");
	
	player1.readPlayer();
	
	
	//Prompt for and read in information for player 2
	
	System.out.println("Enter in the Name of the player2 followed by the name of their team followed by their jersey number, all seperated by a new line");
	
	player2.readPlayer();

	//Compare player1 to player 2 and print a message saying
	//whether they are equal

	
		if (player1.equals(player2) )
			{ 
			System.out.println("true, Player1 equals Player2");
			
			}
			
		else if  (!(player1.equals(player2)))
			{ ;
			System.out.println("false, Player1 does not equal Player2");
			
			}
    
	
	String p1 = "Player1 : " + player1;
	String p2 = "Player2 : " + player2;
	
	System.out.println(p1);
	System.out.println(p2);
	
	
	
    }
//    Output1 False
//    Enter in the Name of the player1 followed by the name of their team followed by their jersey number, all seperated by a new line
//    Name: Jeff
//    Team: Sharks
//    Jersey number: 10
//    Enter in the Name of the player2 followed by the name of their team followed by their jersey number, all seperated by a new line
//    Name: Jeff
//    Team: Sharks
//    Jersey number: 9
//    false, Player1 does not equal Player2
//    Player1 : Jeff, of the Sharks ,#10
//    Player2 : Jeff, of the Sharks ,#9
    
//    Output2 True
//    Enter in the Name of the player1 followed by the name of their team followed by their jersey number, all seperated by a new line
//    Name: Jeff
//    Team: Sharks
//    Jersey number: 10
//    Enter in the Name of the player2 followed by the name of their team followed by their jersey number, all seperated by a new line
//    Name: Jeff
//    Team: Sharks
//    Jersey number: 10
//    true, Player1 equals Player2
//    Player1 : Jeff, of the Sharks ,#10
//    Player2 : Jeff, of the Sharks ,#10

	

	
}
	    
