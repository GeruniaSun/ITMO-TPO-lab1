package ru.tpo.pikt.itmo.entities.actions;

public class MovementDetails {
    private int id;
    private Action action;
    private MovementType movementType;
    private String environment;
    private String start_position;
    private String end_position;

    public MovementDetails(int id, Action action, MovementType movementType, String environment, String start_position, String end_position) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }
        if (action == null) {
            throw new IllegalArgumentException("Need info about action");
        }

        this.id = id;
        this.action = action;
        this.movementType = movementType;
        this.environment = environment;
        this.start_position = start_position;
        this.end_position = end_position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getStart_position() {
        return start_position;
    }

    public void setStart_position(String start_position) {
        this.start_position = start_position;
    }

    public String getEnd_position() {
        return end_position;
    }

    public void setEnd_position(String end_position) {
        this.end_position = end_position;
    }
}
