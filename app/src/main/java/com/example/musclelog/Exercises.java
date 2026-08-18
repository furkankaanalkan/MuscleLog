package com.example.musclelog;

import java.io.Serializable;

class Exercises implements Serializable {
    private String name;
    private String description;
    private int images;

    public Exercises(String name, String description, int images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }
}