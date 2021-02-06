package Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
//Task.
// The goal in this problem is to find the minimum number of coins needed to change the input value (an integer)
// into coins with denominations 1, 5, and 10.

// Input Format.
// The input consists of a single integer 𝑚.
// Constraints.
// 1 ≤ 𝑚 ≤ 10^3.
// Output Format.
// Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.

//Sample 1.
//Input:
//2
//Output:
//2
//2 = 1 + 1.

//Sample 2.
//Input:
//28
//Output:
//6
//28 = 10 + 10 + 5 + 1 + 1 + 1.
public class Money_Changed_1 {

    private static int getMinExchange(int m) {
        int count = 0;
        while (m >= 10) {
            ++count;
            m -= 10;
        }
        while (m >= 5) {
            ++count;
            m -= 5;
        }

        count += m;
        return count;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int m = fastScanner.nextInt();
        System.out.println(getMinExchange(m));
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
