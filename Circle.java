/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    21/04/2021
 ****    This class stores the information of a Circle including the centre and
 ****    radius, and functions to calculate it's area
 *******************************************************************************/

import java.lang.Math;

// An extension of the PlanarShape class that includes functionality for Circles
public class Circle extends PlanarShape
{
    // Instance variables
    private Point centre;
    private double radius;

    // Default Constructor
    public Circle()
    {
    }

    /**
     * Initialise the points of the Circle
     * @param values array of x and y coordinates that represent the points of the shape
     */
    public void initialise(double[] values)
    {
        // Set the centre and radius
        this.setCentre(new Point(values[0], values[1]));
        this.setRadius(values[2]);
    }

    /**
     * Set's the Centre Point of the circle
     * @param centre_ a Point object that represents the centre of the circle
     */
    private void setCentre(Point centre_)
    {
        centre = centre_;
    }

    /**
     * Set's the Radius of the circle
     * @param radius_ a double that represents the radius of the circle
     */
    private void setRadius(double radius_)
    {
        radius = radius_;
    }

    /**
     * Calculates the area of the circle
     * @return the area of the circle
     * Precondition: radius cannot be null
     * Postcondition: return value
     */
    public double area()
    {
        return Math.PI*Math.pow(this.radius, 2);
    }

    /**
     * Calculates the distance from the origin centre
     * @return the distance from the origin of the centre
     * Precondition: centre and radius cannot be null
     * Postcondition: return value
     */
    public double originDistance()
    {
        return centre.calcDistance() - radius;
    }

    /**
     * Outputs the Circle as a string
     * @return a String representation of the circle, followed by the area
     * Precondition: centre and radius cannot be null
     * Postcondition: return value
     */
    @Override
    public String toString()
    {
        return "CIRC=[" + centre + " " + radius + "]:   " + String.format("%5.2f", this.area());
    }

}
