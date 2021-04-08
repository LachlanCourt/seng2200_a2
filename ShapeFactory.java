public class ShapeFactory
{
    public PlanarShape createShape(String shape)
    {
        if (shape.equalsIgnoreCase("POLYGON"))
        {
            return new Polygon();
        }
        else if (shape.equalsIgnoreCase("CIRCLE"))
        {
            return new Circle();
        }
        else if (shape.equalsIgnoreCase("SEMICIRCLE"))
        {
            return new SemiCircle();
        }
        return null;
    }
}
