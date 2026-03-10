import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.tpo.pikt.itmo.Taylor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaylorTest {

    @ParameterizedTest(name = "cos({0})")
    @DisplayName("check PI dots")
    @ValueSource(doubles = {-2, -1.5, -1, -0.5, 0, 0.5, 1.5, 1, 2.5, 2})
    void checkPiDots(double param) {
        assertEquals(Math.cos(param * Math.PI), Taylor.cos(param * Math.PI, 100), 0.0001);
    }

    @ParameterizedTest(name = "cos({0}) = {1}")
    @DisplayName("check values from table")
    @CsvFileSource(resources = "/cos_table.csv", numLinesToSkip = 1, delimiter = ';')
    void checkTable(double x, double y) {
        assertEquals(y, Taylor.cos(x, 100), 0.0001);
    }
}