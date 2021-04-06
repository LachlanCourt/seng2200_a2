/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class is a Point for a Polygon class that will store x, y
 ****    coordinates of a point in a Polygon
 *******************************************************************************/

// Used for sqrt function

import java.lang.Math;

// A coordinate point of a Polygon represented in cartesian coordinates
public class Point
{
    // Instance variables
    private double x;
    private double y;

    // Default Constructor
    public Point()
    {
    }

    // Constructor
    public Point(double x_, double y_)
    {
        x = x_;
        y = y_;
    }

    /**
     * @return the x value of the Point
     */
    public double getX()
    {
        return x;
    }

    /**
     * @param x_ takes a double and stores it as the x coordinate
     */
    public void setX(double x_)
    {
        x = x_;
    }

    /**
     * @return the y value of the Point
     */
    public double getY()
    {
        return y;
    }

    /**
     * @param y_ takes a double and stores it as the y coordinate
     */
    public void setY(double y_)
    {
        y = y_;
    }

    /**
     * @return a String representation of the point with the (x, y) coordinates formatted to 2dp
     */
    @Override
    public String toString()
    {
        return "(" + String.format("%3.2f", x) + " , " + String.format("%3.2f", y) + " )";
    }

    /**
     * @return the Euclidian distance of the points with respect to the origin (0, 0)
     */
    public double calcDistance()
    {
        return Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
    }

}
