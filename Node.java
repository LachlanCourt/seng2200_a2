/*******************************************************************************
****    SENG2200 Assignment 1
****    c3308061
****    Lachlan Court
****    19/03/2021
****    This class is a Node for a Linked List class that stores Polygon objects
 *******************************************************************************/

public class Node<T extends PlanarShape>
{
    // Instance variables
    private PlanarShape data;
    private Node next;
    private Node prev;

    // Default constructor
    public Node()
    {
        data = null;
    }

    // Constructor
    public Node(PlanarShape data_)
    {
        data = data_;
    }

    /**
     * @return data in Node
     */
    public PlanarShape getData()
    {
        return data;
    }

    /**
     * @param data_ takes a Polygon object and stores it in the data variable
     */
    public void setData(PlanarShape data_)
    {
        data = data_;
    }

    /**
     * @return the next Node in the LinkedList
     */
    public Node getNext()
    {
        return next;
    }

    /**
     * @param next_ takes a Node object and sets it as the next in the LinkedList
     */
    public void setNext(Node next_)
    {
        next = next_;
    }

    /**
     * @return the previous Node in the LinkedList
     */
    public Node getPrev()
    {
        return prev;
    }

    /**
     * @param prev_ takes a Node object and sets it as the previous in the LinkedList
     */
    public void setPrev(Node prev_)
    {
        prev = prev_;
    }
}
