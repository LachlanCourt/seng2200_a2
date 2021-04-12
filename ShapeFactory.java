import java.util.Locale;

public class ShapeFactory
{
    public PlanarShape createShape(String shapeName, double[] values)
    {
        switch (shapeName.toLowerCase())
        {
            case "polygon":
            {
                Polygon shape = new Polygon(values.length / 2 + 1);
                for (int i = 0; i < values.length - 1; i += 2)
                {
                    System.out.println(i);
                    shape.addPoint(new Point(values[i], values[i + 1]), false);
                }
                shape.addPoint(new Point(values[0], values[1]), true);
                return shape;
            }
            case "circle":
            {
                return new Circle();
            }
            case "semicircle":
            {
                return new SemiCircle();
            }
        }
        return null;
    }
}
