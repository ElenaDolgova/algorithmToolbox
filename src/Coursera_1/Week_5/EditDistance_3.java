package Coursera_1.Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//The edit distance between two strings is the minimum number of operations (insertions, deletions, and substitutions
// of symbols) to transform one string into another. It is a measure of similarity of two strings. Edit distance has
// applications, for example, in computational biology, natural language processing, and spell checking. Your goal in
// this problem is to compute the edit distance between two strings.
public class EditDistance_3 {

    private static int findEditDistance(String firstStr, String secondStr) {
        List<List<Integer>> distances = new ArrayList<>(secondStr.length() + 1);
        for (int row = 0; row <= secondStr.length(); ++row) {
            distances.add(new ArrayList<>(firstStr.length() + 1));
            distances.get(row).add(row);
        }
        for (int col = 1; col <= firstStr.length(); ++col) {
            distances.get(0).add(col);
        }

        for (int row = 1; row <= secondStr.length(); ++row) {
            for (int col = 1; col <= firstStr.length(); ++col) {
                int insertion = distances.get(row - 1).get(col) + 1;
                int deletion = distances.get(row).get(col - 1) + 1;
                int min = Math.min(insertion, deletion);
                int diff = firstStr.charAt(col - 1) == secondStr.charAt(row - 1) ? 0 : 1;
                int mis_match = distances.get(row - 1).get(col - 1) + diff;
                distances.get(row).add(Math.min(min, mis_match));
            }
        }
        return distances.get(secondStr.length()).get(firstStr.length());

    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        String firstStr = fastScanner.next();
        String secondStr = fastScanner.next();
        System.out.println(findEditDistance(firstStr, secondStr));
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
