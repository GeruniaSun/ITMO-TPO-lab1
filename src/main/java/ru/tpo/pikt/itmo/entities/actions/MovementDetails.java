package ru.tpo.pikt.itmo.entities.actions;

public class MovementDetails {
    private int id;
    private MovementType movementType;
    private String environment;
    private String startPosition;
    private String endPosition;

    public MovementDetails(int id, MovementType movementType, String environment, String startPosition, String endPosition) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger then zero");
        }

        if (movementType == null) {
            throw new IllegalArgumentException("Movement type cannot be null");
        }

        this.id = id;
        this.movementType = movementType;
        this.environment = environment;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String describeMovement() {
        return movementType + " from " + startPosition + " to " + endPosition + " in the " + environment;
    }
}
