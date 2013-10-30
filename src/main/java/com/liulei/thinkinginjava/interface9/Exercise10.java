package com.liulei.thinkinginjava.interface9;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/7/13
 * Time: 7:37 PM
 * To change this template use File | Settings | File Templates.
 */
abstract  class Rodent{
    public void run(){
        System.out.println(String.format("%s run away with %d legs!", toString(),legsCount()));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public abstract int legsCount();
}

class Mouse extends Rodent{
    @Override
    public int legsCount() {
        return 4;
    }
}

public class Exercise10 {
    /**
     * Mouse can invoke Mouse.legsCount,
     * but if legsCount is private, final or static, it can not be override
     * @param args
     */
    public static void main(String[] args) {
        Rodent rodent = new Mouse();
        rodent.run();

        Rodent mouse = new Mouse();
        mouse.run();
    }
}
