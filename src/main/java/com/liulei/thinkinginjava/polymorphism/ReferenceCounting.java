package com.liulei.thinkinginjava.polymorphism;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/7/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
class Shared{
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared(){
        System.out.println("Creating " + this);
    }

    public void addRef(){
        refCount++;
    }

    protected void dispose(){
        if(--refCount == 0){
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing{
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared){
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };
        for(Composing c : composing){
            c.dispose();
        }
    }
}
