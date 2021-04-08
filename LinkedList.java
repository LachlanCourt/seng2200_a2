/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This class is a Linked List that stores Polygon objects
 *******************************************************************************/
public class LinkedList<T extends PlanarShape>
{
    // Instance variables
    private Node sentinel ;
    private Node current;
    private int size;

    // Default Constructor
    public LinkedList()
    {
        size = 0;
        sentinel = new Node();
        current = sentinel;
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    /**
     * Adds data to the start of the list
     * @param data_ to be added to the Linked List
     * Precondition: None
     * Postcondition: Data is added to the start of the list
     */
    public void prepend(PlanarShape data_)
    {
        // Reset current pointer
        currentToHead();
        // Create new node with the specified data
        Node temp = new Node(data_);
        // Set next and previous of the new node
        temp.setNext(current);
        temp.setPrev(sentinel);
        // Link the nodes on either side of the new node
        current.setPrev(temp);
        sentinel.setNext(temp);
        // Reset the current to be on the new node and increase the size
        currentToHead();
        size++;
    }

    /**
     * Adds data to the end of the list
     * @param data_ to be added to the Linked List
     * Precondition: None
     * Postcondition: Data is added to the end of the list
     */
    public void append(PlanarShape data_)
    {
        // Reset current pointer
        currentToHead();
        // Create new node with the specified data
        Node temp = new Node(data_);
        // Set next and previous of the new node
        temp.setNext(sentinel);
        temp.setPrev(sentinel.getPrev());
        // Link the nodes on either side of the new node
        sentinel.getPrev().setNext(temp);
        sentinel.setPrev(temp);
        // Reset the current to be on the new node and increase the size
        currentToHead();
        size++;
    }

    /**
     * Adds data before the current pointer
     * @param data_ to be added to the Linked List
     * Precondition: None
     * Postcondition: Data is added to the list before the current
     */
    public void insert(PlanarShape data_)
    {
        // Create new node with the specified data
        Node temp = new Node(data_);
        // Set next and previous of the new node
        temp.setNext(current);
        temp.setPrev(current.getPrev());
        // Link the nodes on either side of the new node
        current.getPrev().setNext(temp);
        current.setPrev(temp);
        // Increase the size
        size++;
    }

    /**
     * Adds data in order according to the CompareBefore method
     * @param data_ to be added to the Linked List
     * Precondition: None
     * Postcondition: Data is added to the start of the list
     */
    public void insertInOrder(PlanarShape data_)
    {
        /*
        // Reset the current of the List
        currentToHead();
        // If the list is empty, add the item to the start of the list
        if (current == sentinel)
        {
            prepend(data_);
        }
        else
        {
            // Create a temporary polygon in order to check the correct position using the ComesBefore method
            Polygon temp = data_;
            // Loop through from the start of the list, checking each polygon against the temporary one
            while (temp.comesBefore(current.getData()))
            {
                // If execution has reached the end of the list, add the item to the end of the list
                if (!hasNext())
                {
                    // Jump the current past the sentinel to the start of the list again
                    next();
                    // Add the item to the end of the list and return
                    append(data_);
                    return;
                }
                // Step to the next item in the list
                next();
            }
            // If the loop has ended, the current pointer is in place to insert the new data before it
            insert(data_);
        }
        (
         */
    }

    /**
     * Steps the current pointer to the next in the list
     * @return the data of the new current after the step
     * Precondition: List cannot be empty. Call hasNext first to check
     * Postcondition: Data of the current node is returned
     */
    public PlanarShape next()
    {
        // Step to the next item in the list
        current = current.getNext();
        /*
         If after the step the current has become the sentinel, the list has reached the end. Step again to be on the
         current
         */
        if (current == sentinel)
        {
            currentToHead();
        }

        // Return the data of the new current
        return current.getData();
    }

    /**
     * Checks if the current pointer is at the end of the list or not
     * @return boolean true if the current is not at the end of the list
     * Precondition: None
     * Postcondition: Returns whether the current is at the end of the list or not
     */
    public boolean hasNext()
    {
        if (current.getNext() == sentinel)
        {
            return false;
        }
        return true;
    }

    /**
     * Resets the current to the head
     * Precondition: None
     * Postcondition: current pointer is the same as the head of the list
     */
    public void currentToHead()
    {
        current = sentinel.getNext();
    }


    /**
     * Removes the first item from the list and returns the data. Returns null if list is empty
     * @return the data from the removed node
     * Precondition: None
     * Postcondition: The first node is removed from the list and the data returned
     */
    public PlanarShape removeFromHead()
    {
        // Reset current pointer
        currentToHead();
        // Only remove an item if the list is not empty
        if (size > 0)
        {
            // Create a temporary variable to save the data
            PlanarShape temp = current.getData();
            // Link the sentinel to the second item in the list
            current.getNext().setPrev(sentinel);
            sentinel.setNext(current.getNext());
            // Unlink the old head
            current.setNext(null);
            current.setPrev(null);
            // Reset the current to set it to the new head
            currentToHead();
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
        // Reset the current to the start of the list
        currentToHead();
        // Loop through every node in the list, and add the toString conversion of it to returnData
        for (int i = 0; i < getSize(); i++)
        {
            PlanarShape temp = removeFromHead();
            returnData += temp.toString() + "\n";
            append(temp);
        }
        // Return
        return returnData;
    }
}
