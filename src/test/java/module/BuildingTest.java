package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.buildings.Building;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuildingTest {

    @Test
    void buildingShouldBeCreated() {

        Building building = new Building(1, 5);

        assertEquals(5, building.getFloors());
    }

    @Test
    void buildingIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Building(0, 3));
    }

    @Test
    void buildingIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Building(-1, 3));
    }

    @Test
    void buildingFloorsCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Building(1, 0));
    }

    @Test
    void buildingFloorsCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Building(1, -1));
    }
}
