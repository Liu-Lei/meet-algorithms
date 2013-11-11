//: polymorphism/shape/Square.java
package com.liulei.thinkinginjava.polymorphism.shape;

public class Square extends Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }

    public void erase() {
        System.out.println("Square.erase()");
    }

    public void reDraw(){
        System.out.println("Square redraw.");
    }
} ///:~
