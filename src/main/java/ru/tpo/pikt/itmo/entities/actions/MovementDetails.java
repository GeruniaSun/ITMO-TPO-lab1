package ru.tpo.pikt.itmo.entities.actions;

public class MovementDetails {
    private int id;
    private MovementType movementType;
    private String environment;
    private Position startPosition;
    private Position endPosition;
    private double speed;

    public MovementDetails(int id, MovementType movementType, String environment, Position startPosition, Position endPosition, double speed) {

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
        this.speed = speed;
    }

    public String describeMovement() {
        return movementType + " from " + startPosition.name() + " to " + endPosition.name() + " in the " + environment +
                " it will take " + Position.getEuclidDistance(startPosition, endPosition) / speed;
    }
}
