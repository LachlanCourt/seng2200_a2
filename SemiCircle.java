/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    06/05/2021
 ****    This class stores the information of a SemiCircle including the centre,
 ****    a number of Points around its curved edge, and functions to calculate
 ****    and it's area
 *******************************************************************************/

import java.lang.Math;
// An implementation of the ComparePoly function that includes functionality for SemiCircles
public class SemiCircle extends PlanarShape
{
    // Instance variables
    private Point centre;
    private Point pointOnLine;
    private Point leftOfCentre;
    private Point rightOfCentre;

    // Default Constructor
    public SemiCircle()
    {
    }

    /**
     * Initialise the points of the SemiCircle
     * @param values array of x and y coordinates that represent the points of the shape
     */
    public void initialise(double[] values)
    {
        // Set the points that represent the SemiCircle
        this.setPoints(new Point(values[0], values[1]), new Point(values[2], values[3]));
    }

    /**
     * Sets the points of a SemiCircle after it has been created
     * @param centre_ The centre of the polygon, imagining that it was a full circle
     * @param pointOnLine_ A point on the curved side of the polygon that is perpendicular to the straight side
     * Precondition: None
     * Postcondition: Points are set for the SemiCircle so that area calculations can be mdae
     */
    private void setPoints(Point centre_, Point pointOnLine_)
    {
        centre = centre_;
        pointOnLine = pointOnLine_;
        // Calculate the points on either side of the centre points
        leftOfCentre = new Point(centre.getX() - abs(centre.getY() - pointOnLine.getY()), centre.getY() + abs(centre.getX() - pointOnLine.getX()));
        rightOfCentre = new Point(centre.getX() + abs(centre.getY() - pointOnLine.getY()), centre.getY() - abs(centre.getX() - pointOnLine.getX()));
    }

    /**
     * Returns the radius of the semicircle
     * @return return value
     * Precondition: Points must have been initialised with setPoints()
     * Postcondition: return value
     */
    private double getRadius()
    {
        // Return the radius of the semicircle
        return Math.sqrt((Math.pow(pointOnLine.getY() - centre.getY(), 2)) + (Math.pow(pointOnLine.getX() - centre.getX(), 2)));
    }

    /**
     * Returns the absolute value
     * @param a a double to be made absolute
     * @return a positive version of a
     */
    private double abs(double a)
    {
        if (a < 0)
        {
            return a * -1;
        }
        return a;
    }

    /**
     * Calculates the area of the SemiCircle
     * @return the area of the SemiCircle
     * Precondition: Points must have been initialised with setPoints()
     * Postcondition: return value
     */
    public double area()
    {
        return Math.PI*Math.pow(this.getRadius(), 2)/2;
    }

    /**
     * Calculates the distance from the origin centre
     * @return the distance from the origin of the point closest to the origin
     * Precondition: Points must have been initialised with setPoints()
     * Postcondition: return value
     */
    public double originDistance()
    {
        // Assume the centre is the closest
        double distance = centre.calcDistance();
        // If the point on the line is closer, replace distance with that value
        if (pointOnLine.calcDistance() < distance)
        {
            distance = pointOnLine.calcDistance();
        }
        // If the point to the left of the centre is closer, replace distance with that value
        if (leftOfCentre.calcDistance() < distance)
        {
            distance = leftOfCentre.calcDistance();
        }
        // If the point to the right of the centre is closer, replace distance with that value
        if (rightOfCentre.calcDistance() < distance)
        {
            distance = rightOfCentre.calcDistance();
        }
        // Return the value which will now be the closest point
        return distance;
    }

    /**
     * Outputs the SemiCircle as a string
     * @return a String representation of the circle, followed by the area
     * Precondition: Points must have been initialised with setPoints()
     * Postcondition: return value
     */
    @Override
    public String toString()
    {
        return "SEMI=[" + centre.toString() + " " + pointOnLine.toString() + "]:    " + String.format("%5.2f", this.area());
    }
}
