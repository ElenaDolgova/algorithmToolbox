package Coursera_1.Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LongestCommonSubsequenceOfTwoSequences_4 {

    public static int findCommonSubsequence(List<Integer> rows, List<Integer> cols) {
        List<List<Integer>> table = new ArrayList<>();

        for (int row = 0; row <= rows.size(); ++row) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            table.add(list);
        }
        List<Integer> list = table.get(0);
        for (int col = 0; col < cols.size(); ++col) {
            list.add(0);
        }

        for (int row = 1; row <= rows.size(); ++row) {
            for (int col = 1; col <= cols.size(); ++col) {
                if (cols.get(col - 1).equals(rows.get(row - 1))) {
                    table.get(row).add(table.get(row - 1).get(col - 1) + 1);
                } else {
                    table.get(row).add(
                            Math.max(table.get(row - 1).get(col), table.get(row).get(col - 1))
                    );
                }
            }
        }
        return table.get(rows.size()).get(cols.size());
    }

    public static int getLongestSubsequence(List<Integer> listInput,
                                            List<Integer> counts,
                                            List<Integer> nextInt,
                                            List<Integer> subSequence,
                                            int maxLength,
                                            int indexMax) {
        // Находим начальный элемент, для последовательнсти nextSum,
        // чтобы вывести подпоследовательность нужной нам длины - maxLength
        // так как подпоследовательностей одной длины может быть несколько (кстати, как понять сколько?)
        // то еще передается индекс с какой считать
        int currMax = 0;
        int index = 0;
        for (index = counts.size() - 1; ; --index) {
            if (index < 0) {
                return index;
            }
            currMax = counts.get(index);
            if (currMax == maxLength && index <= indexMax) {
                break;
            }
        }
        int response = index;

        for (; ; index = nextInt.get(index)) {
            subSequence.add(listInput.get(index));
            if (nextInt.get(index) == -1) {
                break;
            }
        }
        return response;
    }

    //15
    //7 2 1 3 8 4 9 1 2 6 5 9 3 8 1
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
        System.out.println(findCommonSubsequence(firstList, secondList));
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
