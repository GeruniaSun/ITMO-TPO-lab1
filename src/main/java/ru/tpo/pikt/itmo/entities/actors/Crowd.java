package ru.tpo.pikt.itmo.entities.actors;

public class Crowd {

    private int id;
    private String state;
    private int size;

    public Crowd(int id, String state, int size) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("Crowd size cannot be negative");
        }

        this.id = id;
        this.state = state;
        this.size = size;
    }

    public String getState() {
        return state;
    }

    public int getSize() {
        return size;
    }
}