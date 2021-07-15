package Coursera_2.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConvertArrayIntoHeap_1 {

    public static class Heap {
        private final int[] list;
        private final int capacity;
        private int lastInsertedIndex;
        private int size;

        public Heap(int capacity) {
            this.capacity = capacity;
            list = new int[capacity];
            size = 0;
            lastInsertedIndex = -1;
        }

        public void insert(int value, List<String> response) {
            if (size != capacity) {
                ++size;
                ++lastInsertedIndex;
                list[lastInsertedIndex] = value;
                siftUp(lastInsertedIndex, response);
            }
        }

        public int extractMax(List<String> response) {
            if (size == 0) {
                throw new RuntimeException("Heap is empty");
            } else if (size == 1) {
                --lastInsertedIndex;
                --size;
                return this.list[0];
            }
            int value = this.list[0];
            this.list[0] = this.list[lastInsertedIndex];
            --lastInsertedIndex;
            --size;
            siftDown(0, response);
            return value;
        }

        private void siftUp(int i, List<String> response) {
            if (i == 0) {
                return;
            }
            int parentIndex = getIndexOfParent(i);

            while (list[parentIndex] < list[i]) {
                swap(parentIndex, i, response);
                i = parentIndex;
                parentIndex = getIndexOfParent(i);
            }
        }

        private void swap(int first, int second, List<String> response) {
            response.add(first + " " + second);
            list[first] = list[first] ^ list[second];
            list[second] = list[second] ^ list[first];
            list[first] = list[first] ^ list[second];
        }

        private void siftDown(int i, List<String> response) {
            int leftChildIndex = getIndexOfLeft(i);
            int rightChildIndex = getIndexOfRight(i);

            while (list[i] < list[leftChildIndex] || list[i] < list[rightChildIndex]) {
                if (list[i] < list[leftChildIndex] && list[i] < list[rightChildIndex]) {
                    int minIndex = list[leftChildIndex] < list[rightChildIndex] ?
                            leftChildIndex : rightChildIndex;
                    swap(i, minIndex, response);
                    i = minIndex;
                } else if (list[i] < list[leftChildIndex]) {
                    swap(i, leftChildIndex, response);
                    i = leftChildIndex;
                } else if (list[i] < list[rightChildIndex]) {
                    swap(i, rightChildIndex, response);
                    i = rightChildIndex;
                }
                leftChildIndex = getIndexOfLeft(i);
                rightChildIndex = getIndexOfRight(i);
            }
        }

        private static int getIndexOfParent(int i) {
            int i1 = (i + 1) / 2 - 1;
            return Math.max(i1, 0);
        }

        private int getIndexOfLeft(int i) {
            int leftChildIndex = (i + 1) * 2 - 1;
            return leftChildIndex > lastInsertedIndex ? i : leftChildIndex;
        }

        private int getIndexOfRight(int i) {
            int rightChildIndex = (i + 1) * 2 + 1 - 1;
            return rightChildIndex > lastInsertedIndex ? i : rightChildIndex;
        }
    }

    private static void swap(int first, int second, int[] list, List<String> response) {
        response.add(first + " " + second);
        list[first] = list[first] ^ list[second];
        list[second] = list[second] ^ list[first];
        list[first] = list[first] ^ list[second];
    }

    private static int getIndexOfLeft(int i, int length) {
        int leftChildIndex = (i + 1) * 2 - 1;
        return leftChildIndex > length - 1 ? i : leftChildIndex;
    }

    private static int getIndexOfRight(int i, int length) {
        int rightChildIndex = (i + 1) * 2 + 1 - 1;
        return rightChildIndex > length - 1 ? i : rightChildIndex;
    }

    private static void siftDown(int i, int[] list, List<String> response) {
        int leftChildIndex = getIndexOfLeft(i, list.length);
        int rightChildIndex = getIndexOfRight(i, list.length);

        while (list[i] > list[leftChildIndex] || list[i] > list[rightChildIndex]) {
            if (list[i] > list[leftChildIndex] && list[i] > list[rightChildIndex]) {
                int minIndex = list[leftChildIndex] < list[rightChildIndex] ?
                        leftChildIndex : rightChildIndex;
                swap(i, minIndex, list, response);
                i = minIndex;
            } else if (list[i] > list[leftChildIndex]) {
                swap(i, leftChildIndex, list, response);
                i = leftChildIndex;
            } else if (list[i] > list[rightChildIndex]) {
                swap(i, rightChildIndex, list, response);
                i = rightChildIndex;
            }
            leftChildIndex = getIndexOfLeft(i, list.length);
            rightChildIndex = getIndexOfRight(i, list.length);
        }
    }

    public static List<String> doHeapFromArray(int[] array) {
        List<String> response = new ArrayList<>();
        for (int i = array.length / 2; i >= 0; --i) {
            siftDown(i, array, response);
        }
        return response;
    }


    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = fs.nextInt();
        }
        List<String> strings = doHeapFromArray(array);
        System.out.println(strings.size());
        strings.forEach(System.out::println);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
