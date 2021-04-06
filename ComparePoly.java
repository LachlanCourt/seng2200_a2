/*******************************************************************************
 ****    SENG2200 Assignment 1
 ****    c3308061
 ****    Lachlan Court
 ****    19/03/2021
 ****    This interface is implemented by the Polygon class
 *******************************************************************************/

// Interface for the Polygon class to ensure that it will contain a function named ComesBefore
public interface ComparePoly {
    boolean comesBefore(Object o); // true if this < parameter
}