package module.building;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.BuildingComponent;
import ru.tpo.pikt.itmo.entities.buildings.Platform;
import ru.tpo.pikt.itmo.entities.buildings.Window;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingTest {

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

    @Test
    void getFloorsReturnsCorrectValue() {
        Building building = new Building(1, 10);
        assertEquals(10, building.getFloors());
    }

    @Test
    void correctAddingComponents() {
        Building building = new Building(1, 3);
        BuildingComponent window = new Window(1, building, 2, true);
        BuildingComponent platform = new Platform(2, building, true);

        building.addComponent(window);
        building.addComponent(platform);

        assertTrue(building.getComponents().contains(window));
        assertTrue(building.getComponents().contains(platform));

    }

    @Test
    void addingComponentsTwice() {
        Building building = new Building(1, 3);
        BuildingComponent window = new Window(1, building, 2, true);

        building.addComponent(window);

        assertThrows(IllegalStateException.class,
                () -> building.addComponent(window));

    }

    @Test
    void describeBuildingWithoutComponentsReturnsRuin() {
        Building building = new Building(1, 1);

        String result = building.describe();

        assertTrue(result.contains("разруха"));
    }

    @Test
    void describeBuildingWithComponents() {
        Building building = new Building(1, 5);

        BuildingComponent window = new Window(1, building, 2, true);
        BuildingComponent platform = new Platform(2, building, true);

        building.addComponent(window);
        building.addComponent(platform);

        String result = building.describe();

        assertFalse(result.contains("разруха"));
        assertTrue(result.contains("5 floors"));
        assertTrue(result.contains("Window"));
        assertTrue(result.contains("Platform"));
    }

}
