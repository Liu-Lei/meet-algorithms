package com.liulei.thinkinginjava.accesscontrol;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/8/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProtectedMethod {
    void packageMethod(){
        System.out.println("Package method.");
    }

    protected void protectedMethod(){
        System.out.println("Protected method.");
    }

}
