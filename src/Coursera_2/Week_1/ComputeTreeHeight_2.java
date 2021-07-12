package Coursera_2.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ComputeTreeHeight_2 {

    private static class Node {
        private final List<Integer> childs;

        public Node(List<Integer> childs) {
            this.childs = childs;
        }
    }

    private static class Queue {
        private final List<Node> list = new ArrayList<>();
        private int head = 0;
        private int tail = 0;

        private boolean isEmpty() {
            return head == tail;
        }

        private void push(Node elem) {
            list.add(elem);
            ++tail;
        }

        private Node pop() {
            Node node = list.get(head);
            ++head;
            return node;
        }
    }

    private static int bfs(Map<Integer, Node> tree) {
        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        queue1.push(tree.get(-1));
        int depth = 0;
        if (tree.isEmpty()) {
            return depth;
        }

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            depth = getDepth(tree, queue1, queue2, depth);
            depth = getDepth(tree, queue2, queue1, depth);
        }
        return depth;
    }

    private static int getDepth(Map<Integer, Node> tree,
                                Queue queue1,
                                Queue queue2,
                                int depth) {
        while (!queue1.isEmpty()) {
            Node node = queue1.pop();
            if (node != null) {
                node.childs.forEach(
                        child -> {
                            Node elem = tree.get(child);
                            if (elem != null) {
                                queue2.push(elem);
                            }
                        }
                );
            }
            if (queue1.isEmpty()) {
                depth++;
            }
        }
        return depth;
    }

    public static Map<Integer, Node> createTree(List<Integer> treeArray) {
        Map<Integer, Node> tree = new HashMap<>();
        for (int value = 0; value < treeArray.size(); ++value) {
            int parent = treeArray.get(value);

            Node node;
            if (tree.containsKey(parent)) {
                node = tree.get(parent);
                node.childs.add(value);
            } else {
                List<Integer> list = new ArrayList<>(2);
                list.add(value);
                node = new Node(list);
                tree.put(parent, node);
            }
        }
        return tree;
    }

    public static int doMain(List<Integer> treeArray) {
        Map<Integer, Node> tree = createTree(treeArray);
        return bfs(tree);
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner(System.in);
        final int n = fs.nextInt();
        final List<Integer> treeArray = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            treeArray.add(fs.nextInt());
        }
        System.out.println(doMain(treeArray));
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
