package com.liulei.thinkinginjava.polymorphism.shape;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/11/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShapesMain {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[10];
        // fill up the array wth shapes:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // make polymorphic method calls:
        for (Shape shp : s)
            shp.reDraw();
    }
}
