package com.singleton;

public class Main {
    public static void main(String[] args) {
        Logger loggerOne = Logger.getInstance();
        Logger loggerTwo = Logger.getInstance();

        loggerOne.log("First message");
        loggerTwo.log("Second message");


        if (loggerOne == loggerTwo) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different instances (Singleton failed).");
        }
    }
}
