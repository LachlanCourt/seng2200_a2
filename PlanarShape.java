/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    06/05/2021
 ****    This class is the parent of a shape that can be stored in a LinkedList
 *******************************************************************************/

// An implementation of the ComparePoly function that includes functionality for non-standard Polygons
public abstract class PlanarShape implements Comparable<PlanarShape>
{
    // Default Constructor
    public PlanarShape()
    {
    }

    /**
     * Calculates the area of the shape
     * @return the calculated area
     */
    public abstract double area();

    /**
     * Outputs the PlanarShape as a string
     * @return a String representation of the PlanarShape, followed by the area
     */
    @Override
    public abstract String toString();

    /**
     * Calculates the distance from the origin of the point closest to the origin
     * @return the calculated distance
     */
    public abstract double originDistance();

    /**
     * Determines whether this comesBefore the shape passed as a parameter according to its area and origin distance
     * @param s a PlanarShape to be compared
     * @return an integer -1 or 1 determining whether this comes before or after the parameter
     */
    @Override
    public int compareTo(PlanarShape s)
    {
        // Temporary variables for calculations
        double differenceMargin;
        double areaTest;
        // Determine the smaller PlanarShape and calculate 0.05% of this area
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
        // If the difference in area is smaller than the calculated margin, use originDistance to determine the order
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
