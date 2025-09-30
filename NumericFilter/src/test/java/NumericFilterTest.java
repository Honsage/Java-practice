import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.honsage.practice.NumericFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumericFilterTest {
    private final ArrayList<Integer> mockArray = new ArrayList<>(Arrays.asList(2, 3, 4, 8, 7, 8, 13, 9));

    @Test
    @DisplayName("Тест решета Эратосфена на малых значениях верхней границы")
    void testEratosthenesSmall() {
        assertEquals(NumericFilter.eratosthenesSieve(1), List.of(false, false));
    }

    @Test
    @DisplayName("Тест решета Эратосфена в стандартной ситуации")
    void testEratosthenesOrdinary() {
        assertEquals(NumericFilter.eratosthenesSieve(20), List.of(
                false, false, true, true, false,
                true, false, true, false, false,
                false, true, false, true, false,
                false, false, true, false, true, false));
    }

    @Test
    @DisplayName("Тест чисел Фибоначчи на малых значениях верхней границы")
    void testFibonacciSmall() {
        assertEquals(NumericFilter.fibonacci(1), List.of(0, 1, 1));
    }

    @Test
    @DisplayName("Тест чисел Фибоначчи в стандартной ситуации")
    void testFibonacciOrdinary() {
        assertEquals(NumericFilter.fibonacci(60), List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55));
    }

    @Test
    @DisplayName("Тест фильтра простых чисел")
    void testFilterPrimes() {
        assertDoesNotThrow(
            () -> {
                List<Integer> result = NumericFilter.filterPrimes(this.mockArray);
                assertEquals(Arrays.asList(2, 3, 7, 13), result);
            }
        );
    }

    @Test
    @DisplayName("Тест фильтра чисел Фибоначчи")
    void testFilterFibonacci() {
        assertDoesNotThrow(
            () -> {
                List<Integer> result = NumericFilter.filterFibonacci(this.mockArray);
                assertEquals(Arrays.asList(2, 3, 8, 8, 13), result);
            }
        );
    }

    @Test
    @DisplayName("Тест фильтра четных чисел")
    void testEvenFilter() {
        assertDoesNotThrow(
            () -> {
                List<Integer> result = NumericFilter.filterEven(this.mockArray);
                assertEquals(Arrays.asList(2, 4, 8, 8), result);
            }
        );
    }

    @Test
    @DisplayName("Тест фильтра нечетных чисел")
    void testOddFilter() {
        assertDoesNotThrow(
            () -> {
                List<Integer> result = NumericFilter.filterOdd(this.mockArray);
                assertEquals(Arrays.asList(3, 7, 13, 9), result);
            }
        );
    }
}
