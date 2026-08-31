package com.example.musclelog;


import java.util.ArrayList;

public class Singleton {

    private ArrayList<Exercises> exerciseList;

    private Exercises selectedexercise;
    private static Singleton singleton;

    private Singleton() {

    }


    public ArrayList<Exercises> getExerciseList(){
        return  exerciseList;
    }
    public void setExerciseList(ArrayList<Exercises> exerciseList){
        this.exerciseList = exerciseList;
    }


    public Exercises getSelectedexercise(){
        return  selectedexercise;
    }
    public void setSelectedexercise(Exercises selectedexercise){
        this.selectedexercise = selectedexercise;
    }


    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;

    }

}