package YContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Сipher_D {
    private static class Index {
        private int row;
        private int col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int printHorse(List<List<Integer>> matrix, int length,
                                  Index index, int increase) {
        int row = index.row;
        int col = index.col;
        int count = length;
        while (count > 0) {
            row = row + increase;
            System.out.println(matrix.get(row).get(col));
            --count;
        }
        increase = -1 * increase;
        count = length;
        while (count > 0) {
            col = col + increase;
            System.out.println(matrix.get(row).get(col));
            --count;
        }
        index.row = row;
        index.col = col;
        return increase;
    }

    // разделили матрицу на буквы Г с одинаковой длиной обоих палок буквы Г
    private static void spiralMatrixPromt(List<List<Integer>> matrix) {
        int countOfHorse = matrix.size() - 2;
        int start = matrix.size() / 2;
        int increase = 1;

        System.out.println(matrix.get(start).get(start));
        if (matrix.size() == 1) {
            return;
        }
        System.out.println(matrix.get(start - 1).get(start));
        System.out.println(matrix.get(start - 1).get(start + 1));
        Index index = new Index(start - 1, start + 1);
        int length = 2;
        while (countOfHorse > 0) {
            increase = printHorse(matrix, length, index, increase);
            ++length;
            --countOfHorse;
        }

        while (length > 1) {
            index.row = index.row + increase;
            System.out.println(matrix.get(index.row).get(index.col));
            --length;
        }
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int m = fastScanner.nextInt(); // нечетное

        List<List<Integer>> matrix = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            List<Integer> row = new ArrayList<>(m);
            matrix.add(row);
            for (int j = 0; j < m; ++j) {
                row.add(fastScanner.nextInt());
            }
        }
        spiralMatrixPromt(matrix);
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
