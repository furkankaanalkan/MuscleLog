package com.example.musclelog;

import java.io.Serializable;

class Exercises implements Serializable {
    String name;
    int description;
    int images;

    public Exercises(String name, int description, int images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }
}