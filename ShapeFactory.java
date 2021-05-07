/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    06/05/2021
 ****    This is a factory implementation method for the PlanarShape class and
 ****    its children. It extends the ShapeFactory
 *******************************************************************************/
public class ShapeFactory implements ShapeFactoryInterface
{
    public PlanarShape createShape(String shapeName) throws Exception
    {
        // Switch depending on which shape was requested
        switch (shapeName.toLowerCase())
        {
            // Return the requested shape
            case "polygon":
            {
                return new Polygon();
            }
            case "circle":
            {
                return new Circle();
            }
            case "semicircle":
            {
                return new SemiCircle();
            }
            // Return null if no valid shape was requested
            default:
                throw new Exception("No such shape");
        }
    }
}
