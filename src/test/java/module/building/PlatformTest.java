package module.building;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Platform;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlatformTest {

    @Test
    void platformIdCannotBeZero() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Platform(0, building, true));
    }

    @Test
    void platformIdCannotBeNegative() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Platform(-1, building, true));
    }

    @Test
    void platformsBuildingCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Platform(1, null, true));
    }

    @Test
    void describePlatformContainsAllParts() {
        Building building = new Building(1, 3);
        Platform platform = new Platform(1, building, true);

        String result = platform.describe();

        assertTrue(result.contains("Platform"));
        assertTrue(result.contains("in front"));
    }

}
