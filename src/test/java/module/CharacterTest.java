package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Role;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void characterShouldBeCreated() {

        Character arthur = new Character(1, "Артур", Role.MAIN);

        assertEquals("Артур", arthur.getName());
        assertEquals(Role.MAIN, arthur.getRole());
    }

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
}
