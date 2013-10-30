package com.liulei.thinkinginjava.polymorphism;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/7/13
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cycle {
    public void ride(){
        System.out.println("Cycle ride.");
    }

    public int wheels(){
        return 0;
    }
}

class Unicycle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Unicycle ride." + wheels());
    }

    @Override
    public int wheels() {
        return 1;
    }
}

class Bicycle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Unicycle ride." + wheels());
    }

    @Override
    public int wheels() {
        return 2;
    }
}

class Tricycle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Unicycle ride." + wheels());
    }

    @Override
    public int wheels() {
        return 3;
    }
}



