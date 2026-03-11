package ru.tpo.pikt.itmo.entities.buildings;

public class Building {
    private int id;
    private int floors;

    public Building(int id, int floors) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (floors <= 0) {
            throw new IllegalArgumentException("Building must have even one floor");
        }

        this.id = id;
        this.floors = floors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
