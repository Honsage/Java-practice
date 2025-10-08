package ru.honsage.practice;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumericFilterTest {
    private ArrayList<Integer> mockArray;

    @Before
    public void setUp() {
        mockArray = new ArrayList<>(Arrays.asList(2, 3, 4, 8, 7, 8, 13, 9));
    }

    @Test
    public void testEratosthenesSmall() {
        List<Boolean> expected = Arrays.asList(false, false);
        Assert.assertEquals(expected, NumericFilter.eratosthenesSieve(1));
    }

    @Test
    public void testEratosthenesOrdinary() {
        List<Boolean> expected = Arrays.asList(
                false, false, true, true, false,
                true, false, true, false, false,
                false, true, false, true, false,
                false, false, true, false, true, false);
        Assert.assertEquals(expected, NumericFilter.eratosthenesSieve(20));
    }

    @Test
    public void testEratosthenesBoundaryCondition() {
        List<Boolean> result = NumericFilter.eratosthenesSieve(25);
        Assert.assertFalse(result.get(25));
        Assert.assertTrue(result.get(2));
        Assert.assertTrue(result.get(3));
        Assert.assertFalse(result.get(4));
        Assert.assertTrue(result.get(5));
        Assert.assertTrue(result.get(23));
    }

    @Test
    public void testFibonacciSmall() {
        List<Integer> expected = Arrays.asList(0, 1, 1);
        Assert.assertEquals(expected, NumericFilter.fibonacci(1));
    }

    @Test
    public void testFibonacciOrdinary() {
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Assert.assertEquals(expected, NumericFilter.fibonacci(60));
    }

    @Test
    public void testFilterFibonacciBoundaryCondition() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(8, 13, 21));
        List<Integer> result = NumericFilter.filterFibonacci(input);
        Assert.assertEquals(Arrays.asList(8, 13, 21), result);
    }

    @Test
    public void testFilterPrimes() {
        try {
            List<Integer> result = NumericFilter.filterPrimes(this.mockArray);
            List<Integer> expected = Arrays.asList(2, 3, 7, 13);
            Assert.assertEquals(expected, result);
        } catch (Exception e) {
            Assert.fail("Метод не должен выбрасывать исключение: " + e.getMessage());
        }
    }

    @Test
    public void testFilterFibonacci() {
        try {
            List<Integer> result = NumericFilter.filterFibonacci(this.mockArray);
            List<Integer> expected = Arrays.asList(2, 3, 8, 8, 13);
            Assert.assertEquals(expected, result);
        } catch (Exception e) {
            Assert.fail("Метод не должен выбрасывать исключение: " + e.getMessage());
        }
    }

    @Test
    public void testEvenFilter() {
        List<Integer> result = NumericFilter.filterEven(this.mockArray);
        List<Integer> expected = Arrays.asList(2, 4, 8, 8);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testOddFilter() {
        List<Integer> result = NumericFilter.filterOdd(this.mockArray);
        List<Integer> expected = Arrays.asList(3, 7, 13, 9);
        Assert.assertEquals(expected, result);
    }
}