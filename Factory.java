/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    08/05/2021
 ****    This is a factory implementation interface for the PlanarShape class and
 ****    its children
 *******************************************************************************/

public interface Factory
{
    /**
     * Creates a shape specified by the parameter
     * @param type defining the desired shape
     * @return a new shape
     */
    PlanarShape create(String type, double[] values) throws Exception;
}
