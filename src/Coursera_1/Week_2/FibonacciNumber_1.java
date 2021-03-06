package Coursera_1.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Task. Given an integer π, find the πth Fibonacci number πΉπ.
//Input Format. The input consists of a single integer π.
//Constraints. 0 β€ π β€ 45.
//Output Format. Output πΉπ.
//
//Sample 1.
//Input:
//10
//Output:
//55
//πΉ10 = 55.
public class FibonacciNumber_1 {
    private static long fib(int n) {
        long first = 0L;
        long second = 1L;

        for (int i = 2; i <= n; ++i) {
            long l = second;
            second = first + second;
            first = l;
        }
        return second;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        System.out.println(fib(n));
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
