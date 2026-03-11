package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actors.Crowd;

import static org.junit.jupiter.api.Assertions.*;

public class CrowdTest {

    @Test
    void crowdShouldBeCreated() {

        Crowd crowd = new Crowd(1, "ликующая", 500);

        assertEquals("ликующая", crowd.getState());
        assertEquals(500, crowd.getSize());
    }

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

}
