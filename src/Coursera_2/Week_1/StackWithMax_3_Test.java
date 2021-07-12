package Coursera_2.Week_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static Coursera_2.Week_1.StackWithMax_3.doMain;
import static Coursera_2.Week_1.StackWithMax_3.FastScanner;
import static Coursera_2.Week_1.TestUtils.equalsArrays;
import static Coursera_2.Week_1.TestUtils.getInputStream;

public class StackWithMax_3_Test {

    @Test
    public void test1() {
        List<Integer> responce =
                doMain(new FastScanner(getInputStream(List.of(
                        "5 ", "push 2 ", "push 1 ",
                        "max ", "pop ", "max "))));
        List<Integer> expected = List.of(2, 2);
        equalsArrays(expected, responce);
    }

    @Test
    public void test2() {
        List<Integer> responce =
                doMain(new FastScanner(getInputStream(List.of(
                        "5 ", "push 1 ", "push 2 ",
                        "max ", "pop ", "max "))));
        List<Integer> expected = List.of(2, 1);
        equalsArrays(expected, responce);
    }

    @Test
    public void test3() {
        List<Integer> responce =
                doMain(new FastScanner(getInputStream(List.of(
                        "10 push 2 push 3 push 9 push 7 push 2 max max max pop max"))));
        List<Integer> expected = List.of(9, 9, 9, 9);
        equalsArrays(expected, responce);
    }

    @Test
    public void test4() {
        List<Integer> responce =
                doMain(new FastScanner(getInputStream(List.of("3 push 1 push 7 pop"))));
        List<Integer> expected = List.of();
        equalsArrays(expected, responce);
    }

    @Test
    public void test5() {
        List<Integer> responce =
                doMain(new FastScanner(getInputStream(List.of("6 push 7 push 1 push 7 max pop max"))));
        List<Integer> expected = List.of(7, 7);
        equalsArrays(expected, responce);
    }

}
