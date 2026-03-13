package integration;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;
import ru.tpo.pikt.itmo.entities.actions.Position;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.actors.Role;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Platform;
import ru.tpo.pikt.itmo.entities.buildings.Window;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fullScenarioTest() {

        Character arthur = new Character(1, "Артур", Role.MAIN);
        Character orator = new Character(2, "Оратор", Role.MINOR);
        Crowd crowd = new Crowd(1, "ликующая", 500);

        Action shout = crowd.shout(1);
        assertTrue(shout.describe().contains("SHOUT"));

        Action perceive = arthur.perceive(2);
        assertTrue(perceive.describe().contains("PERCEIVE"));

        MovementDetails movementDetails = new MovementDetails(
                1,
                MovementType.SLIDES,
                "воздух",
                new Position("-", 0.0, 0.0, 0.0),
                new Position("окно во втором этаже здания", 24.22, 56.37, 39.39),
                25.0
        );

        Action move = arthur.move(3, movementDetails);
        assertTrue(move.describe().contains("SLIDES"));

        Building building = new Building(1, 2);

        Window window = new Window(1, building, 2, true);
        building.addComponent(window);

        Platform platform = new Platform(1, building, true);
        building.addComponent(platform);

        Action speak = orator.speak(4, crowd);
        assertTrue(speak.describe().contains("SPEAK"));

        String buildingDescription = building.describe();

        assertTrue(buildingDescription.contains("Building"));
        assertTrue(buildingDescription.contains("Window"));
        assertTrue(buildingDescription.contains("Platform"));

        assertTrue(arthur.describe().contains("Артур"));
        assertTrue(orator.describe().contains("Оратор"));
        assertTrue(crowd.describe().contains("ликующая"));
    }
}