
//--------------------------------------------------------------------
//
//Laboratory 7, In-lab Exercise 3                   SlideShow.jshl
//
//(Shell) Slide show program
//
//The student is to complete all missing or incomplete method 
// implementations for each class
//
//--------------------------------------------------------------------

//Displays a slide show.

import java.io.*;


class Slide
{
// constants
static final int SLIDE_HEIGHT = 10;   // Slide dimensions
static final int SLIDE_WIDTH  = 36;

// Data members
private String [] image =            // Slide image
        new String [SLIDE_HEIGHT];
private long pause;                  // Seconds to pause after
                                     //  displaying slide

public boolean read ( BufferedReader bufFinReader ) 
    // Read a slide from inFile. Returns false at EOF.
{
	return false;

}

public void display ( )                   
    // Display a slide and pause or sleep.
{

}
} // class Slide

class SlideShow
{
static final int NUM_LINES = 50;    // Number of lines on the screen

public static void main ( String[ ] args ) throws IOException, 
                                                  InterruptedException 
{
    SList slideShow = new SList( );     // Slide show
    Slide currSlide;                    // Slide
    String filename;                    // Name of slide show file
    FileInputStream slideFile = null;   // The slide input file
    boolean succeeded = false;          // Succeeded in opening file

    //-----------------------------------------------------------------
    // Initialize reader - To read filename from keyboard
    BufferedReader reader = 
                   new BufferedReader(new InputStreamReader(System.in));

    // Open the specified slide file.
    while ( !succeeded )
    {
        System.out.print("\nEnter the name of the slide show file : ");
        filename = reader.readLine( );
        try
        {
            slideFile = new FileInputStream(filename);
            succeeded = true;           // Assume file is found
        }
        catch (FileNotFoundException e)
        {
            System.out.print("File Not Found: " + filename);
            succeeded = false;          // File was not found
        }
    }

    // Buffer the file input stream
    BufferedReader bufSlideReader = 
                 new BufferedReader(new InputStreamReader(slideFile));

    // Read in the slides one-by-one & insert in list.







    // Close the file.

    
    // Display the slide show slide-by-slide.











} // main

} // class SlideShow
