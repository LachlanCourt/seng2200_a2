public class ShapeFactory
{
    public static PlanarShape createShape(String shapeName)
    {
        switch (shapeName.toLowerCase())
        {
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
            default:
                return null;
        }
    }
}
