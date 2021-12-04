package oop;

public class Element {

    /**
     * Constructor
     */
    Element(){
        this.elementName = "Element";
    }
    /**
     *This variable can be accessed in the package level and the current package is oop, won't be accessible in the main package
     */
    Integer atomicNumber;

    /**
     * This variable is accessible in the class level and so to access it outside we have a get method below and to
     * change the value we have a set method too.
     **/
    private Integer atomicMass;

    /**
     * This variable is accessible anywhere even in the main package
     */
    public String elementName;

    /**
     * Currently this will be accessible only inside this package -> oop
     * This variable can also be accessed by a class which inherits this class.
     */
    protected String elementSymbol;

    public Integer getAtomicMass(){
        return this.atomicMass;
    }

    public void setAtomicMass(Integer atomicMass){
        //Variable 'atomicMass' is assigned to itself
        //atomicMass = atomicMass;
        this.atomicMass = atomicMass;
    }


}
