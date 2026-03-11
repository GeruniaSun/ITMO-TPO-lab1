package module.building;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Platform;
import ru.tpo.pikt.itmo.entities.buildings.Window;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowTest {

    @Test
    void windowIdCannotBeZero() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Window(0, building, 2, true));
    }

    @Test
    void windowIdCannotBeNegative() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Window(-1, building, 2,true));
    }

    @Test
    void windowsBuildingCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Window(1, null, 2, true));
    }

    @Test
    void WindowOnFloorHigherThanBuilding() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Window(1, building, 5, true));

    }

    @Test
    void WindowOnZeroFloor() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Window(1, building, 0, true));
    }

    @Test
    void WindowOnNegativeFloor() {
        Building building = new Building(1, 3);
        assertThrows(IllegalArgumentException.class,
                () -> new Window(1, building, -1, true));
    }

    @Test
    void describeWindowContainsAllParts() {
        Building building = new Building(1, 3);
        Window window = new Window(1, building, 2, true);

        String result = window.describe();

        assertTrue(result.contains("Window"));
        assertTrue(result.contains("(grand)"));
    }


}
