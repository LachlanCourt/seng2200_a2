/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    08/05/2021
 ****    This is a factory implementation method for the PlanarShape class and
 ****    its children. It implements the ShapeFactoryInterface
 *******************************************************************************/
public class ShapeFactory implements Factory
{
    /**
     * Creates a shape specified by the parameter
     *
     * @param type defining the desired shape
     * @return a new shape
     */
    public PlanarShape create(String type, double[] values) throws Exception
    {
        PlanarShape shape;
        // Switch depending on which shape was requested
        switch (type.toLowerCase())
        {
            // Return the requested shape
            case "polygon":
            {
                shape = new Polygon();
                break;
            }
            case "circle":
            {
                shape = new Circle();
                break;
            }
            case "semicircle":
            {
                shape = new SemiCircle();
                break;
            }
            // Throw an exception if no valid shape was requested
            default:
            {
                throw new Exception("No such shape");
            }
        }
        // Initialise the points of the PlanarShape
        shape.initialise(values);
        return shape;
    }
}
