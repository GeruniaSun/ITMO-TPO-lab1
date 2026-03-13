package ru.tpo.pikt.itmo.entities.actors;

import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.ActionType;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;

public class Character extends Actor{

    private final String name;
    private final Role role;

    public Character(int id, String name, Role role) {

        super(id);

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (role == null) {
            throw new IllegalArgumentException("Role cannot be bull");
        }
        this.name = name;
        this.role = role;
    }

    @Override
    public String describe() {
        return name + " (" + role + ")";
    }

    public Action speak(int actionId, Actor target) {
        return new Action(actionId, ActionType.SPEAK, this, target);
    }

    public Action move(int actionId, MovementDetails details) {
        Action moveAction =  new Action(actionId, ActionType.MOVE, this, null);
        moveAction.setMovementDetails(details);
        return moveAction;
    }

    public Action perceive(int actionId) {
        return new Action(actionId, ActionType.PERCEIVE, this, null);
    }

}