public class test
{
    public static void main(String[] args)
    {
        Point a = new Point(4, 3);
        Point b = new Point(5, 4);
        SemiCircle temp = new SemiCircle();
        temp.setPoints(a, b);

        PlanarShape shape = temp;

        System.out.println(shape.toString());
        System.out.println(shape.originDistance());
    }
}
