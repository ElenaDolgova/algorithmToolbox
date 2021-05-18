package YContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindId_C {

    public static int sumOfArithmeticProgression(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        boolean[] students = new boolean[n + 1];
        for (int i = 0; i < n - 2; ++i) {
            int student = fastScanner.nextInt();
            students[student] = true;
        }

        List<Integer> missing = new ArrayList<>(2);
        for (int i = 1; i < n + 1; ++i) {
            if (!students[i]) {
                missing.add(i);
            }
        }

        System.out.println(missing.get(0) + " " + missing.get(1));
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
