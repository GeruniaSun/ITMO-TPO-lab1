package ru.tpo.pikt.itmo.entities.buildings;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int id;
    private final int floors;
    private final List<BuildingComponent> components = new ArrayList<>();

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

    public int getFloors() {
        return floors;
    }

    public void addComponent(BuildingComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
        if (components.contains(component)) {
            throw new IllegalStateException(
                    "Component with id=" + component.getId() + " already exists in building"
            );
        }
        components.add(component);
    }

    public List<BuildingComponent> getComponents() {
        return List.copyOf(components);
    }

    public String describe() {
        StringBuilder sb = new StringBuilder("Building №" + id + " (" + floors + " floors)\n");

        if (components.isEmpty()) {
            sb.append(" разруха");
        } else {
            for (BuildingComponent comp : components) {
                sb.append("  ").append(comp.describe()).append("\n");
            }
        }
        return sb.toString();
    }
}
