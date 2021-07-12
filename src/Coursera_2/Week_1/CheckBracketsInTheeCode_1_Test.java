package Coursera_2.Week_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBracketsInTheeCode_1_Test {
    @Test
    public void test() {
        String str = "[]";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test1() {
        String str = "{}[]";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test2() {
        String str = "[()]";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test3() {
        String str = "(())";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test4() {
        String str = "{[]}()";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test5() {
        String str = "{";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(1, answer);
    }

    @Test
    public void test6() {
        String str = "{[}";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(3, answer);
    }

    @Test
    public void test7() {
        String str = "foo(bar)";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(-1, answer);
    }

    @Test
    public void test8() {
        String str = "foo(bar[i);";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(10, answer);
    }

    @Test
    public void test9() {
        String str = ")}]";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(1, answer);
    }

    @Test
    public void test10() {
        String str = "g(j(k)";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(2, answer);
    }

    @Test
    public void test11() {
        String str = "{}{}]";
        int answer = CheckBracketsInTheeCode_1.isGood(str);
        Assertions.assertEquals(5, answer);
    }
}
