import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.tpo.pikt.itmo.Taylor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaylorTest {

    @ParameterizedTest(name = "cos({0})")
    @DisplayName("check PI dots")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5 * Math.PI, 3 * Math.PI / 2, 2 * Math.PI})
    void checkPiDots(double param) {
        assertAll(
                () -> assertEquals(Math.cos(param), Taylor.cos(param, 100), 0.0001)
        );
    }

    @ParameterizedTest(name = "cos({0}) = {1}")
    @DisplayName("check values from table")
    @CsvFileSource(resources = "/cos_table.csv", numLinesToSkip = 1, delimiter = ';')
    void checkTable(double x, double y) {
        assertAll(
                () -> assertEquals(y, Taylor.cos(x, 100), 0.0001)
        );
    }
}