package Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSalary_7 {
    private static class Number implements Comparable<Number> {
        final String num;

        public Number(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            StringBuilder first = new StringBuilder();
            first.append(this.num).append(o.num);
            long firstNum = Long.parseLong(first.toString());
            StringBuilder second = new StringBuilder();
            second.append(o.num).append(this.num);
            long secondNum = Long.parseLong(second.toString());

            if (firstNum > secondNum) {
                return -1;
            } else if (firstNum < secondNum) {
                return 1;
            }
            return 0;
        }
    }

    public static String getMaxNumber(List<Number> list) {
        StringBuilder builder = new StringBuilder();
        List<Number> sorted = list.stream().sorted().collect(Collectors.toList());
        sorted.forEach(p -> builder.append(p.num));
        return builder.toString();
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String num = fastScanner.next();
            list.add(new Number(num));
        }
        System.out.println(getMaxNumber(list));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    @Test
    public void test1() {
        List<Number> list = List.of(new Number("34"), new Number("344"));
        String actual = getMaxNumber(list);
        String expected = "34434";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test1_1() {
        List<Number> list = List.of(new Number("344"), new Number("34"));
        String actual = getMaxNumber(list);
        String expected = "34434";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Number> list =
                List.of(new Number("5"), new Number("500"),
                        new Number("5000"), new Number("500000"));
        String actual = getMaxNumber(list);
        String expected = "55005000500000";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        List<Number> list = List.of(new Number("45"), new Number("660"), new Number("293"),
                new Number("440"), new Number("254"), new Number("25"), new Number("155"));
        String actual = getMaxNumber(list);
        String expected = "6604544029325425155";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        List<Number> list = List.of(new Number("293"), new Number("254"), new Number("25"));
        String actual = getMaxNumber(list);
        String expected = "29325425";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        List<Number> list = List.of(new Number("254"), new Number("25"));
        String actual = getMaxNumber(list);
        String expected = "25425";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        List<Number> list = List.of(new Number("21"), new Number("2"));
        String actual = getMaxNumber(list);
        String expected = "221";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        List<Number> list = List.of(new Number("9"), new Number("4"), new Number("6"),
                new Number("1"), new Number("9"));
        String actual = getMaxNumber(list);
        String expected = "99641";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        List<Number> list = List.of(new Number("23"), new Number("39"), new Number("92"));
        String actual = getMaxNumber(list);
        String expected = "923923";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        List<Number> list = List.of(new Number("43"), new Number("433"));
        String actual = getMaxNumber(list);
        String expected = "43433";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test10_1() {
        List<Number> list = List.of(new Number("433"), new Number("43"));
        String actual = getMaxNumber(list);
        String expected = "43433";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        List<Number> list = List.of(new Number("1000"), new Number("100"));
        String actual = getMaxNumber(list);
        String expected = "1001000";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test12() {
        List<Number> list = List.of(new Number("899"), new Number("89"));
        String actual = getMaxNumber(list);
        String expected = "89989";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test13() {
        List<Number> list = List.of(new Number("405"), new Number("4"));
        String actual = getMaxNumber(list);
        String expected = "4405";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test14() {
        List<Number> list = List.of(new Number("6"), new Number("608"));
        String actual = getMaxNumber(list);
        String expected = "6608";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test15() {
        List<Number> list = List.of(new Number("797"), new Number("79"), new Number("7"));
        String actual = getMaxNumber(list);
        String expected = "797977";
        Assertions.assertEquals(expected, actual);
    }
}
