package module.actions;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.MovementDetails;
import ru.tpo.pikt.itmo.entities.actions.MovementType;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementDetailsTest {

    @Test
    void movementDetailsIdCannotBeZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, MovementType.SLIDES, "воздух", "крыша", "окно"));
    }

    @Test
    void movementDetailsIdCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(-1, MovementType.SLIDES, "воздух", "крыша", "окно"));
    }

    @Test
    void movementDetailsTypeCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new MovementDetails(0, null, "воздух", "крыша", "окно"));
    }

    @Test
    void describeMovementContainsAllParts() {
        MovementDetails details = new MovementDetails(1, MovementType.SLIDES, "воздух", "крыша", "окно");

        String result = details.describeMovement();

        assertTrue(result.contains("воздух"));
        assertTrue(result.contains("окно"));
        assertTrue(result.contains("крыша"));
    }

}
