public class ShapeFactory
{
    public static PlanarShape createShape(String shapeName, double polygonSize)
    {
        switch (shapeName.toLowerCase())
        {
            case "polygon":
            {
                return new Polygon((int)polygonSize + 1);
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
    public static PlanarShape createShape(String shapeName) throws Exception
    {
        switch (shapeName.toLowerCase())
        {
            case "polygon":
            {
                throw new Exception("Number of points not specified for Polygon");
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
