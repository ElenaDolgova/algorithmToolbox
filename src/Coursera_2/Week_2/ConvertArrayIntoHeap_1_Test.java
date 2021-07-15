package Coursera_2.Week_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Coursera_2.Week_1.TestUtils.equalsArrays;
import static Coursera_2.Week_2.ConvertArrayIntoHeap_1.Heap;
import static Coursera_2.Week_2.ConvertArrayIntoHeap_1.doHeapFromArray;

public class ConvertArrayIntoHeap_1_Test {

    @Test
    public void testHeap1() {
        List<String> response = new ArrayList<>();
        Heap heap = new Heap(5);
        heap.insert(2, response);
        heap.insert(3, response);
        heap.insert(1, response);
        Assertions.assertEquals(3, heap.extractMax(response));
        Assertions.assertEquals(2, heap.extractMax(response));
        Assertions.assertEquals(1, heap.extractMax(response));
        heap.insert(4, response);
        Assertions.assertEquals(4, heap.extractMax(response));
        heap.insert(8, response);
        heap.insert(8, response);
        Assertions.assertEquals(8, heap.extractMax(response));
        heap.insert(7, response);
        Assertions.assertEquals(8, heap.extractMax(response));
        Assertions.assertEquals(7, heap.extractMax(response));
    }

    @Test
    public void doHeapFromArrayTest1() {
        List<String> actual = doHeapFromArray(new int[]{5, 4, 3, 2, 1});
        List<String> expected = List.of("1 4", "0 1", "1 3");
        equalsArrays(expected, actual);
    }

    @Test
    public void doHeapFromArrayTest2() {
        List<String> actual = doHeapFromArray(new int[]{1, 2, 3, 4, 5});
        List<String> expected = List.of();
        equalsArrays(expected, actual);
    }
}
