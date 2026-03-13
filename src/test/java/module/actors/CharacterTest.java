package module.actors;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;
import ru.tpo.pikt.itmo.entities.actions.Position;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Role;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void characterIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Character(0, "Артур", Role.MAIN));
    }

    @Test
    void characterIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Character(-1, "Артур", Role.MAIN));
    }

    @Test
    void characterNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Character(1, null, Role.MAIN);
        });
    }

    @Test
    void characterNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Character(1, "", Role.MAIN));
    }

    @Test
    void characterRoleCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Character(1, "Артур", null));
    }

    @Test
    void createSpeakAction() {
        Character speaker = new Character(1, "оратор", Role.MINOR);
        Character target = new Character(2, "Артур", Role.MAIN);

        Action action = speaker.speak(1, target);

        assertTrue(action.hasTarget());
        assertFalse(action.isMovement());
    }

    @Test
    void createsMoveActionWithMovementDetails() {
        Character character = new Character(1, "Артур", Role.MAIN);
        MovementDetails details = new MovementDetails(1, MovementType.SLIDES, "воздух",
                new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0);

        Action action = character.move(1, details);

        assertTrue(action.isMovement());
        assertEquals(details, action.getMovementDetails());
    }

    @Test
    void createsMoveActionWithoutMovementDetails() {
        Character character = new Character(1, "Артур", Role.MAIN);

        Action action = character.move(1, null);

        assertTrue(action.isMovement());
        assertNull(action.getMovementDetails());
    }

    @Test
    void createPerceiveAction() {
        Character arthur = new Character(2, "Артур", Role.MAIN);

        Action action = arthur.perceive(1);

        assertFalse(action.hasTarget());
        assertFalse(action.isMovement());
    }

    @Test
    void describeCharacterContainsAllParts() {
        Character arthur = new Character(2, "Артур", Role.MAIN);

        String result = arthur.describe();

        assertTrue(result.contains("Артур"));
        assertTrue(result.contains("MAIN"));
    }

}
