public class ShapeFactoryImplementation extends ShapeFactory
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
