/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class stores the information of a Polygon including an array of
 ****    Points and it's area
 *******************************************************************************/

// An implementation of the ComparePoly function that includes functionality for non-standard Polygons
public class Polygon extends PlanarShape
{
    // Instance variables
    private Point[] points;
    private int pointsSize;

    // Default Constructor
    public Polygon(int size_)
    {
        points = new Point[size_ + 1];
    }

    public void addPoint(Point newPoint, boolean lastPoint)
    {
        points[pointsSize] = newPoint;
        if (!lastPoint)
        {
            pointsSize++;
        }
    }

    /**
     * Calculates the area of the polygon
     * Precondition: Points array should not be empty (Otherwise area will be 0)
     * Postcondition: area variable indicates the area of the Polygon represented by the points in the points array
     */
    public double area()
    {
        // Initialise area variable as 0
        double area = 0;
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
        return area / 2;
    }

    /**
     * Calculates the distance from the origin of the point closest to the origin
     * Precondition: points array must have been initialised and cannot be empty
     * Postcondition: leastDistance variable will hold the value of the Euclidian distance from the
     * <Point closest to the origin> to the origin
     */
    public double originDistance()
    {
        // Assume the point closest to the origin is the first one in the points array
        double leastDistance = points[0].calcDistance();
        // Loop through the array to find the point closest to the origin
        for (int i = 0; i < pointsSize; i++)
        {
            // If a lower distance is found, replace the value stored in leastDistance
            if (points[i].calcDistance() < leastDistance)
            {
                leastDistance = points[i].calcDistance();
            }
        }
        return leastDistance;
    }

    /**
     * Outputs the Polygon as a string
     *
     * @return a String representation of the Points in the polygon followed by the area
     * Precondition: points should not (but can) be empty. Area should have been calculated otherwise it will be 0
     * Postcondition: A String representation of the Polygon will be returned
     */
    @Override
    public String toString()
    {
        // Initialise the output String
        String stringPoly = "POLY=[";

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
        stringPoly += String.format("%5.2f", area());

        return stringPoly;
    }

    /**
     * Determines if the object passed as a parameter comes before this object
     * @param o takes an object to be compared against this
     * @return true if this comes before the param, and false if it comes after
     * Precondition: this Polygon object and params o should be properly initialised with points, area and leastDistance
     * Postcondition: a true or false value will be returned depending on whether this comes before o
     */

}