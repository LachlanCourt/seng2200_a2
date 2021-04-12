import java.awt.*;
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
        System.out.println("Text file loaded successfully. Generating Planar Shapes...");
        // While inputText is not empty, create polygons from the data
        while (inputText.compareTo("") != 0)
        {
            inputText = createPolygon(inputText);
        }

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
     * @param inData as a string of points read from a text file
     * @return the remaining string after a polygon has been read from it and the relevant data removed from it
     * Precondition: text must be properly formatted with at least one polygon and at least one space between each character
     * Postcondition one polygon will be added to myPolygonList and the remaining text will be returned
     */
    private String createPolygon(String inData)
    {
        // Declare a string to hold a single polygon worth of data read from a text file
        String shapeString = "";
        // While the string does not start with a p, loop
        do
        {
            // If text is not empty, add the first character to polygonString and remove it from text
            if (inData.length() != 0)
            {
                shapeString += inData.charAt(0);
                inData = inData.substring(1);
            }
            // If text is empty, break out of the loop
            else
            {
                break;
            }
        }
        while ((!(inData.toLowerCase().startsWith("p"))) || (!(inData.toLowerCase().startsWith("c"))) || (!(inData.toLowerCase().startsWith("s"))));
        // Create a new polygon with the data in polygonString and add it to the end of myPolygonsList
        double[] values = interpretString(shapeString);
        ShapeFactory sf = new ShapeFactory();
        switch (shapeString)
        {
            case "P":
            {
                unsortedList.append(sf.createShape("POLYGON", values));
                break;
            }
            case "C":
            {
                unsortedList.append(sf.createShape("CIRCLE", values));
                break;
            }
            case "S":
            {
                unsortedList.append(sf.createShape("SEMICIRCLE", values));
                break;
            }
        }

        // Return the remaining string
        return inData;
    }

    private double[] interpretString(String params)
    {
        params += " ";
        String shapeType = params.substring(0, 1);
        double[] values = new double[5];
        int valuesSize = 0;
        // Remove initial character and the following space
        params = params.substring(1);
        if (params.charAt(0) == ' ')
        {
            params = params.substring(1);
        }
        // Get number of points as the next item in the String
        String temp = "";
        /*
         Loop through the length of the String to read the number of Points. By setting the for loop to the entire
         length it accounts for a number of points with any number of digits.
         */
        // Add extra space to ensure the last point is included


        // Temporary variables to hold x, y coordinates before they are added as a Point
        double a = 0;
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
                // Convert temp to a double and reset it ready to read a y coordinate
                values[valuesSize] = Double.valueOf(temp);
                valuesSize++;
                if (valuesSize == values.length)
                {
                    values = resizeArray(values);
                }
                temp = "";

                // If params is empty, there's no more numbers to read and no more Points to add
                if (params.length() == 0)
                {
                    break;
                }
            }
            else
            {
                // If execution is not reading a space, it must be part of a number. Add it to temp and remove from the String
                temp += params.charAt(0);
                params = params.substring(1);
            }
        }
        return values;
    }

    double[] resizeArray(double[] oldArray)
    {
        double[] newArray = new double[oldArray.length + 10];
        for (int i = 0; i < oldArray.length; i++)
        {
            newArray[i] = oldArray[i];
        }
        return newArray;
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
