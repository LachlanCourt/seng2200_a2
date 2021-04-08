import java.util.Iterator;

public class test
{
    public static void main(String[] args)
    {
        LinkedList<PlanarShape> list = new LinkedList<PlanarShape>();
        Iterator<PlanarShape> itr = list.iterator();

        Circle tempCirc = new Circle();
        tempCirc.setCentre(new Point(3, 2));
        tempCirc.setRadius(2);
        SemiCircle tempSemi = new SemiCircle();
        tempSemi.setPoints(new Point(3, 2), new Point(4,2));
        Polygon tempPoly = new Polygon();

        list.append(tempCirc);
        list.append(tempSemi);
        list.append(tempPoly);
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());

    }
}
