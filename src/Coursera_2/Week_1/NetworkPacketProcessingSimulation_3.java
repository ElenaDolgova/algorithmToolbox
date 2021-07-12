package Coursera_2.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NetworkPacketProcessingSimulation_3 {

    public static class Packet {
        private final int timeArrived;
        private final int processingTime;
        private final int number;

        public Packet(int timeArrived, int processingTime, int number) {
            this.timeArrived = timeArrived;
            this.processingTime = processingTime;
            this.number = number;
        }
    }

    public static class Queue<T> {
        private final List<T> list;
        private int head = -1;
        private int tail = -1;
        private int size = 0;
        private final int capacity;

        public Queue(int n) {
            list = new ArrayList<>(n);
            capacity = n;
            for (int i = 0; i < n; ++i) {
                list.add(null);
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isNotFull() {
            return size != capacity;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean push(T elem) {
            if (size == capacity) {
                return false;
            }
            if (tail == capacity - 1) {
                tail = 0;
                list.set(tail, elem);
            } else {
                list.set(++tail, elem);
                if (head == -1) {
                    head = 0;
                }
            }
            ++size;
            return true;
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            }
            --size;
            if (head == capacity - 1) {
                T node = list.get(head);
                head = 0;
                return node;
            }
            T node = list.get(head);
            ++head;
            return node;
        }

        public T pick() {
            if (isEmpty()) {
                return null;
            }

            if (head == capacity) {
                return list.get(0);
            }
            return list.get(head);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        doMain(fs).forEach(System.out::println);
    }


    public static List<Integer> doMain(FastScanner fs) {
        int bufferSize = fs.nextInt();
        int n = fs.nextInt();
        Queue<Packet> queue = new Queue<>(bufferSize);
        return extracted(fs, n, queue);
    }

    private static List<Integer> extracted(FastScanner fs,
                                           int n,
                                           Queue<Packet> queue) {
        List<Integer> response = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            response.add(-1);
        }

        int curTime = 0;
        for (int i = 0; i < n; ++i) {
            Packet packet = fs.nextPacket(i);
            if (curTime <= packet.timeArrived) {
                if (queue.isFull()) {
                    while (!queue.isEmpty()) {
                        curTime = getCurTime(queue, curTime, response);
                        while (packet.timeArrived < curTime) {
                            if (i != n - 1) {
                                ++i;
                                packet = fs.nextPacket(i);
                            } else {
                                break;
                            }
                        }
                        if (i == n - 1) {
                            break;
                        }
                        pushPacketInQueue(queue, packet, curTime);
                    }
                }
                pushPacketInQueue(queue, packet, curTime);
            }
        }
        while (!queue.isEmpty()) {
            curTime = getCurTime(queue, curTime, response);
        }
        return response;
    }

    private static void pushPacketInQueue(Queue<Packet> queue, Packet packet, int curTime) {
        if (packet.timeArrived >= curTime) {
            queue.push(packet);
        }
    }

    private static int getCurTime(Queue<Packet> queue,
                                  int curTime,
                                  List<Integer> response) {
        Packet p = queue.pop();
        if (curTime < p.timeArrived) {
            curTime = p.timeArrived;
        }
        response.set(p.number, curTime);
        curTime += p.processingTime;
        return curTime;
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

        Packet nextPacket(int number) {
            return new Packet(nextInt(), nextInt(), number);
        }
    }
}
