package Coursera_1.Week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Найти максимальное паросочетание
// на вход приходит кол-во чисел - т и неотрицательные n чисел
public class MaxPairwiseProduct2 {
    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long n = fastScanner.nextInt();
        long firstMax = 0;
        long secondMax = 0;
        while (n > 0) {
            --n;
            long current = fastScanner.nextLong();

            if (current > firstMax) {
                secondMax = firstMax;
                firstMax = current;
            } else if (current > secondMax) {
                secondMax = current;
            }
        }
        System.out.println(firstMax * secondMax);
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
