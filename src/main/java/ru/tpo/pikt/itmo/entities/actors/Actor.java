package ru.tpo.pikt.itmo.entities.actors;

public abstract class Actor {

    protected int id;

    public Actor(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger than zero");
        }
        this.id = id;
    }

    public String describe() {
        return "Actor №" + id;
    }
}
