package ru.tpo.pikt.itmo;

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

public class Main {
    public static void main(String[] args) {

        Character arthur = new Character(1, "Артур", Role.MAIN);
        Character orator = new Character(2, "Оратор", Role.MINOR);
        Crowd crowd = new Crowd(1, "ликующая", 500);

        Action shout = crowd.shout(1);
        System.out.println(shout.describe());

        Action perceive = arthur.perceive(2);
        System.out.println(perceive.describe());

        MovementDetails movementDetails = new MovementDetails(
             1,
             MovementType.SLIDES,
             "воздух",
             new Position("-", 0.0, 0.0, 0.0),
             new Position("окно во втором этаже здания", 24.22, 56.37, 39.39),
            20.0
        );
        Action move = arthur.move(3, movementDetails);

        System.out.println(move.describe());

        Building building = new Building(1, 2);
        Window window = new Window(1, building, 2, true);
        building.addComponent(window);
        building.addComponent(window);

        Platform platform = new Platform(1, building, true);
        building.addComponent(platform);

        Action speak = orator.speak(4, crowd);
        System.out.println(speak.describe());

        System.out.println("\n" + "Информация о действующих персонажах и объектах в истории:" + "\n" +
                arthur.describe() + "\n" +
                orator.describe() + "\n" +
                crowd.describe() + "\n" +
                building.describe()

        );


    }
}