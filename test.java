public class test
{
    public static void main(String[] args)
    {
        Point a = new Point(5.1, 4.0);
        //Point b = new Point(4, 8.1);
        Circle temp = new Circle();
        temp.setCentre(a);
        temp.setRadius(3.2);

        PlanarShape shape = temp;


        System.out.println(shape.toString());
        System.out.println(shape.originDistance());
    }
}
