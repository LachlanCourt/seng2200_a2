import java.util.Iterator;

import java.util.*;
//Allows opening of files for reading
import java.io.*;

public class PA2
{
    // Instance variables
    private LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();
    private LinkedList<PlanarShape> sortedList = new LinkedList<PlanarShape>();
    private static String filename;

    // Main function
    public static void main(String args[])
    {
        // Try to load the file with the specified name and jump out into the run function if successful
        try
        {
            filename = args[0];
            PA2 assignment = new PA2();
            assignment.run();
        }
        // If there is an error loading the file, notify the user and run to the end of the main function
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("No file specified at program load. Terminating...");
        }

    }

    /**
     * Primary execution
     */
    public void run()
    {

        // Declare a string to hold the content of the text file specified
        String inputText = readFromTextFile();
        // readFromTextFile will return null if there was an error opening the specified text file. Notify user and return
        if (inputText == null)
        {
            System.out.println("Error loading text file. Check file name and try again. Terminating...");
            return;
        }

        // Notify user of successful load
        System.out.println("Text file loaded successfully. Generating Polygons...");
//        // While inputText is not empty, create polygons from the data
//        while (inputText.compareTo("") != 0)
//        {
//            inputText = createPolygon(inputText);
//        }
//
//        // Output the unsorted list
//        System.out.println("Unsorted list:");
//        System.out.println(myPolygonsList.toString());
//
//        // Loop through the unsorted list and add each item in order to the sorted list
//        int listSize = myPolygonsList.getSize();
//        /*
//         Loop through every item in the list. Because it's being inserted in order it doesn't matter where the current
//         pointer is, as long as the whole list is iterated over
//         */
//        for (int i = 0; i < listSize; i++)
//        {
//            // Get the next polygon in the list and add into sortedPolygons in order
//            Polygon temp = myPolygonsList.next();
//            sortedPolygons.insertInOrder(temp);
//        }
//
//        // Output the sorted list
//        System.out.println("Sorted List:");
//        System.out.println(sortedPolygons.toString());

        // End the program
        System.out.println("Program complete!");
    }

    /**
     * Takes a string of points from a text file and reads through until exactly one polygon has been read from it
     *
     * @param text as a string of points read from a text file
     * @return the remaining string after a polygon has been read from it and the relevant data removed from it
     * Precondition: text must be properly formatted with at least one polygon and at least one space between each character
     * Postcondition one polygon will be added to myPolygonList and the remaining text will be returned
     */
    private String createPolygon(String text)
    {
//        // Declare a string to hold a single polygon worth of data read from a text file
//        String polygonString = "";
//        // While the string does not start with a p, loop
//        do
//        {
//            // If text is not empty, add the first character to polygonString and remove it from text
//            if (text.length() != 0)
//            {
//                polygonString += text.charAt(0);
//                text = text.substring(1);
//            }
//            // If text is empty, break out of the loop
//            else
//            {
//                break;
//            }
//        }
//        while (!text.toLowerCase().startsWith("p"));
//        // Create a new polygon with the data in polygonString and add it to the end of myPolygonsList
//        myPolygonsList.append(new Polygon(polygonString));
//        // Return the remaining string
        return text;
    }

    /**
     * Reads a text file and converts it into a string
     *
     * @return a string read from the data in a text file with all lines combined into a single string
     * Precondition: filename has been declared
     * Postcondition: A string is created and returned which consists of the text file data in one string
     */
    private String readFromTextFile()
    {
        //Declare a Scanner to read the text file
        Scanner inputStream;
        try
        {
            //Try opening the Scanner with the filename selected
            inputStream = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e)
        {
            //If there is an error opening the Scanner, return null which will indicate an error
            return null;
        }

        //Each line of text will be stored here as it is read so that it can be interpretted in run
        String textLine = "";

        //Loop while there is still information to read from the text file
        while (inputStream.hasNext())
        {
            //Read the text file line by line
            textLine += inputStream.nextLine();
        }
        //After the text file has been read, close the Scanner and return the string
        inputStream.close();

        return textLine;
    }
}
