import java.util.Iterator;

public class test
{
    public static void main(String[] args)
    {
        LinkedList<PlanarShape> list = new LinkedList<PlanarShape>();


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
        Iterator<PlanarShape> itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        while (itr.hasNext())
        {
            System.out.println("You won't see me because I'm empty");
            System.out.println(itr.next());
        }
        System.out.println("Break");
        Iterator<PlanarShape> itr2 = list.iterator();
        while (itr2.hasNext())
        {
            System.out.println(itr2.next());
        }
        //itr2.next();


        /*
        while (itr.hasNext())
        {
            System.out.println(itr.next());
            list.removeFromHead();
            //System.out.println();
        }

        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());*/

    }
}
