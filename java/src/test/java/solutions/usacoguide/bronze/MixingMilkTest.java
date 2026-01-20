package solutions.usacoguide.bronze;

import org.junit.jupiter.api.Test;

import solutions.usaco.bronze.MixingMilk;

import static org.junit.jupiter.api.Assertions.*;

class MixingMilkTest {

    @Test
    void testSampleCase() {
        int[] capacity = { 10, 11, 12 };
        int[] milk = { 3, 4, 5 };
        int[] expected = { 0, 10, 2 };
        int[] result = MixingMilk.solve(capacity.clone(), milk.clone());
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllFull() {
        int[] capacity = { 5, 5, 5 };
        int[] milk = { 5, 5, 5 };
        int[] expected = { 5, 5, 5 };
        int[] result = MixingMilk.solve(capacity.clone(), milk.clone());
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllEmpty() {
        int[] capacity = { 5, 5, 5 };
        int[] milk = { 0, 0, 0 };
        int[] expected = { 0, 0, 0 };
        int[] result = MixingMilk.solve(capacity.clone(), milk.clone());
        assertArrayEquals(expected, result);
    }
}