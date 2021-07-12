package LeetCode.medium.atoi;

import org.junit.jupiter.api.*;

public class Tests {
    private final Solution solution = new Solution();

    @Test
    public void test() {
        Assertions.assertEquals(42, solution.myAtoi("42"));
        Assertions.assertEquals(42, solution.myAtoi("+42"));
        Assertions.assertEquals(42, solution.myAtoi("   +42"));
        Assertions.assertEquals(42, solution.myAtoi("   +42    "));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(-42, solution.myAtoi("-42"));
        Assertions.assertEquals(-42, solution.myAtoi("   -42"));
        Assertions.assertEquals(-42, solution.myAtoi("   -42    "));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(4193, solution.myAtoi("4193 with words"));
        Assertions.assertEquals(0, solution.myAtoi("words and 987"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(-2147483648, solution.myAtoi("-91283472332"));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(-12, solution.myAtoi("  -0012a42"));
        Assertions.assertEquals(0, solution.myAtoi("00000-42a1234"));
        Assertions.assertEquals(3, solution.myAtoi("3.14159"));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(-1, solution.myAtoi("-000000000000001"));
        Assertions.assertEquals(2147483647, solution.myAtoi("20000000000000000000"));
        Assertions.assertEquals(12345678, solution.myAtoi("  0000000000012345678"));
    }
}
