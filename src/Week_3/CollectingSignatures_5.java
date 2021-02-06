package Week_3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Task.
 * Given a set of 𝑛 segments {[𝑎0,𝑏0],[𝑎1,𝑏1],...,[𝑎𝑛−1,𝑏𝑛−1]} with integer coordinates on a line,
 * find the minimum number 𝑚 of points such that each segment contains at least one point. That is, find a set of
 * integers 𝑋 of the minimum size such that for any segment [𝑎𝑖,𝑏𝑖] there is a point 𝑥 ∈ 𝑋 such that𝑎𝑖
 * ≤𝑥≤𝑏𝑖.
 * <p>
 * Input Format.
 * The first line of the input contains the number 𝑛 of segments. Each of the following 𝑛 lines
 * contains two integers 𝑎𝑖 and 𝑏𝑖 (separated by a space) defining the coordinates of endpoints of the 𝑖-th
 * segment.
 * <p>
 * Constraints. 1≤𝑛≤100;0≤𝑎𝑖 ≤𝑏𝑖 ≤10^9 for all 0≤𝑖<𝑛.
 * <p>
 * Output Format.
 * Output the minimum number 𝑚 of points on the first line and the integer coordinates of 𝑚 points
 * (separated by spaces) on the second line. You can output the points in any order. If there are many such sets of
 * points, you can output any set. (It is not difficult to see that there always exist a set of points of the minimum
 * size such that all the coordinates of the points are integers.)
 */
public class CollectingSignatures_5 {

    private static class Segment implements Comparable<Segment> {
        private final long a;
        private final long b;

        public Segment(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Segment o) {
            if (this.a > o.a) {
                return -1;
            } else if (this.a < o.a) {
                return 1;
            } else if (this.b > o.b) {
                return -1;
            } else if (this.b < o.b) {
                return 1;
            }
            return 0;
        }

        public long getA() {
            return a;
        }

        public long getB() {
            return b;
        }
    }

