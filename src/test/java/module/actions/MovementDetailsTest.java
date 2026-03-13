package module.actions;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;
import ru.tpo.pikt.itmo.entities.actions.Position;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementDetailsTest {

    @Test
    void movementDetailsIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, MovementType.SLIDES, "воздух",
                        new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0));
    }

    @Test
    void movementDetailsIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(-1, MovementType.SLIDES, "воздух",
                        new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0));
    }

    @Test
    void movementDetailsTypeCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, null, "воздух",
                        new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0));
    }

    @Test
    void describeMovementContainsAllParts() {
        MovementDetails details = new MovementDetails(1, MovementType.SLIDES, "воздух",
                new Position("крыша", 10.0, 10.0, 10.0), new Position("окно", 50.0, 60.0, 80.0), 12.0);

        String result = details.describeMovement();

        assertTrue(result.contains("воздух"));
        assertTrue(result.contains("окно"));
        assertTrue(result.contains("крыша"));
    }

}
