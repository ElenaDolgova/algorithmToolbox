package Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Task. Given two integers 𝑎 and 𝑏, find their least common multiple.
//Input Format. The two integers 𝑎 and 𝑏 are given in the same line separated by space. Constraints. 1 ≤ 𝑎, 𝑏 ≤
// 107 .
//Output Format. Output the least common multiple of 𝑎 and 𝑏.

//Sample 1.
//Input:
//6 8
//Output:
//24
//Among all the positive integers that are divisible by both 6 and 8 (e.g., 48, 480, 24), 24 is the smallest one.

//Sample 2.
//Input:
//761457 614573
//Output:
//467970912861

//Sample 3.
//Input:
//100 75
//Output:
//25*4*3
public class LeastCommonMultiple_4 {

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

    private static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return a * b/gcd;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long a = fastScanner.nextLong();
        long b = fastScanner.nextLong();
        System.out.println(lcm(a, b));
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
