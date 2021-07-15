package Coursera_2.Week_2;

import Coursera_2.Week_1.NetworkPacketProcessingSimulation_3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static Coursera_2.Week_1.TestUtils.equalsArrays;
import static Coursera_2.Week_1.TestUtils.getInputStream;
import static Coursera_2.Week_2.ParallelProcessing_2.*;

public class ParallelProcessing_2_Test {

    @Test
    public void test() {
        Heap<WaitingThread> heap = new Heap<>(5);
        heap.insert(new WaitingThread(2, 1));
        heap.insert(new WaitingThread(1, 2));
        Assertions.assertEquals(2, heap.extractMin().getId());
        Assertions.assertEquals(1, heap.extractMin().getId());
        heap.insert(new WaitingThread(1, 0));
        heap.insert(new WaitingThread(2, -1));
        heap.insert(new WaitingThread(3, 3));
        Assertions.assertEquals(2, heap.extractMin().getId());
        heap.insert(new WaitingThread(4, -1));
        Assertions.assertEquals(4, heap.extractMin().getId());
        Assertions.assertEquals(1, heap.extractMin().getId());
        heap.insert(new WaitingThread(5, 5));
        Assertions.assertEquals(3, heap.extractMin().getId());
        Assertions.assertEquals(5, heap.extractMin().getId());
    }

    @Test
    public void doMainTest() {
        List<Long> actual = doMain(new FastScanner(
                getInputStream("2 5 " +
                        "1 2 3 4 5")
        ));
        equalsArrays(List.of(
                0L, 0L,
                1L, 0L,
                0L, 1L,
                1L, 2L,
                0L, 4L), actual);
    }

    @Test
    public void doMainTest1() {
        List<Long> actual = doMain(new FastScanner(
                getInputStream("4 20 " +
                        "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1")
        ));
        equalsArrays(List.of(

                0L, 0L, 1L, 0L, 2L, 0L, 3L, 0L, 0L, 1L,
                1L, 1L, 2L, 1L, 3L, 1L, 0L, 2L, 1L, 2L,
                2L, 2L, 3L, 2L, 0L, 3L, 1L, 3L, 2L, 3L,
                3L, 3L, 0L, 4L, 1L, 4L, 2L, 4L, 3L, 4L), actual);
    }

    private static String s = "/Users/elena-dolgova/IdeaProjects/algorithmToolbox/src/Coursera_2/Week_2/tests_2/";

    @ParameterizedTest
    @ValueSource(strings = {
            "02", "08",
    })
    public void test1(String name) throws FileNotFoundException {
        File inputFile = new File(s + name);
        InputStream inputStream = new FileInputStream(inputFile);
        List<Long> response = doMain(new FastScanner(inputStream));
        File answerFile = new File(s + name + ".a");
        FastScanner fs = new FastScanner(new FileInputStream(answerFile));
        response.forEach(
                a -> Assertions.assertEquals(fs.nextLong(), a)
        );
    }
}
