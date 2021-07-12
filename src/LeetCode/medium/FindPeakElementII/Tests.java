package LeetCode.medium.FindPeakElementII;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    @Test
    public void test() {
        int[][] mat = {{1, 4}, {3, 2}};
        Assertions.assertArrayEquals(new int[]{0, 1}, solution.findPeakGrid(mat));
        Assertions.assertArrayEquals(new int[]{0, 1}, solution2.findPeakGrid(mat));
    }

    @Test
    public void test1() {
        int[][] mat = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        Assertions.assertArrayEquals(new int[]{1, 1}, solution2.findPeakGrid(mat));
        Assertions.assertArrayEquals(new int[]{1, 1}, solution.findPeakGrid(mat));
    }

    @Test
    public void test2() {
        int[][] mat = {{10, 30, 40, 50, 20}, {1, 3, 2, 500, 4}};
        Assertions.assertArrayEquals(new int[]{1, 3}, solution.findPeakGrid(mat));
        Assertions.assertArrayEquals(new int[]{1, 3}, solution2.findPeakGrid(mat));
    }
}
