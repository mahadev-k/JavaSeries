package main;

import multithreading.BookingService;
import multithreading.ThreadA;
import multithreading.ThreadB;
import oop.Element;

//public access specifier implies this class can be accessed from anywhere.
public class Main {

    //This main method will help run our code.
    public static void main(String[] args) {

        //vibranium();
        workOnThread();


    }

    private static void workOnThread(){

        BookingService bookingService = new BookingService();
        Thread threadA = new ThreadA(bookingService);
        Thread threadB = new ThreadB(bookingService);

        threadA.start();
        threadB.start();

    }


    private static void vibranium(){

        Element vibranium = new Element();
        vibranium.elementName = "Vibranium";
        vibranium.setAtomicMass(35);
        //vibranium.atomicNumber = 22; default access, and we are outside the package so not accessible
        //vibranium.elementSymbol = String.valueOf("Vi"); protected access

        System.out.printf(
                "Element [%s] :\n" +
                        "Atomic Number : %s\n" +
                        "Atomic Mass : %d\n" +
                        "Element Symbol : %s\n"
                , vibranium.elementName
                , "Not Accessible"
                , vibranium.getAtomicMass()
                , "Not Accessible"
        );

    }

}
