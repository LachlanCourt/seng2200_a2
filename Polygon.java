/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    20/04/2021
 ****    This class stores the information of a Polygon including an array of
 ****    Points and functions to calculate it's area
 *******************************************************************************/

// An extension of the PlanarShape class that includes functionality for non-standard Polygons
public class Polygon extends PlanarShape
{
    // Instance variables
    private Point[] points;
    private int pointsSize;

    // Default Constructor
    public Polygon()
    {
        pointsSize = 0;
    }

    // Standard constructor
    public Polygon(int size_)
    {
        points = new Point[size_ + 1];
        pointsSize = 0;
    }

    /**
     * Initialises the points of the Polygon
     * @param values array of values starting with the number of points followed by x and y coordinates that represent
     * the points of the shape
     */
    public void initialise(double[] values)
    {
        // Set the number of points that will be added to the Polygon object
        points = new Point[(int)values[0] + 1];
        /*
         Loop through the values and add a point for every 2 values, ignoring the first value which is the
         number of points
         */
        for (int i = 1; i < values.length - 1; i += 2)
        {
            // Pass false to indicate the point being added is not the last point
            this.addPoint(new Point(values[i], values[i + 1]), false);
        }
        /*
         Add the first point again, which will be used to calculate the area. Pass true to indicate it is
         the last point
         */
        this.addPoint(new Point(values[1], values[2]), true);
    }

    /**
     * Adds a point to the array of points that represent the Polygon
     *
     * @param newPoint  a Point object that should be added to the end of the existing array of points
     * @param lastPoint a boolean indicating whether the Point being added is the last point thus completing the polygon
     *                  Precondition: Points array must be initialised, either in the constructor or in setNumberPoints()
     *                  Postcondition: newPoint is added to the points array
     */
    private void addPoint(Point newPoint, boolean lastPoint)
    {
        // Add the new Point to the next spot in the points array
        points[pointsSize] = newPoint;
        if (!lastPoint)
        {
            /*
             Only increment the logical size if the point being added is not the last point. The last point is a
             duplicate of the first point and is used to calculate the area. As it's a duplicate, it is "Hidden" by not
             increasing the logical size
             */
            pointsSize++;
        }
    }

    /**
     * Calculates the area of the polygon
     *
     * @return the area of the polygon
     * Precondition: Points array must be initialised. If there are no points added then area will be 0
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
     *
     * @return the distance from the origin from the point closest to the origin
     * Precondition: points array must have been initialised and cannot be empty
     * Postcondition: leastDistance variable will hold the value of the Euclidian distance to the from the point
     * closest to the origin
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
     * Precondition: points should not (but can) be empty. Area with an empty array of Points will be 0
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
            stringPoly += " " + points[i];
        }

        // Close the bracket to indicate the list of Points is complete
        stringPoly += " ]:    ";

        // Add the area of the Polygon to the end and return
        stringPoly += String.format("%5.2f", area());

        return stringPoly;
    }
}