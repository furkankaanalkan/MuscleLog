package com.example.musclelog;

import java.io.Serializable;

class Plan implements Serializable {
    private String area;
    private Exercises exercise;

    public Plan(String area, Exercises exercise) {
        this.area = area;
        this.exercise = exercise;
    }

}