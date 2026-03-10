package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.ActionType;
import ru.tpo.pikt.itmo.entities.actors.*;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Role;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void actionShouldBeCreated() {

        Character arthur = new Character(1,"Артур", Role.MAIN);
        Crowd crowd = new Crowd(1,"ликующая",100);

        Action action = new Action.Builder(1, ActionType.MOVE)
                .character(arthur)
                .crowd(crowd)
                .build();

        assertNotNull(action);
    }

    @Test
    void actionIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action.Builder(0, ActionType.MOVE));
    }

    @Test
    void actionIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action.Builder(-1, ActionType.MOVE));
    }

    @Test
    void actionTypeCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action.Builder(1, null));
    }

    @Test
    void actionMustHaveInitiator() {

        assertThrows(IllegalArgumentException.class,
                () -> new Action.Builder(1, ActionType.MOVE)
                        .build());
    }





}