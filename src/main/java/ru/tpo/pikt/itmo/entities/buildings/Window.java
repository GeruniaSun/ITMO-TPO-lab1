package ru.tpo.pikt.itmo.entities.buildings;

public class Window {
    private int id;
    private Building building;
    private int floor;
    private Boolean is_grand;

    public Window(int id, Building building, int floor, Boolean is_grand) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (building == null) {
            throw new IllegalArgumentException("Window must be bound to building ");
        }

        this.id = id;
        this.building = building;
        this.floor = floor;
        this.is_grand = is_grand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Boolean getIs_grand() {
        return is_grand;
    }

    public void setIs_grand(Boolean is_grand) {
        this.is_grand = is_grand;
    }
}
