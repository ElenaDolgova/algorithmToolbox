package Coursera_2.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ParallelProcessing_2 {

    public interface Thread<T> extends Comparable<T> {
        long getId();

        long getPriority();
    }

    public static class WaitingThread implements Thread<WaitingThread> {
        private final long id;
        // чем ниже priorityFree, тем первее поток будет активным
        // можно было бы использовать просто Queue, если бы
        // numberInQueue были всегда разные
        // minHeap
        private final long priority;

        public WaitingThread(long id, long priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public int compareTo(WaitingThread o) {
            if (this.priority < o.priority) {
                return -1;
            } else if (this.priority > o.priority) {
                return 1;
            }
            if (this.id < o.id) {
                return -1;
            } else if (this.id > o.id) {
                return 1;
            }
            return 0;
        }

        @Override
        public long getId() {
            return id;
        }

        @Override
        public long getPriority() {
            return priority;
        }
    }

    public static class RunningThread implements Thread<RunningThread> {
        private final long id;
        private final long startTime;
        private final long processTime;
        // чем больше priority, тем позже поток освободится
        // minHeap
        private final long priority;

        public RunningThread(long id, long startTime, long processTime) {
            this.id = id;
            this.priority = startTime + processTime;
            this.startTime = startTime;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(RunningThread o) {
            if (this.priority < o.priority) {
                return -1;
            } else if (this.priority > o.priority) {
                return 1;
            }
            if (this.id < o.id) {
                return -1;
            } else if (this.id > o.id) {
                return 1;
            }
            return 0;
        }

        @Override
        public long getId() {
            return id;
        }

        @Override
        public long getPriority() {
            return priority;
        }
    }

    public static class Heap<T extends Thread<T>> {
        private final List<T> list;
        private final int capacity;
        private int lastInsertedIndex;
        private int size;

        public Heap(int capacity) {
            this.capacity = capacity;
            list = new ArrayList<>(capacity);
            size = 0;
            lastInsertedIndex = -1;

            for (int i = 0; i < capacity; ++i) {
                list.add(null);
            }
        }

        public void insert(T value) {
            if (size != capacity) {
                ++size;
                ++lastInsertedIndex;
                list.set(lastInsertedIndex, value);
                siftUp(lastInsertedIndex);
            }
        }

        public T peekMin() {
            return this.list.get(0);
        }

        public T extractMin() {
            if (size == 0) {
                throw new RuntimeException("Heap is empty");
            } else if (size == 1) {
                --lastInsertedIndex;
                --size;
                return this.list.get(0);
            }
            T value = this.list.get(0);
            this.list.set(0, this.list.get(lastInsertedIndex));
            --lastInsertedIndex;
            --size;
            siftDown(0);
            return value;
        }

        private void siftUp(int i) {
            if (i == 0) {
                return;
            }
            int parentIndex = getIndexOfParent(i);

            while (list.get(parentIndex).compareTo(list.get(i)) > 0) {
                swap(parentIndex, i);
                i = parentIndex;
                parentIndex = getIndexOfParent(i);
            }
        }

        private void swap(int first, int second) {
            Collections.swap(list, first, second);
        }

        private void siftDown(int i) {
            int leftChildIndex = getIndexOfLeft(i);
            int rightChildIndex = getIndexOfRight(i);
            while (list.get(i).compareTo(list.get(leftChildIndex)) > 0 ||
                    list.get(i).compareTo(list.get(rightChildIndex)) > 0) {
                if (list.get(i).compareTo(list.get(leftChildIndex)) > 0 &&
                        list.get(i).compareTo(list.get(rightChildIndex)) > 0) {
                    int minIndex = list.get(leftChildIndex).compareTo(list.get(rightChildIndex)) < 0 ?
                            leftChildIndex : rightChildIndex;
                    swap(i, minIndex);
                    i = minIndex;
                } else if (list.get(i).compareTo(list.get(leftChildIndex)) > 0) {
                    swap(i, leftChildIndex);
                    i = leftChildIndex;
                } else if (list.get(i).compareTo(list.get(rightChildIndex)) > 0) {
                    swap(i, rightChildIndex);
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

    public static class PriorityQueue<T extends Thread<T>> {
        private final Heap<T> heap;

        public PriorityQueue(int capacity) {
            this.heap = new Heap<>(capacity);
        }

        public T extractThread() {
            return heap.extractMin();
        }

        public void insert(T thread) {
            heap.insert(thread);
        }

        public boolean hasThread() {
            return heap.size != 0;
        }

        public T peekMin() {
            return heap.peekMin();
        }

        public int getSize() {
            return heap.size;
        }
    }


    public static List<Long> doMain(FastScanner fs) {
        int numberOfThreads = fs.nextInt();
        int countOfJobs = fs.nextInt();

        PriorityQueue<WaitingThread> waitingThreads = new PriorityQueue<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; ++i) {
            waitingThreads.insert(new WaitingThread(i, waitingThreads.getSize() - 1));
        }
        PriorityQueue<RunningThread> runningThreads = new PriorityQueue<>(numberOfThreads);

        List<Long> response = new ArrayList<>(countOfJobs);

        for (long time = 0, i = countOfJobs; i > 0;
             time = runningThreads.hasThread() ? runningThreads.peekMin().priority : 0) {

            while (runningThreads.hasThread() && runningThreads.peekMin().priority == time) {
                RunningThread runningThread = runningThreads.extractThread();
                waitingThreads.insert(new WaitingThread(runningThread.id,
                        waitingThreads.getSize()
                ));
            }

            while (waitingThreads.hasThread() && i > 0) {
                int processingTime = fs.nextInt();
                --i;
                long threadId = waitingThreads.extractThread().id;
                runningThreads.insert(new RunningThread(threadId, time, processingTime));
                response.add(threadId);
                response.add(time);

                while (runningThreads.peekMin().priority == time) {
                    RunningThread runningThread = runningThreads.extractThread();
                    waitingThreads.insert(new WaitingThread(runningThread.id,
                            waitingThreads.getSize() - 1
                    ));
                }
            }
        }
        return response;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        doMain(fs).forEach(System.out::println);
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
