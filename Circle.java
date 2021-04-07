/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class stores the information of a Polygon including an array of
 ****    Points and it's area
 *******************************************************************************/

import java.lang.Math;

// An implementation of the ComparePoly function that includes functionality for non-standard Polygons
public class Circle extends PlanarShape
{
    // Instance variables
    private Point centre;
    private double radius;

    // Default Constructor
    public Circle()
    {
    }

    public void setCentre(Point centre_)
    {
        centre = centre_;
    }

    private void setRadius(double radius_)
    {
        radius = radius_;
    }

    /**
     * Calculates the area of the polygon
     * Precondition: Points array should not be empty (Otherwise area will be 0)
     * Postcondition: area variable indicates the area of the Polygon represented by the points in the points array
     */
    public double area()
    {
        return Math.PI*Math.pow(this.radius, 2);
    }

    /**
     * Calculates the distance from the origin of the point closest to the origin
     * Precondition: points array must have been initialised and cannot be empty
     * Postcondition: leastDistance variable will hold the value of the Euclidean distance from the
     *                <Point closest to the origin> to the origin
     */
    public double originDistance()
    {
        return centre.calcDistance() - radius;
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
        return "CIRC=[" + centre.toString() + "]:   " + String.format("%5.2f", this.area());
    }

    /**
     * Determines if the object passed as a parameter comes before this object
     * @param o takes an object to be compared against this
     * @return true if this comes before the param, and false if it comes after
     * Precondition: this Polygon object and params o should be properly initialised with points, area and leastDistance
     * Postcondition: a true or false value will be returned depending on whether this comes before o
     */

}
