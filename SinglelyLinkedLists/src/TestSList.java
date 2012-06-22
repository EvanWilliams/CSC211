//--------------------------------------------------------------------
//
//  Laboratory 7                                       TestSList.java
//
//  Test program for the operations in the List ADT
//
//--------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;

class TestSList
{
    public static void main( String [] args ) throws IOException 
    {
        SList testList = new SList( );   // A singly linked list
        char testElement = 'c';          // List element
        char cmd = 'q';                  // Input command

        String aToken;                   // A single token in line read
        
        //-----------------------------------------------------------------
        // Initialize reader - To read a character or line at a time
        BufferedReader reader = 
                               new BufferedReader(new InputStreamReader(System.in));
        // Tokenize the String read
        StringTokenizer strTokens;          // Tokenizer for a string
        
        System.out.println("\nCommands:");
        System.out.println("  +x  : Insert x after the cursor");
        System.out.println("  -   : Remove the element marked by the cursor");
        System.out.println("  =x  : Replace the element marked by the cursor with x");
        System.out.println("  @   : Display the element marked by the cursor");
        System.out.println("  <   : Go to the beginning of the list");
        System.out.println("  >   : Go to the end of the list");
        System.out.println("  N   : Go to the next element");
        System.out.println("  P   : Go to the prior element");
        System.out.println("  C   : Clear the list");
        System.out.println("  E   : Empty list?");
        System.out.println("  M   : Move element marked by cursor to beginning  "
                           + "(Inactive : In-lab Ex. 1)");
        System.out.println("  #x  : Insert x before the cursor                  "
                           + "(Inactive : In-lab Ex. 2)");
        System.out.println("  Q   : Quit the test program");
        System.out.println( );

        testList.showStructure( );                      // Output list
        
        do
        {

            System.out.print("\nCommand: ");            // Read command

            // read entire line
            strTokens = new StringTokenizer(reader.readLine( ));
            
            while ( strTokens.hasMoreTokens( ) )
            {
                aToken = strTokens.nextToken( );
                cmd = aToken.charAt(0);

                if ( cmd == '+'  ||  cmd == '='  ||  cmd == '#' )
                {
                    // check if user entered space after command
                    if ( aToken.length( ) > 1 )
                        aToken = aToken.substring(1);
                    else
                        aToken = strTokens.nextToken( );

                    testElement = aToken.charAt(0);
                }

                switch ( cmd )
                {
                case '+' :                                  // insert
                    System.out.println("Insert " + testElement);
                    testList.insert(new Character(testElement));
                    break;

                case '-' :                                  // remove
                    System.out.println("Remove the element marked by the cursor");
                    testList.remove( );
                    break;

                case '=' :                                  // replace
                    System.out.println("Replace the element marked by the cursor "
                                       + "with " + testElement);
                    testList.replace(new Character(testElement));
                    break;

                case '@' :                                  // getCursor
                    System.out.println("Element marked by the cursor is "
                                       + testList.getCursor( ));
                    break;

                case '<' :                                  // gotoBeginning
                    if ( testList.gotoBeginning( ) )
                        System.out.println("Go to the beginning of the list");
                    else
                        System.out.println("Failed -- list is empty");
                    break;

                case '>' :                                  // gotoEnd
                    if ( testList.gotoEnd( ) )
                        System.out.println("Go to the end of the list");
                    else
                        System.out.println("Failed -- list is empty");
                    break;

                case 'N' : case 'n' :                       // gotoNext
                    if ( testList.gotoNext( ) )
                        System.out.println("Go to the next element");
                    else
                        System.out.println("Failed -- either at the end of the list "
                                           + "or the list is empty");
                    break;

                case 'P' : case 'p' :                       // gotoPrior
                    if ( testList.gotoPrior( ) )
                        System.out.println("Go to the prior element");
                    else
                        System.out.println("Failed -- either at the beginning of the "
                                           + "list or the list is empty");
                    break;

                case 'C' : case 'c' :                       // clear
                    System.out.println("Clear the list");
                    testList.clear( );
                    break;

                case 'E' : case 'e' :                       // empty
                    if ( testList.isEmpty( ) )
                        System.out.println("List is empty");
                    else
                        System.out.println("List is NOT empty");
                    break;

                case 'F' : case 'f' :                       // full
                    if ( testList.isFull( ) )
                        System.out.println("List is full");
                    else
                        System.out.println("List is NOT full");
                    break;
//M
//M         case 'M' : case 'm' :                   // In-lab Exercise 1
//M             System.out.println("Move the element marked by the cursor to the "
//M                                + "beginning of the list");
//M             testList.moveToBeginning( );
//M             break;

//#            
//#         case '#' :                              // In-lab Exercise 2
//#             System.out.println("Insert " + testElement 
//#                                + " before the " + "cursor");
//#             testList.insertBefore(new Character(testElement));
//#             break;

                case 'Q' : case 'q' :                   // Quit test program
                    break;

                default :                               // Invalid command
                    System.out.println("Inactive or invalid command");
                }

                testList.showStructure( );                     // Output list
                System.out.println( );
                
            } // while ( moreTokens )
        }
            while ( cmd != 'Q'  &&  cmd != 'q' );
    } // main
    
} // class TestSList