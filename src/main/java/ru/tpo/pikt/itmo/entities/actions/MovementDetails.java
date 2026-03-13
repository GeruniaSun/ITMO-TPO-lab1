package ru.tpo.pikt.itmo.entities.actions;

public class MovementDetails {
    private final int id;
    private final MovementType movementType;
    private final String environment;
    private final Position startPosition;
    private final Position endPosition;
    private final double speed;

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

    public int getId() {
        return id;
    }
}
