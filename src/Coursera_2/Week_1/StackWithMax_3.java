package Coursera_2.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StackWithMax_3 {

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private final T value;
        private final T maxValue;

        public Node(Node<T> prev, Node<T> next, T value, T maxValue) {
            this.prev = prev;
            this.next = next;
            this.value = value;
            this.maxValue = maxValue;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public boolean isRoot() {
            return prev == null;
        }

        public T getMaxValue() {
            return maxValue;
        }
    }

    private static class Stack<T extends Comparable<T>> {
        private final int capacity;
        private int size;
        private Node<T> curNode;

        public Stack(int capacity) {
            size = 0;
            curNode = null;
            this.capacity = capacity;
        }

        public Stack(int capacity, T value) {
            this.capacity = capacity;
            curNode = new Node<>(null, null, value, value);
            size = 1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean push(T value) {
            if (size == capacity) {
                return false;
            }
            ++size;

            if (curNode == null) {
                curNode = new Node<>(null, null, value, value);
                return true;
            }

            Node<T> node;
            if (curNode.getMaxValue().compareTo(value) < 0) {
                node = new Node<>(curNode, null, value, value);
            } else {
                node = new Node<>(curNode, null, value, curNode.getMaxValue());
            }
            curNode.setNext(node);
            curNode = node;
            return true;
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            }
            --size;
            Node<T> node = curNode;
            curNode = curNode.prev;
            return node.value;
        }

        public T max() {
            return this.curNode.getMaxValue();
        }

    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        doMain(fs).forEach(System.out::println);
    }

    public static List<Integer> doMain(FastScanner fs) {
        int n = fs.nextInt();
        Stack<Integer> stack = new Stack<>(n);
        return IntStream.range(0, n)
                .mapToObj(i -> {
                    String command = fs.next();
                    switch (command) {
                        case "push": {
                            int value = fs.nextInt();
                            stack.push(value);
                            return null;
                        }
                        case "max": {
                            return stack.max();
                        }
                        case "pop": {
                            stack.pop();
                            return null;
                        }
                        default:
                            return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
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
