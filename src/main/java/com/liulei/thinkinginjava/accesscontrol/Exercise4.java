package com.liulei.thinkinginjava.accesscontrol;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/8/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Exercise4 {


    public static void main(String[] args) {
        ProtectedMethod method = new ProtectedMethod();
        method.packageMethod();
        method.protectedMethod();
    }

}
