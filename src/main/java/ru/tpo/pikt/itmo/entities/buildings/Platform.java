package ru.tpo.pikt.itmo.entities.buildings;

public class Platform {
    private int id;
    private Building building;
    private Boolean is_in_front;

    public Platform(int id, Building building, Boolean is_in_front) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (building == null) {
            throw new IllegalArgumentException("Platform must be bound to building ");
        }

        this.id = id;
        this.building = building;
        this.is_in_front = is_in_front;
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

    public Boolean getIs_in_front() {
        return is_in_front;
    }

    public void setIs_in_front(Boolean is_in_front) {
        this.is_in_front = is_in_front;
    }
}
