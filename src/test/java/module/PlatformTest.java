package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlatformTest {

    @Test
    void platformShouldBeCreated() {

        Building building = new Building(1, 3);
        Platform platform = new Platform(1, building, true);

        assertEquals(building, platform.getBuilding());
        assertEquals(true, platform.getIs_in_front());
    }

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

}
