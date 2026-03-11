package integration;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.ActionType;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;
import ru.tpo.pikt.itmo.entities.actors.Character;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.actors.Role;
import ru.tpo.pikt.itmo.entities.buildings.Building;
import ru.tpo.pikt.itmo.entities.buildings.Platform;
import ru.tpo.pikt.itmo.entities.buildings.Window;

public class StoryScenarioTest {

    @Test
    void fullStoryScenario() {

        Character arthur = new Character(1, "Артур", Role.MAIN);
        Character speaker = new Character(2, "Оратор", Role.MINOR);

        Crowd crowd = new Crowd(1, "спокойная", 500);

        Action shout = new Action.Builder(1, ActionType.SHOUT)
                .crowd(crowd)
                .build();

        Action perceive = new Action.Builder(2, ActionType.PERCEIVE)
                .character(arthur)
                .build();

        Action move = new Action.Builder(3, ActionType.MOVE)
                .character(arthur)
                .build();
        MovementDetails slides = new MovementDetails(1, move, MovementType.SLIDES, "воздух", "", "окно во втором этаже здания");

        Building building = new Building(1, 2);
        Window window = new Window(1, building, 2, true);
        Platform platform = new Platform(1, building, true);

        Action speak = new Action.Builder(4, ActionType.SPEAK)
                .character(speaker)
                .targetCrowd(crowd)
                .build();


    }
}
