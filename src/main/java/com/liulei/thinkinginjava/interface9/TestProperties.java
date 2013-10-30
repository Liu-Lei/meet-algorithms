package com.liulei.thinkinginjava.interface9;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 7/8/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestProperties  {
    public static void main(String[] args) {
        ClassInterface classInterface = new ClassInterface();
        classInterface.method();
    }

}
interface InterfaceTest{
    //interface fields implicitly static and final
    public int test = 2;

    public void method();
}

class ClassInterface implements InterfaceTest{
    @Override
    public void method() {
        System.out.println("Class Interface..." + test);
    }

}
