package Coursera_1.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Task.
// Given two integers π and π, output πΉπ mod π (that is, the remainder of πΉπ when divided by π).
// Input Format.
// The input consists of two integers π and π given on the same line (separated by a space).
// Constraints.
// 1β€πβ€10^14,2β€πβ€10^3.
// Output Format.
// Output πΉπ mod π.

//Sample 1.
//Input:
//239 1000
//Output:
//161
//πΉ239 mod 1000 = 39679027332006820581608740953902289877834488152161 (mod 1000) = 161.

//Sample 2.
//Input:
//2816213588 239
//Output:
//151 // Π½Π° 48 ΠΌΠ΅ΡΡΠ΅
//πΉ2 816 213 588 does not fit into one page of this file, but πΉ2 816 213 588 mod 239 = 151.

//Input: N = 438, M = 900
//Output: 44

//Input: N = 1548276540, M = 235
//Output: 185
public class FibonacciNumberAgain_5 {

    private static long lastFibNumberByM(long n, long m) {
        List<Long> pisano = new ArrayList<>();
        pisano.add(0L);
        pisano.add(1L);
        int i;
        for (i = 2; i <= n; ++i) {
            long e = (pisano.get(i - 1) + pisano.get(i - 2)) % m;
            pisano.add(e);
            if (pisano.get(i - 1) == 0 && pisano.get(i - 2) == 1) {
                break;
            }
        }

        long pisanoPeriod;
        if (pisano.get(i - 1) == 0 && pisano.get(i - 2) == 1) {
            pisanoPeriod = n % (pisano.size() - 2);
        } else {
            pisanoPeriod = n % (pisano.size());
        }

        return pisano.get((int) pisanoPeriod);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long n = fastScanner.nextLong();
        long m = fastScanner.nextLong();
        System.out.println(lastFibNumberByM(n, m));
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
