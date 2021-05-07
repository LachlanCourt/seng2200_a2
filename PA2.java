/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    04/05/2021
 ****    This class contains the main program execution
 *******************************************************************************/

import java.util.*;
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
            System.out.println("No valid file specified at program load. Terminating...");
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
        System.out.println("Text file loaded successfully. Generating Planar Shapes...");
        // While inputText is not empty, create PlanarShapes from the data where they will be added to unsortedList
        while (inputText.compareTo("") != 0)
        {
            inputText = createPlanarShape(inputText);
        }

        // Output unsortedList
        System.out.println("Unsorted List:");
        System.out.println(unsortedList);

        // Create an iterator for unsortedList
        Iterator<PlanarShape> itr = unsortedList.iterator();
        // Iterate through unsortedList
        while (itr.hasNext())
        {
            // Add the value of the next item in the list to sortedList in order
            sortedList.insertInOrder(itr.next());
        }

        // Output sortedList
        System.out.println("Sorted List:");
        System.out.println(sortedList);

        // End the program
        System.out.println("Program complete!");
    }

    /**
     * Takes a string of points from a text file and reads through until exactly one PlanarShape has been read from it
     *
     * @param inData as a string of points read from a text file
     * @return the remaining string after a PlanarShape has been read from it and the relevant data removed from it
     * Precondition: text must be properly formatted with at least one PlanarShape and at least one space between each character
     * Postcondition one PlanarShape will be added to unsortedList and the remaining text will be returned
     */
    private String createPlanarShape(String inData)
    {
        // Declare a string to hold a single PlanarShape worth of data read from a text file
        String shapeString = "";
        // While the string does not start with a p, c, or s, loop
        do
        {
            // If text is not empty, add the first character to shapeString and remove it from inData
            if (inData.length() != 0)
            {
                shapeString += inData.charAt(0);
                inData = inData.substring(1);
            }
            // If text is empty, break out of the loop - the execution has read the last shape in the string
            else
            {
                break;
            }
        }
        while ((!(inData.toLowerCase().startsWith("p"))) && (!(inData.toLowerCase().startsWith("c"))) && (!(inData.toLowerCase().startsWith("s"))));
        // Create an array of values that interpreted from shapeString
        double[] values = interpretString(shapeString);

        PlanarShape shape = null;
        // Check the first character in shapeString to determine the type of shape to create
        switch (shapeString.substring(0, 1).toLowerCase())
        {
            case "p": // Polygon
            {
                // Create a Polygon using the ShapeFactory and initialise its values
                shape = ShapeFactory.createShape("POLYGON");
                break;
            }

            case "c": // Circle
            {
                // Create a Circle using the ShapeFactory
                shape = ShapeFactory.createShape("CIRCLE");
                break;
            }
            case "s": // Semicircle
            {
                // Create a SemiCircle using the ShapeFactory
                shape = ShapeFactory.createShape("SEMICIRCLE");
                break;
            }
        }
        if (shape != null)
        {
            // Initialise the points of the PlanarShape
            shape.initialise(values);
            // Add the Polygon to the list
            unsortedList.append(shape);
        }
        // Return the remaining string
        return inData;
    }

    /**
     * Takes a string and separates out doubles delimited by spaces, placing them in an array
     *
     * @param params a string of doubles delimited by spaces
     * @return an array of doubles indicated by params
     * Precondition: None
     * Postcondition: return value
     */
    private double[] interpretString(String params)
    {
        // Add a space at the end to ensure the last character is read
        params += " ";
        // Remove leading spaces
        while (params.charAt(0) == ' ')
        {
            params = params.substring(1);
        }
        // Declare a new array and initialise an arbitrary 10 to start with
        double[] values = new double[10];
        // Logical size
        int valuesSize = 0;
        // Remove initial character and the following spaces
        params = params.substring(1);
        while (params.charAt(0) == ' ')
        {
            params = params.substring(1);
        }
        // Declare a temp variable to hold the double as it is being read
        String temp = "";
        // Loop through the remaining length of the String
        int paramsLength = params.length();
        for (int i = 0; i < paramsLength; i++)
        {
            // If execution has reached a space, a number has been read
            if (params.charAt(0) == ' ')
            {
                // Remove any excess duplicate spaces
                while ((params.length() != 0) && (params.charAt(0) == ' '))
                {
                    params = params.substring(1);
                }
                // Convert temp to a double and add to values array
                values[valuesSize] = Double.valueOf(temp);
                valuesSize++;
                // If the values array is full, resize it by 10 more
                if (valuesSize == values.length)
                {
                    values = resizeArray(values, values.length, values.length + 10);
                }
                // Reset temp to read a new value
                temp = "";

                // If params is empty, there's no more numbers to read and no more doubles to add
                if (params.length() == 0)
                {
                    break;
                }
            }
            else
            {
                // If execution is not reading a space, it must be part of a double. Add it to temp and remove from the String
                temp += params.charAt(0);
                params = params.substring(1);
            }
        }
        // Resize the array so that the physical size matches the logical size. Necessary for later calculations
        return resizeArray(values, valuesSize, valuesSize);
    }

    /**
     * Takes an array and resizes it according to the specified parameters
     * @param oldArray the array to be resized
     * @param oldSize the size of the old array
     * @param newLength the desired physical size of the new array
     * @return the new array
     * Precondition: None
     * Postcondition: return value
     */
    double[] resizeArray(double[] oldArray, int oldSize, int newLength)
    {
        // Declare a new array according to the specified length
        double[] newArray = new double[newLength];
        // Loop through the length of the old array and populate the new array
        for (int i = 0; i < oldSize; i++)
        {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    /**
     * Reads a text file and converts it into a string
     * @return a string read from the data in a text file with all lines combined into a single string
     * Precondition: filename has been declared
     * Postcondition: return value
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

        //Each line of text will be stored here as it is read so that it can be interpreted in run
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
