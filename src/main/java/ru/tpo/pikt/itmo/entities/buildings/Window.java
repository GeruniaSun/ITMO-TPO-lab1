package ru.tpo.pikt.itmo.entities.buildings;

public class Window extends BuildingComponent{

    private int floor;
    private boolean isGrand;

    public Window(int id, Building building, int floor, boolean isGrand) {

        super(id, building);

        if (floor <= 0 || floor > building.getFloors()) {
            throw new IllegalArgumentException("Invalid floor number for window");
        }

        this.floor = floor;
        this.isGrand = isGrand;
    }

    @Override
    public String describe() {
        return "Window №" + id + " on floor " + floor + (isGrand ? " (grand)" : "" );
    }
}
