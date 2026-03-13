package module.actions;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.*;
import ru.tpo.pikt.itmo.entities.actors.*;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Role;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    Character orator = new Character(1,"Артур", Role.MINOR);
    Crowd crowd = new Crowd(1,"ликующая",100);

    @Test
    void actionIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action(0, ActionType.MOVE, orator, crowd));
    }

    @Test
    void actionIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action(-1, ActionType.MOVE, orator, crowd));
    }

    @Test
    void actionTypeCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action(1, null, orator, crowd));
    }

    @Test
    void actionInitiatorCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Action(1, ActionType.MOVE, null, crowd));
    }

    @Test
    void setMovementsDetailsWithCorrectType() {
        Action moveAction = new Action(1, ActionType.MOVE, orator, crowd);
        MovementDetails details = new MovementDetails(1, MovementType.GOES, "двор",
                new Position("помост", 20.0, 20.0, 20.0), new Position("площадь", 70.0, 30.0, 40.0), 50.0);
        moveAction.setMovementDetails(details);
        assertEquals(details, moveAction.getMovementDetails());
    }

    @Test
    void setMovementsDetailsWithIncorrectType() {
        Action notMoveAction = new Action(1, ActionType.SPEAK, orator, crowd);
        MovementDetails details = new MovementDetails(1, MovementType.GOES, "двор",
                new Position("помост", 20.0, 20.0, 20.0), new Position("площадь", 70.0, 30.0, 40.0), 50.0);
        assertThrows(IllegalStateException.class,
                () -> notMoveAction.setMovementDetails(details));
    }

    @Test
    void describeBasicAction() {
        Character arthur = new Character(1, "Артур", Role.MAIN);

        Action action = new Action(1, ActionType.PERCEIVE, arthur, null);

        String result = action.describe();

        assertTrue(result.contains("Артур"));
        assertTrue(result.contains("PERCEIVE"));
    }

    @Test
    void describeWithTarget() {
        Character arthur = new Character(1, "Артур", Role.MAIN);
        Character orator = new Character(2, "оратор", Role.MINOR);

        Action action = new Action(1, ActionType.SPEAK, arthur, orator);

        String result = action.describe();

        assertTrue(result.contains("Артур"));
        assertTrue(result.contains("SPEAK"));
        assertTrue(result.contains("оратор"));
    }

    @Test
    void describeMoveWithoutDetails() {
        Character arthur = new Character(1, "Артур", Role.MAIN);

        Action action = new Action(1, ActionType.MOVE, arthur, null);

        String result = action.describe();

        assertFalse(result.contains("details"));
    }

    @Test
    void describeMoveWithDetails() {
        Character arthur = new Character(1, "Артур", Role.MAIN);

        MovementDetails details = new MovementDetails(10, MovementType.SLIDES, "воздух",
                new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0);

        Action action = new Action(1, ActionType.MOVE, arthur, null);
        action.setMovementDetails(details);

        String result = action.describe();

        assertTrue(result.contains("MOVE"));
        assertTrue(result.contains("details"));
        assertTrue(result.contains("окно"));
    }
}