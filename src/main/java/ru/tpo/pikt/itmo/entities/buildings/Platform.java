package ru.tpo.pikt.itmo.entities.buildings;

public class Platform extends BuildingComponent{

    private boolean isInFront;

    public Platform(int id, Building building, boolean isInFront) {
        super(id, building);
        this.isInFront = isInFront;
    }

    @Override
    public String describe() {
        return "Platform №" + id + " " + (isInFront ? "in front" : "behind");
    }

}
