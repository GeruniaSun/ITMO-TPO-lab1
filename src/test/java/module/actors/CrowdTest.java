package module.actors;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.actors.Role;

import static org.junit.jupiter.api.Assertions.*;

public class CrowdTest {

    @Test
    void crowdIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Crowd(0, "ликующая", 10));
    }

    @Test
    void crowdIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Crowd(-1, "ликующая", 10));
    }

    @Test
    void crowdSizeCannotBeZero() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Crowd(1, "ликующая", 0);
        });
    }

    @Test
    void crowdSizeCannotBeNegative() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Crowd(1, "ликующая", -5);
        });
    }

    @Test
    void crowdSizeMustBeBiggerThanOne() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Crowd(1, "ликующая", 1);
        });
    }

    @Test
    void createShoutAction() {
        Crowd crowd = new Crowd(1, "ликующая", 10);

        Action action = crowd.shout(1);

        assertFalse(action.hasTarget());
        assertFalse(action.isMovement());
    }

    @Test
    void describeCrowdContainsAllParts() {
        Crowd crowd = new Crowd(1, "ликующая", 10);

        String result = crowd.describe();

        assertTrue(result.contains("ликующая"));
        assertTrue(result.contains("10"));
    }

}
