/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class stores the information of a Polygon including an array of
 ****    Points and it's area
 *******************************************************************************/

// An implementation of the ComparePoly function that includes functionality for non-standard Polygons
public abstract class PlanarShape implements Comparable<PlanarShape>
{
    // Instance variables
    private Point[] points;
    private int pointsSize;

    private double area;
    private double leastDistance;

    // Default Constructor
    public PlanarShape()
    {
    }

    // Constructor
    public PlanarShape(String params)
    {
    }

    /**
     * Calculates the area of the polygon
     * Precondition: Points array should not be empty (Otherwise area will be 0)
     * Postcondition: area variable indicates the area of the Polygon represented by the points in the points array
     */
    public abstract double area();

    /**
     * Outputs the Polygon as a string
     *
     * @return a String representation of the Points in the polygon followed by the area
     * Precondition: points should not (but can) be empty. Area should have been calculated otherwise it will be 0
     * Postcondition: A String representation of the Polygon will be returned
     */
    @Override
    public abstract String toString();

    /**
     * Calculates the distance from the origin of the point closest to the origin
     * Precondition: points array must have been initialised and cannot be empty
     * Postcondition: leastDistance variable will hold the value of the Euclidian distance from the
     * <Point closest to the origin> to the origin
     */
    public abstract double originDistance();

    @Override
    public int compareTo(PlanarShape s)
    {
        // Temporary variables for calculations
        double differenceMargin;
        double areaTest;
        // Determine the smaller polygon and calculate 0.05% of this area
        double margin = 0.0005;
        if (this.area() - s.area() < 0)
        {
            differenceMargin = margin * this.area();
        }
        else
        {
            differenceMargin = margin * s.area();
        }
        // Calculate the difference in area between both polygons
        areaTest = this.area() - s.area();
        // Take the absolute value
        if (areaTest < 0)
        {
            areaTest *= -1;
        }
        // If the difference in area is smaller than the calculated margin, use leastDistance to determine the order
        if (areaTest < differenceMargin)
        {
            if (this.originDistance() < s.originDistance())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        // If the difference in area is greater than the calculated margin, use the difference in area to determine order
        if (this.area() < s.area())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
