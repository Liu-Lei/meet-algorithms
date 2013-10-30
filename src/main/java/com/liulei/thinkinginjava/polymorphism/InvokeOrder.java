package com.liulei.thinkinginjava.polymorphism;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/7/13
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */

class Bread{
    public Bread(){
        System.out.println("Bread created.");
    }
}

class Meal{
    public Meal(){
        System.out.println("Meal created.");
    }
}
class InvokeFather{
    public InvokeFather(){
        System.out.println("InvokeFather created.");
    }
}

public class InvokeOrder extends InvokeFather{
    public InvokeOrder(){
        System.out.println("Invoke Order created.");
    }
    private Bread bread = new Bread();
    private Meal meal = new Meal();

    public static void main(String[] args) {
        InvokeOrder order = new InvokeOrder();
    }
}