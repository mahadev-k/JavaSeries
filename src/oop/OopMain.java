package oop;

public class OopMain {

    public static void main(String[] args) {

        //vibranium holds the reference of the new memory location allocated to it
        Element vibranium = new Element();

        vibranium.atomicNumber = 22; // accessible as it is default and we are in the same package
        vibranium.elementName = String.valueOf("Vibranium"); //accessible public var
        vibranium.elementSymbol = String.valueOf("Vi"); //accessible as we are in the same package protected
        //vibranium.atomicMass = 35; not accessible as it is a private variable
        //we will use setter to set atomic mass
        vibranium.setAtomicMass(35);

        System.out.printf(
                "Element [%s] :\n" +
                        "Atomic Number : %d\n" +
                        "Atomic Mass : %d\n" +
                        "Element Symbol : %s\n"
                        ,vibranium.elementName
                        ,vibranium.atomicNumber
                        ,vibranium.getAtomicMass()
                        ,vibranium.elementSymbol
        );

        /**
         * Vibranium is supposed to be similar to titanium and so the properties are similarly provided 😀
         * This element doesn't exist !!
         */

    }

}
