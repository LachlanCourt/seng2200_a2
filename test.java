public class test
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        Circle tempCirc = new Circle();
        tempCirc.setCentre(new Point(3, 2));
        tempCirc.setRadius(2);
        SemiCircle tempSemi = new SemiCircle();
        tempSemi.setPoints(new Point(3, 2), new Point(4,2));
        Polygon tempPoly = new Polygon();


        list.append(tempCirc);
        list.append(tempSemi);
        list.append(tempPoly);
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());

    }
}
