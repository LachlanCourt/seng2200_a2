/*******************************************************************************
 ****    SENG2200 Assignment 2
 ****    c3308061
 ****    Lachlan Court
 ****    06/05/2021
 ****    This is a factory implementation method for the PlanarShape class and
 ****    its children
 *******************************************************************************/


public interface ShapeFactoryInterface
{
    /**
     * Creates a shape specified by the parameter
     * @param shapeName defining the desired shape
     * @return a new shape
     */
    public abstract PlanarShape createShape(String shapeName) throws Exception;
}
