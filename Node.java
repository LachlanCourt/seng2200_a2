/*******************************************************************************
****    SENG2200 Assignment 2
****    c3308061
****    Lachlan Court
****    04/05/2021
****    This class is a Node for a Linked List class that stores PlanarShape objects
 *******************************************************************************/

public class Node<T extends PlanarShape>
{
    // Instance variables
    private T data;
    private Node<T> next;
    private Node<T> prev;

    // Default constructor
    public Node()
    {
        data = null;
    }

    // Constructor
    public Node(T data_)
    {
        data = data_;
    }

    /**
     * @return data in Node
     */
    public T getData()
    {
        return data;
    }

    /**
     * @param data_ takes a Polygon object and stores it in the data variable
     */
    public void setData(T data_)
    {
        data = data_;
    }

    /**
     * @return the next Node in the LinkedList
     */
    public Node<T> getNext()
    {
        return next;
    }

    /**
     * @param next_ takes a Node object and sets it as the next in the LinkedList
     */
    public void setNext(Node<T> next_)
    {
        next = next_;
    }

    /**
     * @return the previous Node in the LinkedList
     */
    public Node<T> getPrev()
    {
        return prev;
    }

    /**
     * @param prev_ takes a Node object and sets it as the previous in the LinkedList
     */
    public void setPrev(Node<T> prev_)
    {
        prev = prev_;
    }
}
