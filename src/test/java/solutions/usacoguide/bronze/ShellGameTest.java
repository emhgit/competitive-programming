package solutions.usacoguide.bronze;

import org.junit.jupiter.api.Test;

import solutions.usaco.Bronze.ShellGame;

import static org.junit.jupiter.api.Assertions.*;

public class ShellGameTest {

    @Test
    public void testSampleCase() {
        int n = 3;
        int[] a = { 1, 3, 1 };
        int[] b = { 2, 2, 3 };
        int[] g = { 1, 1, 1 };

        int result = ShellGame.calculate(n, a, b, g);
        int expected = 2;

        assertEquals(expected, result);
    }
}