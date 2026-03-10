package ru.tpo.pikt.itmo.entities.actors;

public class Character {

    private int id;
    private String name;
    private Role role;

    public Character(int id, String name, Role role) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (role == null) {
            throw new IllegalArgumentException("Role cannot be bull");
        }

        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }
}