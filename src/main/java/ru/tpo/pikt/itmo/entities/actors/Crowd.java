package ru.tpo.pikt.itmo.entities.actors;

import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.ActionType;

public class Crowd extends Actor{

    private String state;
    private int size;

    public Crowd(int id, String state, int size) {

        super(id);

        if (size <= 1) {
            throw new IllegalArgumentException("Crowd size must be bigger than 1");
        }

        this.state = state;
        this.size = size;
    }

    @Override
    public String describe() {
        return "Crowd of " + size + " (" + state + ")";
    }

    public Action shout(int actionId) {
        return new Action(actionId, ActionType.SHOUT, this, null);
    }
}