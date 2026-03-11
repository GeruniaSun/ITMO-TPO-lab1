package module;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Action;
import ru.tpo.pikt.itmo.entities.actions.ActionType;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;
import ru.tpo.pikt.itmo.entities.actors.Crowd;
import ru.tpo.pikt.itmo.entities.actors.Role;
import ru.tpo.pikt.itmo.entities.actors.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovementDetailsTest {

    Character arthur = new Character(1, "Артур", Role.MAIN);
    Crowd crowd = new Crowd(1,"ликующая",100);

    Action move = new Action.Builder(1, ActionType.MOVE)
            .character(arthur)
            .crowd(crowd)
            .build();

    @Test
    void movementDetailsShouldBeCreated() {
        MovementDetails details = new MovementDetails(
                1, move, MovementType.SLIDES, "воздух", "крыша", "окно"
        );
        assertEquals(move, details.getAction());
        assertEquals(MovementType.SLIDES, details.getMovementType());
        assertEquals("воздух", details.getEnvironment());
        assertEquals("крыша", details.getStart_position());
        assertEquals("окно", details.getEnd_position());
    }

    @Test
    void movementDetailsIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, move, MovementType.SLIDES, "воздух", "крыша", "окно"));
    }

    @Test
    void movementDetailsIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(-1, move, MovementType.SLIDES, "воздух", "крыша", "окно"));
    }

    @Test
    void movementDetailsTypeCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, move, null, "воздух", "крыша", "окно"));
    }
}
