import java.util.Locale;

public class ShapeFactory
{
    public PlanarShape createShape(String shapeName, double[] values)
    {
        switch (shapeName.toLowerCase())
        {
            case "polygon":
            {
                Polygon shape = new Polygon((int)values[0] + 1);
                for (int i = 1; i < values.length - 1; i += 2)
                {
                    System.out.println(i);
                    shape.addPoint(new Point(values[i], values[i + 1]), false);
                }
                shape.addPoint(new Point(values[1], values[2]), true);
                return shape;
            }
            case "circle":
            {
                Circle shape = new Circle();
                shape.setCentre(new Point(values[0], values[1]));
                shape.setRadius(values[2]);
                return shape;
            }
            case "semicircle":
            {
                SemiCircle shape = new SemiCircle();
                shape.setPoints(new Point(values[0], values[1]), new Point(values[2], values[3]));
                return shape;
            }
        }
        return null;
    }
}
