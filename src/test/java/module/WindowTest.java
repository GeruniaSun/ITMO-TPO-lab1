package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WindowTest {

    @Test
    void platformShouldBeCreated() {

        Building building = new Building(1, 3);
        Window window = new Window(1, building, 2, true);

        assertEquals(building, window.getBuilding());
        assertEquals(2, window.getFloor());
        assertEquals(true, window.getIs_grand());
    }

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
}
