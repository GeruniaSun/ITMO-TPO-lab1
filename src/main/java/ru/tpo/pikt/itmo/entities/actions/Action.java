package ru.tpo.pikt.itmo.entities.actions;

import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.buildings.Window;

public class Action {

    private int id;
    private ActionType type;
    private Character character;
    private Crowd crowd;
    private Character targetCharacter;
    private Crowd targetCrowd;

    private Action() {}

    public static class Builder {
        private int id;
        private ActionType type;
        private Character character;
        private Crowd crowd;
        private Character targetCharacter;
        private Crowd targetCrowd;

        public Builder(int id, ActionType type) {

            if (id <= 0) {
                throw new IllegalArgumentException("Id must be bigger then zero");
            }

            if (type == null) {
                throw new IllegalArgumentException("Action type cannot be null");
            }

            this.id = id;
            this.type = type;
        }

        public Builder character(Character character) {
            this.character = character;
            return this;
        }

        public Builder crowd(Crowd crowd) {
            this.crowd = crowd;
            return this;
        }

        public Builder targetCharacter(Character targetCharacter) {
            this.targetCharacter = targetCharacter;
            return this;
        }

        public Builder targetCrowd(Crowd targetCrowd) {
            this.targetCrowd = targetCrowd;
            return this;
        }


        public Action build() {

            if (character == null && crowd == null) {
                throw new IllegalArgumentException("Action must have initiator");
            }

            Action action = new Action();
            action.id = id;
            action.type = type;
            action.character = character;
            action.crowd = crowd;
            action.targetCharacter = targetCharacter;
            action.targetCrowd = targetCrowd;

            return action;
        }

    }
}