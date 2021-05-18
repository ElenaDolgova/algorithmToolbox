package Week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//You are given a set of bars of gold
// and your goal is to take as much gold as possible into your bag.
// There is just one copy of each bar and for each bar you can either
// take it or not (hence you cannot take a fraction of a bar).
public class MaximumAmountOfGold_1 {

    private static long findMaxCost(int W, List<Integer> weights) {
        List<List<Long>> matrix = new ArrayList<>(W + 1);

        for (int i = 0; i < weights.size() + 1; ++i) {
            ArrayList<Long> e = new ArrayList<>(W + 1);
            e.add(0L);
            matrix.add(e);
        }
        List<Long> zeroRow = matrix.get(0);

        for (int i = 0; i < W; ++i) {
            zeroRow.add(0L);
        }


        for (int row = 1; row < weights.size() + 1; ++row) {
            int currWeight = weights.get(row - 1);
            for (int col = 1; col < W + 1; ++col) {
                long withoutCurrentWeight = matrix.get(row - 1).get(col);
                int index = col - currWeight;
                long tryWithCurrentWeight = 0;
                if (index >= 0) {
                    tryWithCurrentWeight = matrix.get(row - 1).get(index) + currWeight;
                }
                long max = Math.max(withoutCurrentWeight, tryWithCurrentWeight);
                matrix.get(row).add(max);
            }
        }
        return matrix.get(weights.size()).get(W);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int W = fs.nextInt();
        int n = fs.nextInt();
        List<Integer> weights = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            weights.add(fs.nextInt());
        }
        System.out.println(findMaxCost(W, weights));
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
