package Coursera_2.Week_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;

import static Coursera_2.Week_1.NetworkPacketProcessingSimulation_3.*;

public class NetworkPacketProcessingSimulation_3_Test {

    @Test
    public void test_() {
        Queue<Integer> queue = new Queue<>(1);
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertNull(queue.pop());
        Assertions.assertTrue(queue.push(1));
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertFalse(queue.push(2));
        Assertions.assertEquals(1, queue.pop());
        Assertions.assertNull(queue.pop());
        Assertions.assertTrue(queue.push(2));
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertNull(queue.pop());
    }

    @Test
    public void test1_() {
        Queue<Integer> queue = new Queue<>(2);
        queue.push(1);
        queue.push(2);
        Assertions.assertFalse(queue.push(3));
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(1, queue.pop());
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertTrue(queue.push(3));
        Assertions.assertFalse(queue.push(4));
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(3, queue.pop());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertTrue(queue.push(5));
        Assertions.assertTrue(queue.push(6));
        Assertions.assertEquals(5, queue.pop());
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(6, queue.pop());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testPop() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(0);
        queue.push(1);
        queue.push(2);
        Assertions.assertEquals(0, queue.pop());
        queue.push(3);
        Assertions.assertEquals(1, queue.pop());
        queue.push(4);
        Assertions.assertEquals(2, queue.pop());
        Assertions.assertEquals(3, queue.pop());
        Assertions.assertEquals(4, queue.pop());
    }

    @Test
    public void test2_() {
        InputStream in = getInputStream(List.of("1 ", "0 "));
        FastScanner fs = new FastScanner(in);
        List<Integer> response = doMain(fs);
        Assertions.assertTrue(response.isEmpty());
    }

    @Test
    public void test3_() {
        List<String> list = List.of("1 ", "1 ", "0 ", "0 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(0, response.get(0));
    }

    @Test
    public void test4_() {
        List<String> list = List.of(
                "1 ", "2 ",
                "0 ", "1 ",
                "0 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(-1, response.get(1));
    }

    @Test
    public void test5_() {
        List<String> list = List.of(
                "1 ", "2 ",
                "0 ", "1 ",
                "1 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(1, response.get(1));
    }

    @Test
    public void test6_() {
        List<String> list = List.of(
                "1 ", "1 ",
                "1 ", "0 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1, response.get(0));
    }

    @Test
    public void test7_() {
        List<String> list = List.of(
                "2 ", "3 ",
                "0 ", "2 ",
                "1 ", "4 ",
                "5 ", "3 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(3, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(2, response.get(1));
        Assertions.assertEquals(6, response.get(2));
    }

    @Test
    public void test8_() {
        List<String> list = List.of(
                "1 ", "2 ",
                "0 ", "0 ",
                "0 ", "0 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(0, response.get(1));
    }

    @Test
    public void test9_() {
        List<String> list = List.of(
                "1 ", "2 ",
                "0 ", "2 ",
                "0 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(-1, response.get(1));
    }

    @Test
    public void test10_() {
        List<String> list = List.of(
                "2 ", "2 ",
                "0 ", "1 ",
                "0 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(2, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(1, response.get(1));
    }

    @Test
    public void test11_() {
        List<String> list = List.of(
                "2 ", "3 ",
                "0 ", "1 ",
                "0 ", "1 ",
                "0 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(3, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(1, response.get(1));
        Assertions.assertEquals(-1, response.get(2));
    }

    @Test
    public void test12_() {
        List<String> list = List.of(
                "2 ", "5 ",
                "0 ", "1 ",
                "0 ", "1 ",
                "0 ", "1 ",
                "0 ", "1 ",
                "0 ", "1 ");
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(5, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(1, response.get(1));
        Assertions.assertEquals(-1, response.get(2));
        Assertions.assertEquals(-1, response.get(3));
        Assertions.assertEquals(-1, response.get(4));
    }

    @Test
    public void test13_() {
        List<String> list = List.of(
                "3 ", "6 ",
                "0 ", "2 ", //1
                "1 ", "2 ", //2
                "2 ", "2 ", //3
                "3 ", "2 ", //4
                "4 ", "2 ", //5
                "5 ", "2 "); //6
        List<Integer> response = doMain(new FastScanner(getInputStream(list)));
        Assertions.assertEquals(6, response.size());
        Assertions.assertEquals(0, response.get(0));
        Assertions.assertEquals(2, response.get(1));
        Assertions.assertEquals(4, response.get(2));
        Assertions.assertEquals(6, response.get(3));
        Assertions.assertEquals(8, response.get(4));
        Assertions.assertEquals(-1, response.get(5));
    }

    private static String s = "/Users/elena-dolgova/IdeaProjects/algorithmToolbox/src/Coursera_2/Week_1/tests/";

    @ParameterizedTest
    @ValueSource(strings = {
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16",
            "17",
            "18", "19",
            "20",
            "21", "22",
    })
    public void test1(String name) throws FileNotFoundException {
        File inputFile = new File(s + name);
        InputStream inputStream = new FileInputStream(inputFile);
        List<Integer> response = doMain(new FastScanner(inputStream));
        File answerFile = new File(s + name + ".a");
        FastScanner fs = new FastScanner(new FileInputStream(answerFile));
        response.forEach(
                a -> Assertions.assertEquals(fs.nextInt(), a)
        );
    }

    private InputStream getInputStream(List<String> list) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        list.forEach(p -> {
            try {
                baos.write(p.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        byte[] bytes = baos.toByteArray();
        return new ByteArrayInputStream(bytes);
    }
}
