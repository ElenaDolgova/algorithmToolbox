package YContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindId_C {

    public static int sumOfArithmeticProgression(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        int[] students = new int[n + 1];
        for (int i = 0; i < n - 2; ++i) {
            int student = fastScanner.nextInt();
            students[student] = 1;
        }
        int firstStudent = 0;
        int secondStudent = 0;
        for (int i = 1; i < n + 1; ++i) {
            if (students[i] == 0 && firstStudent == 0) {
                firstStudent = i;
            }
            if (students[i] == 0 && firstStudent != 0) {
                secondStudent = i;
            }
        }

        if (firstStudent < secondStudent) {
            System.out.println(firstStudent + " " + secondStudent);
        } else {
            System.out.println(secondStudent + " " + firstStudent);
        }
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
