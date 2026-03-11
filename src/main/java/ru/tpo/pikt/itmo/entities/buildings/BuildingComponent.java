package ru.tpo.pikt.itmo.entities.buildings;

import java.util.Objects;

public abstract class BuildingComponent {

    protected int id;
    protected Building building;

    public BuildingComponent(int id, Building building) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger than zero");
        }
        if (building == null) {
            throw new IllegalArgumentException("Component must be bound to building");
        }
        this.id = id;
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public abstract String describe();

    @Override
    public int hashCode() {
        return Objects.hash(id, getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BuildingComponent component = (BuildingComponent) obj;
        return id == component.id;
    }
}
