/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class is a Linked List that stores Polygon objects
 *******************************************************************************/

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T>
{
    // Instance variables
    private Node<T> sentinel;
    private int size;

    // Default Constructor
    public LinkedList()
    {
        size = 0;
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    /**
     * Adds data to the start of the list
     *
     * @param data_ to be added to the Linked List
     *              Precondition: None
     *              Postcondition: Data is added to the start of the list
     */
    public void prepend(T data_)
    {
        // Create new node with the specified data
        Node temp = new Node<T>(data_);
        // Set next and previous of the new node
        temp.setNext(sentinel.getNext());
        temp.setPrev(sentinel);
        // Link the nodes on either side of the new node
        sentinel.getNext().setPrev(temp);
        sentinel.setNext(temp);
        size++;
    }

    /**
     * Adds data to the end of the list
     *
     * @param data_ to be added to the Linked List
     *              Precondition: None
     *              Postcondition: Data is added to the end of the list
     */
    public void append(T data_)
    {
        // Create new node with the specified data
        Node temp = new Node<T>(data_);
        // Set next and previous of the new node
        temp.setNext(sentinel);
        temp.setPrev(sentinel.getPrev());
        // Link the nodes on either side of the new node
        sentinel.getPrev().setNext(temp);
        sentinel.setPrev(temp);
        size++;
    }

    /**
     * Adds data in order according to the CompareBefore method
     *
     * @param data_ to be added to the Linked List
     *              Precondition: None
     *              Postcondition: Data is added to the start of the list
     */
    public void insertInOrder(T data_)
    {
        // If the list is empty, add the item to the start of the list
        if (sentinel.getNext() == sentinel)
        {
            prepend(data_);
        }
        else
        {
            // Create a temporary polygon in order to check the correct position using the ComesBefore method
            PlanarShape temp = data_;
            Node<T> tempNode = sentinel.getNext();
            // Loop through from the start of the list, checking each polygon against the temporary one
            while (temp.compareTo(tempNode.getData()) > 0)
            {
                // If execution has reached the end of the list, add the item to the end of the list
                if (tempNode.getNext() == sentinel)
                {
                    // Jump the current past the sentinel to the start of the list again
                    // Add the item to the end of the list and return
                    append(data_);
                    return;
                }
                // Step to the next item in the list
                tempNode = tempNode.getNext();
            }
            // If the loop has ended, the current pointer is in place to insert the new data before it
            // Create new node with the specified data
            Node<T> newNode = new Node<T>(data_);
            // Set next and previous of the new node
            newNode.setNext(tempNode);
            newNode.setPrev(tempNode.getPrev());
            // Link the nodes on either side of the new node
            tempNode.getPrev().setNext(newNode);
            tempNode.setPrev(newNode);
            // Increase the size
            size++;
        }
    }

    /**
     * Removes the first item from the list and returns the data. Returns null if list is empty
     *
     * @return the data from the removed node
     * Precondition: None
     * Postcondition: The first node is removed from the list and the data returned
     */
    public T removeFromHead()
    {
        // Reset current pointer

        // Only remove an item if the list is not empty
        if (size > 0)
        {
            // Create a temporary variable to save the data
            Node<T> tempNode = sentinel.getNext();
            T temp = tempNode.getData();
            // Link the sentinel to the second item in the list
            sentinel.getNext().getNext().setPrev(sentinel);
            sentinel.setNext(sentinel.getNext().getNext());
            // Unlink the old head
            //first.setNext(null);
            //first.setPrev(null);
            // Decrease the size and return the data
            size--;
            return temp;
        }
        // If the list is empty, return null
        else
        {
            return null;
        }
    }


    /**
     * Returns the size of the Linked List
     *
     * @return the size of the Linked List
     * Preconditions: None
     * Postcondition: Size of the Linked List is returned
     */
    public int getSize()
    {
        return size;
    }

    @Override
    /**
     * Returns the contents of the Linked List as a String
     */
    public String toString()
    {
        // Declare a string to hold the running contents
        String returnData = "";
        // Loop through every node in the list, and add the toString conversion of it to returnData
        for (T i : this)
        {
            returnData += i.toString() + "\n";
        }
        return returnData;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator()
    {
        return new myListIterator();
    }

    class myListIterator implements Iterator<T>
    {

        private Node<T> current = sentinel;
        private int coModificationCount = size;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            if (coModificationCount != size)
            {
                throw new ConcurrentModificationException();
            }

            if (current.getNext() == sentinel)
            {
                return false;
            }
            return true;

        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            // Step to the next item in the list
            current = current.getNext();

            // Return the data of the new current
            return current.getData();

        }
    }
}
