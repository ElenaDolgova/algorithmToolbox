package Coursera_1.Week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class ImprovingQuickSort_3 {

    private static class Pair<T, E> {
        private final T first;
        private final E second;

        public Pair(T first, E second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public E getSecond() {
            return second;
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        if (i == j) {
            return;
        }
        int k = list.get(i);
        list.set(i, list.get(j));
        list.set(j, k);
    }


    private static Pair<Integer, Integer> partition(List<Integer> list, int left, int right) {
        int pivot = list.get(left);
        int j = left;
        int equal = 0;
        for (int i = left + 1; i <= right; ++i) {
            if (list.get(i) < pivot) {
                ++j;
                swap(list, i, j);
                if (equal != 0) {
                    swap(list, i, equal + j);
                }
            } else if (list.get(i) == pivot) {
                ++equal;
                swap(list, i, j + equal);
            }
        }
        swap(list, j, left);
        return new Pair<>(j, j + equal);
    }

    private static void quickSort(List<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }

        int randomK = new Random().nextInt(right - left) + left;
        swap(list, left, randomK);
        Pair<Integer, Integer> pair = partition(list, left, right);
        quickSort(list, left, pair.first - 1);
        quickSort(list, pair.second + 1, right);
    }

    private static void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            list.add(fastScanner.nextInt());
        }
        quickSort(list);
        list.forEach(p -> System.out.print(p + " "));
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
}
