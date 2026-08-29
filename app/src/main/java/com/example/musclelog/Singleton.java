package com.example.musclelog;


import java.util.ArrayList;

public class Singleton {

    private ArrayList<ArrayList<Exercises>> allLists = new ArrayList<>();
    private ArrayList<String> selectedExerciseName;
    private ArrayList<Exercises> exerciseList;

    private Exercises selectedexercise;
    private static Singleton singleton;

    public void setAllData(ArrayList<String> selectedExercise , ArrayList<ArrayList<Exercises>> allListsHashMap){
        this.allLists = allListsHashMap;
        this.selectedExerciseName = selectedExercise;
    }

    private Singleton() {

    }

    public ArrayList<ArrayList<Exercises>> getAllLists() {
        return allLists;
    }

    public void setAllLists(ArrayList<ArrayList<Exercises>> allLists) {
        this.allLists = allLists;
    }


    public ArrayList<String> getSelectedExerciseName() {
        return selectedExerciseName; }
    public void setSelectedExerciseName(ArrayList<String> selectedExerciseName) {
        this.selectedExerciseName = selectedExerciseName; }


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