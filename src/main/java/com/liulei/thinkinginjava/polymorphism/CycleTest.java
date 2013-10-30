package com.liulei.thinkinginjava.polymorphism;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/7/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class CycleTest {

    public static void ride(Cycle cycle){
        cycle.ride();
    }

    public final static void finalRide(Cycle cycle){
        cycle.ride();
    }

    public static void main(String[] args) {
        Cycle cycle1 = new Bicycle();
        Cycle cycle2 = new Unicycle();
        Cycle cycle3 = new Tricycle();

        ride(cycle1);
        ride(cycle2);
        ride(cycle3);

    }
}
