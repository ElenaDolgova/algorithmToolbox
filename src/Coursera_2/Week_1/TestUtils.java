package Coursera_2.Week_1;

import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.IntStream;

public class TestUtils {
    public static InputStream getInputStream(List<String> list) {
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

    public static InputStream getInputStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static <T> void equalsArrays(List<T> expected, List<T> actual) {
        Assertions.assertEquals(expected.size(), actual.size(),
                "Different size of arrays. " +
                        "\nexpected: " + expected +
                        "\nactual: " + actual);
        IntStream.range(0, expected.size())
                .forEach(i ->
                        Assertions.assertEquals(expected.get(i), actual.get(i),
                                "Different arrays. " +
                                        "\nexpected: " + expected +
                                        "\nactual: " + actual));
    }
}
