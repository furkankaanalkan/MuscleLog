package com.example.musclelog;


import java.util.ArrayList;
import java.util.HashMap;

public class Singleton {

    private HashMap<String, ArrayList<Exercises>> allLists = new HashMap<>();
    private Exercises selectedExercise;
    private static Singleton singleton;

    private Singleton() {

    }

    public HashMap<String, ArrayList<Exercises>> getAllLists() {
        return allLists;
    }

    public void setAllLists(HashMap<String, ArrayList<Exercises>> allLists) {
        this.allLists = allLists;
    }

    public Exercises getSelectedExercise() {
        return selectedExercise; }
    public void setSelectedExercise(Exercises selectedExercise) {
        this.selectedExercise = selectedExercise; }


    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}