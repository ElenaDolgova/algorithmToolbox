package Coursera_2.Week_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Coursera_2.Week_1.MaximumInSlidingWindow_4.Dequeue;
import static Coursera_2.Week_1.MaximumInSlidingWindow_4.doMain;
import static Coursera_2.Week_1.TestUtils.equalsArrays;
import static Coursera_2.Week_1.TestUtils.getInputStream;
import static Coursera_2.Week_1.MaximumInSlidingWindow_4.FastScanner;

public class MaximumInSlidingWindow_4_Test {

    @Test
    public void testDeque1() {
        Dequeue<Integer> dequeue = new Dequeue<>(3);
        dequeue.pushFront(1);
        dequeue.pushFront(2);
        Assertions.assertEquals(2, dequeue.popFront());
        Assertions.assertEquals(1, dequeue.popFront());
    }

    @Test
    public void testDeque2() {
        Dequeue<Integer> dequeue = new Dequeue<>(3);
        dequeue.pushFront(1);
        dequeue.pushFront(2);
        Assertions.assertEquals(1, dequeue.popBack());
        Assertions.assertEquals(2, dequeue.popBack());
    }

    @Test
    public void testDeque3() {
        Dequeue<Integer> dequeue = new Dequeue<>(3);
        dequeue.pushBack(1);
        dequeue.pushBack(2);
        Assertions.assertEquals(2, dequeue.popBack());
        Assertions.assertEquals(1, dequeue.popBack());
    }

    @Test
    public void testDeque4() {
        Dequeue<Integer> dequeue = new Dequeue<>(3);
        dequeue.pushBack(1);
        dequeue.pushBack(2);
        Assertions.assertEquals(1, dequeue.popFront());
        Assertions.assertEquals(2, dequeue.popFront());
    }

    @Test
    public void testDeque5() {
        Dequeue<Integer> dequeue = new Dequeue<>(3);
        dequeue.pushBack(1);
        dequeue.pushBack(2);
        Assertions.assertEquals(1, dequeue.popFront());
        dequeue.pushBack(3);
        Assertions.assertEquals(2, dequeue.popFront());
        Assertions.assertEquals(3, dequeue.popFront());
        dequeue.pushBack(4);
        Assertions.assertEquals(4, dequeue.popFront());
        dequeue.pushBack(5);
        Assertions.assertEquals(5, dequeue.popBack());
        Assertions.assertTrue(dequeue.isEmpty());
        dequeue.pushBack(6);
        dequeue.pushFront(7);
        dequeue.pushBack(8);
        dequeue.pushFront(9);
        Assertions.assertEquals(8, dequeue.popBack());
        Assertions.assertEquals(6, dequeue.popBack());
        Assertions.assertEquals(7, dequeue.popBack());
        dequeue.pushBack(10);
        dequeue.pushFront(11);
        dequeue.pushBack(12);
        dequeue.pushFront(13);
        Assertions.assertEquals(11, dequeue.popFront());
        Assertions.assertEquals(10, dequeue.popFront());
        Assertions.assertEquals(12, dequeue.popFront());
    }

    @Test
    public void test1() {
        List<Integer> actual = doMain(new FastScanner(
                getInputStream(" 8" +
                        " 2 7 3 1 5 2 6 2" +
                        " 4")
        ));
        List<Integer> expected = List.of(7, 7, 5, 6, 6);
        equalsArrays(expected, actual);
    }

}
