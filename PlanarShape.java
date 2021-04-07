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
     *                <Point closest to the origin> to the origin
     */
    public abstract double originDistance();

    public abstract boolean comesBefore(PlanarShape o);

    @Override
    public int compareTo(PlanarShape s)
    {
        if (this.comesBefore(s))
        {
            return 1;
        }
        return -1;
    }



}
