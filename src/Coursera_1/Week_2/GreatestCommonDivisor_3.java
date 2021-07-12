package Coursera_1.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Task. Given two integers 𝑎 and 𝑏, find their greatest common divisor.
//Input Format. The two integers 𝑎, 𝑏 are given in the same line separated by space. Constraints. 1≤𝑎,𝑏≤2·109.
//Output Format. Output GCD(𝑎, 𝑏).

//Sample 1.
//Input:
//18 35
//Output:
//1
//18 and 35 do not have common non-trivial divisors.

//Sample 2.
//Input:
//28851538 1183019
//Output:
//17657
//28851538 = 17657 · 1634, 1183019 = 17657 · 67.

public class GreatestCommonDivisor_3 {

    private static long gcd(long a, long b) {
        long r = Math.min(a, b);
        long max = Math.max(a, b);
        while (r != 0) {
            long prevMin = r;
            r = max % r;
            max = prevMin;
        }
        return max;
    }

    public static void main(String[] args) {
       FastScanner fastScanner = new FastScanner(System.in);
        long a = fastScanner.nextLong();
        long b = fastScanner.nextLong();
        System.out.println(gcd(a, b));
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
