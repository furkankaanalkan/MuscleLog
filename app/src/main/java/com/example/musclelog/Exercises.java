package com.example.musclelog;

import java.io.Serializable;

class Exercises implements Serializable {
    String name;
    String description;
    int images;

    public Exercises(String name, String description, int images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }
}