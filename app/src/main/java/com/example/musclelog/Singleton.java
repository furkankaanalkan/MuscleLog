package com.example.musclelog;


public class Singleton {

    private Exercises singexer;
    private static Singleton singleton;

    private Singleton() {

    }

    public Exercises getSingexer() {
        return singexer;
    }

    public void setSingexer(Exercises singexer) {
        this.singexer = singexer;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}