package ru.tpo.pikt.itmo.entities.actions;

import ru.tpo.pikt.itmo.entities.actors.Actor;

public class Action {

    private int id;
    private ActionType type;
    private Actor initiator;
    private Actor target;
    private MovementDetails movementDetails;

    public Action(int id, ActionType type, Actor initiator, Actor target) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id must be bigger than zero");
        }

        if (type == null) {
            throw new IllegalArgumentException("Action type cannot be null");
        }

        if (initiator == null) {
            throw new IllegalArgumentException("Action must have initiator");
        }

        this.id = id;
        this.type = type;
        this.initiator = initiator;
        this.target = target;
    }

    public void setMovementDetails(MovementDetails details) {
        if (type != ActionType.MOVE) {
            throw new IllegalStateException("Movement details can only be set for MOVE action");
        }
        this.movementDetails = details;
    }

    public boolean hasTarget() {
        return target != null;
    }

    public boolean isMovement() {
        return type == ActionType.MOVE;
    }

    public MovementDetails getMovementDetails() {
        return movementDetails;
    }

    public String describe() {
        String describe = initiator.describe() + " do " + type;
        if (hasTarget()) {
            describe += " to " + target.describe();
        }
        if (isMovement() && movementDetails != null) {
            describe += "\n details: " + movementDetails.describeMovement();
        }
        return describe;
    }
}