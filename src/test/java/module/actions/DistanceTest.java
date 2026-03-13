package module.actions;

import org.junit.jupiter.api.Test;
import ru.tpo.pikt.itmo.entities.actions.Position;

import static org.junit.jupiter.api.Assertions.*;
import static ru.tpo.pikt.itmo.entities.actions.Position.getEuclidDistance;
import static ru.tpo.pikt.itmo.entities.actions.Position.getManhattanDistance;

public class DistanceTest {

    @Test
    void testEuclidDistance() {
        assertAll(
                () -> assertEquals(13.0, getEuclidDistance(
                                new Position("foo", 0,0,0),
                                new Position("bar", 3,4,12)), 1e-9),

                () -> assertEquals(5.0,
                        getEuclidDistance(new Position("foo", 0,0,0), new Position("bar", 3,4,0)), 1e-9),

                () -> assertEquals(Math.sqrt(3),
                        getEuclidDistance(new Position("foo", 1,1,1), new Position("bar", 2,2,2)), 1e-9),

                () -> assertEquals(10.0,
                        getEuclidDistance(new Position("foo", -5,0,0), new Position("bar", 5,0,0)), 1e-9),

                () -> assertEquals(0.0,
                        getEuclidDistance(new Position("foo", 7,7,7), new Position("bar", 7,7,7)), 1e-9)
        );
    }

    @Test
    void manhattanDistanceIsCorrect() {
        assertAll(
                () -> assertEquals(13.0,
                        getManhattanDistance(new Position("foo", 4,6,9), new Position("bar", 1,2,3))),

                () -> assertEquals(7.0,
                        getManhattanDistance(new Position("foo", 5,5,5), new Position("bar", 3,3,2))),

                () -> assertEquals(3.0,
                        getManhattanDistance(new Position("foo", 3,3,3), new Position("bar", 2,2,2))),

                () -> assertEquals(9.0,
                        getManhattanDistance(new Position("foo", 10,5,0), new Position("bar", 5,3,-2))),

                () -> assertEquals(0.0,
                        getManhattanDistance(new Position("foo", 1,1,1), new Position("bar", 1,1,1)))
        );
    }
}
