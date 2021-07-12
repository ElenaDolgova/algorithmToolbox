package Coursera_2.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CheckBracketsInTheeCode_1 {

    private static class Stack<T> {
        private final List<T> list;
        private int currentSize;

        public Stack() {
            this.list = new ArrayList<>();
        }

        public void push(T item) {
            if (item == null) {
                throw new RuntimeException("There is no space");
            }
            ++this.currentSize;
            this.list.add(item);
        }

        public T top() {
            if (currentSize == 0) {
                throw new RuntimeException("Stack is empty");
            }
            return this.list.get(currentSize - 1);
        }

        public T pop() {
            if (currentSize == 0) {
                throw new RuntimeException("Stack is empty");
            }
            --currentSize;
            return this.list.remove(this.currentSize);
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }
    }

    private static boolean isOneType(char closedBracket, String openBracket) {
        switch (closedBracket) {
            case '}': {
                return openBracket.equals("{");
            }
            case ']': {
                return openBracket.equals("[");
            }
            case ')': {
                return openBracket.equals("(");
            }
            default: {
                return false;
            }
        }
    }

    private static boolean isClosedBracket(char ch) {
        return ch == ']' || ch == '}' || ch == ')';
    }

    public static int isGood(String input) {
        final Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); ++i) {
            final char curChar = input.charAt(i);
            if (curChar == '[' || curChar == '{' || curChar == '(') {
                stack.push(String.valueOf(curChar));
                stack.push(String.valueOf(i + 1));
            } else if (isClosedBracket(curChar)) {
                if (stack.isEmpty()) {
                    return i + 1;
                }
                int curOtherSymbolLength = Integer.parseInt(stack.pop());
                String openBracket = stack.pop();
                if (!isOneType(curChar, openBracket)) {
                    return i
                            + 1; // за закрытую скобку;
                }
            }
        }
        if (stack.isEmpty()) {
            return -1;
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        final FastScanner fastScanner = new FastScanner(System.in);
        String str = fastScanner.next();
        int good = isGood(str);
        if (good == -1) {
            System.out.println("Success");
        } else {
            System.out.println(good);
        }
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
