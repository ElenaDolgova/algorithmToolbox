package Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LongestCommonSubsequenceOfThreeSequences_5 {

    public static void findCommonSubsequence(List<Integer> rows, List<Integer> cols,
                                             List<Integer> cols1) {
        int[][][] table = new int[rows.size() + 1][cols.size() + 1][cols1.size() + 1];
        for (int row = 0; row <= rows.size(); ++row) {
            for (int col = 0; col <= cols.size(); ++col) {
                for (int col1 = 0; col1 <= cols1.size(); ++col1) {

                    if (row == 0 || col == 0 || col1 == 0) {
                        table[row][col][col1] = 0;
                    } else if (cols.get(col - 1).equals(rows.get(row - 1)) &&
                            cols.get(col - 1).equals(cols1.get(col1 - 1))) {
                        table[row][col][col1] = table[row - 1][col - 1][col1 - 1] + 1;
                    } else {
                        int firstMax = Math.max(
                                table[row - 1][col][col1],
                                table[row][col - 1][col1]);
                        int secondMax = Math.max(
                                firstMax,
                                table[row][col][col1 - 1]);
                        table[row][col][col1] = secondMax;
                    }
                }
            }
        }
        int max = table[rows.size()][cols.size()][cols1.size()];
        System.out.println(max);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        List<Integer> firstList = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            firstList.add(fastScanner.nextInt());
        }
        int m = fastScanner.nextInt();
        List<Integer> secondList = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            secondList.add(fastScanner.nextInt());
        }
        int l = fastScanner.nextInt();
        List<Integer> thirdList = new ArrayList<>(l);
        for (int i = 0; i < l; ++i) {
            thirdList.add(fastScanner.nextInt());
        }

        findCommonSubsequence(firstList, secondList, thirdList);
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