    public static Set<Long> points(List<Segment> segments) {
        List<Segment> sortedSegments = segments.stream().sorted().collect(Collectors.toList());
        TreeSet<Long> response = new TreeSet<>();
        if (sortedSegments.isEmpty()) {
            return response;
        }
        Segment firstSegment = sortedSegments.remove(sortedSegments.size() - 1);
        if (sortedSegments.isEmpty()) {
            response.add(firstSegment.b);
            return response;
        }
        long minB = firstSegment.b;
        while (!sortedSegments.isEmpty()) {
            Segment nextSegment = sortedSegments.get(sortedSegments.size() - 1);
            while (firstSegment.b >= nextSegment.a && minB >= nextSegment.a) {
                sortedSegments.remove(sortedSegments.size() - 1);
                minB = Math.min(nextSegment.b, minB);
                if (!sortedSegments.isEmpty()) {
                    nextSegment = sortedSegments.get(sortedSegments.size() - 1);
                } else {
                    response.add(minB);
                    return response;
                }
            }
            response.add(minB);
            firstSegment = sortedSegments.remove(sortedSegments.size() - 1);
            minB = firstSegment.b;
        }
        if (response.last() != minB) {
            response.add(minB);
        }
        return response;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        List<Segment> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            long a = fastScanner.nextLong();
            long b = fastScanner.nextLong();
            list.add(new Segment(a, b));
        }
        Set<Long> response = points(list);
        System.out.println(response.size());
        response.forEach(p -> System.out.print(p + " "));
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
        List<Segment> list = List.of(new Segment(1, 3), new Segment(2, 5), new Segment(3, 6));
        Set<Long> actual = points(list);
        Set<Long> expected = Set.of(3L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test1_1() {
        List<Segment> list = List.of(new Segment(4, 7), new Segment(1, 3), new Segment(2, 5),
                new Segment(5, 6));
        Set<Long> actual = points(list);
        Set<Long> expected = Set.of(3L, 6L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Segment> list = List.of(new Segment(10, 15), new Segment(14, 18), new Segment(11, 12));
        Set<Long> actual = points(list);
        Set<Long> expected = Set.of(12L, 18L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2_1() {
        List<Segment> list = List.of(new Segment(10, 15), new Segment(14, 18), new Segment(11, 14));
        Set<Long> actual = points(list);
        Set<Long> expected = Set.of(14L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        List<Segment> list = List.of(new Segment(0, 0), new Segment(1, 1), new Segment(2, 2),
                new Segment(3, 3), new Segment(0, 3));
        Set<Long> actual = points(list);
        Set<Long> expected = Set.of(0L, 1L, 2L, 3L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3_3() {
        String inputData = "" +
                "41 42\n" +
                "52 52\n" +
                "63 63\n" +
                "80 82\n" +
                "78 79\n" +
                "35 35\n" +
                "22 23\n" +
                "31 32\n" +
                "44 45\n" +
                "81 82\n" +
                "36 38\n" +
                "10 12\n" +
                "1 1\n" +
                "23 23\n" +
                "32 33\n" +
                "87 88\n" +
                "55 56\n" +
                "69 71\n" +
                "89 91\n" +
                "93 93\n" +
                "38 40\n" +
                "33 34\n" +
                "14 16\n" +
                "57 59\n" +
                "70 72\n" +
                "36 36\n" +
                "29 29\n" +
                "73 74\n" +
                "66 68\n" +
                "36 38\n" +
                "1 3\n" +
                "49 50\n" +
                "68 70\n" +
                "26 28\n" +
                "30 30\n" +
                "1 2\n" +
                "64 65\n" +
                "57 58\n" +
                "58 58\n" +
                "51 53\n" +
                "41 41\n" +
                "17 18\n" +
                "45 46\n" +
                "4 4\n" +
                "0 1\n" +
                "65 67\n" +
                "92 93\n" +
                "84 85\n" +
                "75 77\n" +
                "39 41\n" +
                "15 15\n" +
                "29 31\n" +
                "83 84\n" +
                "12 14\n" +
                "91 93\n" +
                "83 84\n" +
                "81 81\n" +
                "3 4\n" +
                "66 67\n" +
                "8 8\n" +
                "17 19\n" +
                "86 87\n" +
                "44 44\n" +
                "34 34\n" +
                "74 74\n" +
                "94 95\n" +
                "79 81\n" +
                "29 29\n" +
                "60 61\n" +
                "58 59\n" +
                "62 62\n" +
                "54 56\n" +
                "58 58\n" +
                "79 79\n" +
                "89 91\n" +
                "40 42\n" +
                "2 4\n" +
                "12 14\n" +
                "5 5\n" +
                "28 28\n" +
                "35 36\n" +
                "7 8\n" +
                "82 84\n" +
                "49 51\n" +
                "2 4\n" +
                "57 59\n" +
                "25 27\n" +
                "52 53\n" +
                "48 49\n" +
                "9 9\n" +
                "10 10\n" +
                "78 78\n" +
                "26 26\n" +
                "83 84\n" +
                "22 24\n" +
                "86 87\n" +
                "52 54\n" +
                "49 51\n" +
                "63 64\n" +
                "54 54";
        List<Segment> list = Arrays.stream(inputData.split("\n")).map(p ->
        {
            String[] pp = p.split(" ");
            return new Segment(Long.parseLong(pp[0]), Long.parseLong(pp[1]));
        }).collect(Collectors.toList());
        Set<Long> actual = points(list);
        String expectedStr = "1 4 5 8 9 10 14 15 18 23 26 28 29 30 32 34 35 36 40 41 44 46 49 52 54 56 58 61 62 63 65" +
                " 67 70 74 77 78 79 81 84 87 91 93 95";
        TreeSet<Long> expected = new TreeSet<>();
        Arrays.stream(expectedStr.split(" "))
                .map(Long::parseLong)
                .forEach(expected::add);
        Assertions.assertEquals(expected, actual);
    }
}
