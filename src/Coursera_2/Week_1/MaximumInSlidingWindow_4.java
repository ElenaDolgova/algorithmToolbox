package Coursera_2.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximumInSlidingWindow_4 {
    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private final T value;

        public Node(Node<T> prev, Node<T> next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
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
    }

    public static class Dequeue<T extends Comparable<T>> {
        private final int capacity;
        private int size;
        private Node<T> first;
        private Node<T> last;

        public Dequeue(int capacity) {
            this.capacity = capacity;
            size = 0;
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean pushFront(T value) {
            if (size == capacity) {
                return false;
            }
            ++size;
            Node<T> newFirst = new Node<>(null, first, value);
            if (first != null) {
                first.setPrev(newFirst);
            }
            first = newFirst;

            if (last == null) {
                last = first;
            }
            return true;
        }

        public boolean pushBack(T value) {
            if (this.size == capacity) {
                return false;
            }
            ++size;

            Node<T> newLast = new Node<>(this.last, null, value);

            if (this.last != null) {
                this.last.setNext(newLast);
            }
            last = newLast;

            if (first == null) {
                first = last;
            }
            return true;
        }

        public T peekFront() {
            return first.value;
        }

        public T popFront() {
            if (isEmpty()) {
                return null;
            }
            --size;
            T value = first.getValue();
            if (size == 0) {
                first = null;
                last = null;
                return value;
            }
            first = first.next;
            if (first != null) {
                first.setPrev(null);
            }
            return value;
        }

        public T popBack() {
            if (isEmpty()) {
                return null;
            }
            --size;
            T value = last.value;
            if (size == 0) {
                first = null;
                last = null;
                return value;
            }
            last = last.prev;
            if (last != null) {
                last.setNext(null);
            }
            return value;
        }

        public T peekBack() {
            return last.value;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        doMain(fs).forEach(System.out::println);
    }

    public static List<Integer> doMain(FastScanner fs) {
        int n = fs.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(fs.nextInt());
        }
        int k = fs.nextInt();
        Dequeue<Integer> deq = new Dequeue<>(n);
        for (int i = 0; i < k; ++i) {
            deq.pushBack(i);

            while (!deq.isEmpty() && list.get(deq.peekBack()) <= list.get(i)) {
                deq.popBack();
            }
            deq.pushBack(i);
        }
        List<Integer> response = new ArrayList<>();
        for (int i = k; i < n; ++i) {
            response.add(list.get(deq.peekFront()));

            while (!deq.isEmpty() && deq.peekFront() <= i - k) {
                deq.popFront();
            }

            while (!deq.isEmpty() && list.get(deq.peekBack()) <= list.get(i)) {
                deq.popBack();
            }
            deq.pushBack(i);
        }
        response.add(list.get(deq.peekFront()));
        return response;
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
