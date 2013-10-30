package com.liulei.thinkinginjava.polymorphism;

import com.liulei.thinkinginjava.interface9.Exercise5;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 7/8/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceExercise5 implements Exercise5 {
    @Override
    public void method1() {
        System.out.println("Method 1");
    }

    @Override
    public void method2() {
        System.out.println("Method 2");
    }

    @Override
    public void method3() {
        System.out.println("Method 3");
    }

    public static void main(String[] args) {
        Exercise5 exercise5 = new InterfaceExercise5();
        exercise5.method1();
        exercise5.method2();
        exercise5.method3();
    }
}
