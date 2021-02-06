package Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


//Task.
// Given two sequences 𝑎1,𝑎2,...,𝑎𝑛 (𝑎𝑖 is the profit per click of the 𝑖-th ad) and 𝑏1,𝑏2,...,𝑏𝑛
// (𝑏𝑖 is the average number of clicks per day of the 𝑖-th slot), we need to partition them into
// 𝑛 pairs (𝑎𝑖, 𝑏𝑗) such that the sum of their products is maximized.
//Input Format.
// The first line contains an integer 𝑛, the second one contains a sequence of integers 𝑎1,𝑎2,...,
// 𝑎𝑛, the third one contains a sequence of integers 𝑏1,𝑏2,...,𝑏𝑛.
//Constraints. 1≤𝑛≤10^3;−10^5 ≤𝑎𝑖,𝑏𝑖 ≤10^5 for all 1≤𝑖≤𝑛.
//Output Format.
// Output the maximum value of ∑︀ 𝑎𝑖𝑐𝑖, where 𝑐1, 𝑐2, . . . , 𝑐𝑛 is a permutation of
// 𝑏1,𝑏2,...,𝑏𝑛.
public class MaximumAdvertisementRevenue_4 {

    private static long getMaxPermutation(int n,
                                          TreeMap<Integer, Integer> as,
                                          TreeMap<Integer, Integer> bs) {
        long sum = 0;
        while (n > 0) {
            int a = as.firstKey();
            as.put(a, as.get(a) - 1);
            int b = bs.firstKey();
            bs.put(b, bs.get(b) - 1);
            sum += (long) a * b;

            if (as.firstEntry().getValue() == 0) {
                as.pollFirstEntry();
            }
            if (bs.firstEntry().getValue() == 0) {
                bs.pollFirstEntry();
            }

            --n;
        }
        return sum;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        TreeMap<Integer, Integer> as = new TreeMap<>();
        TreeMap<Integer, Integer> bs = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            int key = fastScanner.nextInt();
            int value = as.getOrDefault(key, 0) + 1;
            as.put(key, value);
        }

        for (int i = 0; i < n; ++i) {
            int key = fastScanner.nextInt();
            int value = bs.getOrDefault(key, 0) + 1;
            bs.put(key, value);
        }

        System.out.println(getMaxPermutation(n, as, bs));
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
