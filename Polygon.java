/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class stores the information of a Polygon including an array of
 ****    Points and it's area
 *******************************************************************************/

// An implementation of the ComparePoly function that includes functionality for non-standard Polygons
public class Polygon implements ComparePoly
{
    // Instance variables
    private Point[] points;
    private int pointsSize;

    private double area;
    private double leastDistance;

    // Default Constructor
    public Polygon()
    {
    }

    // Constructor
    public Polygon(String params)
    {
        // Build the array of Points that represent the polygon
        interpretString(params);
        // Calculate the area of the polygon
        calcArea();
        // Calculate the distance from the <point closest to the origin> to the origin
        calcLeastDistance();
    }

    /**
     * Takes a string representation of a Polygon read from a text file and generates the appropriate array of Points
     * @param params as a String of double values that indicate alternating X, Y coordinates of a Polygon
     * Precondition: params must be a properly formatted string "P z x y x y" where z is the number of points and x
     *               and y are x y coordinates of points
     * Postcondition: An array of Point objects will be completed from a representative String
     *
     */
    private void interpretString(String params)
    {
        // Remove P and the following space
        params = params.substring(1);
        if (params.charAt(0) == ' ')
        {
            params = params.substring(1);
        }
        // Get number of points as the next item in the String
        String temp = "";
        int paramsLength = params.length();
        /*
         Loop through the length of the String to read the number of Points. By setting the for loop to the entire
         length it accounts for a number of points with any number of digits.
         */
        for (int i = 0; i < paramsLength; i++)
        {
            // If the first item in the string is not a space, add it to temp and remove it from the head of the String
            if (params.charAt(0) != ' ')
            {
                temp += params.charAt(0);
                params = params.substring(1);
            }
        }
        // Convert temp to an integer to indicate the number of points in the upcoming Polygon
        int numberPoints = Integer.valueOf(temp);
        // Create an extra item in the array at the end to store a duplicate of the first point for area calculation
        points = new Point[numberPoints + 1];
        // Logical size
        pointsSize = 0;
        // Remove leading space and then calculate the points
        params = params.substring(1);
        // Add extra space to ensure the last point is included
        params += " ";

        // Temporary variables to hold x, y coordinates before they are added as a Point
        double a = 0;
        double b = 0;
        temp = "";
        // Only create a Point every second number read, one for the x coordinate and one for the y
        boolean createPoint = false;
        Point newPoint;

        // Loop through the remaining length of the String
        paramsLength = params.length();
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

                // If an x coordinate has been read
                if (createPoint)
                {
                    // Convert temp to a double and create a new Point with x, y coordinates matching a, b
                    b = Double.valueOf(temp);
                    newPoint = new Point(a, b);
                    // Add the new Point to the array and increase the logical size
                    points[pointsSize] = newPoint;
                    pointsSize++;
                    // Reset a, b and temp for a new Point
                    a = 0;
                    b = 0;
                    temp = "";
                    createPoint = false;
                }
                // If an x coordinate has not been read yet
                else
                {
                    // Convert temp to a double and reset it ready to read a y coordinate
                    a = Double.valueOf(temp);
                    temp = "";
                    createPoint = true;
                }
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

        /*
         Add last point into the array as a duplicate of the first item for the purposes of area calculation. Don't
         increase the logical size as this will be a hidden value that will not be printed out
         */
        newPoint = new Point(points[0].getX(), points[0].getY());
        points[pointsSize] = newPoint;
    }

    /**
     * Calculates the area of the polygon
     * Precondition: Points array should not be empty (Otherwise area will be 0)
     * Postcondition: area variable indicates the area of the Polygon represented by the points in the points array
     */
    private void calcArea()
    {
        // Initialise area variable as 0
        area = 0;
        // Loop through each Point and apply the formula to increase the area variable
        for (int i = 0; i < pointsSize; i++)
        {
            area += (points[i].getX() + points[i + 1].getX()) * (points[i + 1].getY() - points[i].getY());
        }
        // Convert to absolute value
        if (area < 0)
        {
            area *= -1;
        }
        // Complete the formula. area is a global variable so no need to return
        area /= 2;
    }

    /**
     * Calculates the distance from the origin of the point closest to the origin
     * Precondition: points array must have been initialised and cannot be empty
     * Postcondition: leastDistance variable will hold the value of the Euclidian distance from the
     *                <Point closest to the origin> to the origin
     */
    private void calcLeastDistance()
    {
        // Assume the point closest to the origin is the first one in the points array
        leastDistance = points[0].calcDistance();
        // Loop through the array to find the point closest to the origin
        for (int i = 0; i < pointsSize; i++)
        {
            // If a lower distance is found, replace the value stored in leastDistance
            if (points[i].calcDistance() < leastDistance)
            {
                leastDistance = points[i].calcDistance();
            }
        }
    }

    /**
     * Outputs the Polygon as a string
     * @return a String representation of the Points in the polygon followed by the area
     * Precondition: points should not (but can) be empty. Area should have been calculated otherwise it will be 0
     * Postcondition: A String representation of the Polygon will be returned
     */
    @Override
    public String toString()
    {
        // Initialise the output String
        String stringPoly = "[";

        /*
         The last point in the array is the same as the first point, so loop to less than pointsSize so that it is not
         printed it out
         */
        for (int i = 0; i < pointsSize; i++)
        {
            // Add each Point to the String
            stringPoly += " " + points[i].toString();
        }

        // Close the bracket to indicate the list of Points is complete
        stringPoly += " ]:    ";

        // Add the area of the Polygon to the end and return
        stringPoly += String.format("%5.2f", area);

        return stringPoly;
    }

    /**
     * Returns the distance from the origin of the point closest to the origin
     * @return the distance from the <Point closest to the origin> to the origin
     */
    public double getLeastDistance()
    {
        return leastDistance;
    }

    /**
     * Returns the area of the Polygon
     * @return the area of the Polygon
     */
    public double getArea()
    {
        return area;
    }

    /**
     * Determines if the object passed as a parameter comes before this object
     * @param o takes an object to be compared against this
     * @return true if this comes before the param, and false if it comes after
     * Precondition: this Polygon object and params o should be properly initialised with points, area and leastDistance
     * Postcondition: a true or false value will be returned depending on whether this comes before o
     */
    public boolean comesBefore(Object o)
    {
        // Typecast object to Polygon
        Polygon other = (Polygon) o;
        // Temporary variables for calculations
        double differenceMargin;
        double areaTest;
        // Determine the smaller polygon and calculate 0.05% of this area
        double margin = 0.0005;
        if (area - other.getArea() < 0)
        {
            differenceMargin = margin * area;
        }
        else
        {
            differenceMargin = margin * other.getArea();
        }
        // Calculate the difference in area between both polygons
        areaTest = area - other.getArea();
        // Take the absolute value
        if (areaTest < 0)
        {
            areaTest *= -1;
        }
        // If the difference in area is smaller than the calculated margin, use leastDistance to determine the order
        if (areaTest < differenceMargin)
        {
            if (leastDistance < other.getLeastDistance())
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        // If the difference in area is greater than the calculated margin, use the difference in area to determine order
        if (area < other.getArea())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
