package Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//You are given a primitive calculator that can perform the following three operations with the current number 𝑥:
// multiply 𝑥 by 2, multiply 𝑥 by 3, or add 1 to 𝑥. Your goal is given a positive integer 𝑛, find the minimum
// number of operations needed to obtain the number 𝑛 starting from the number 1.
public class PrimitiveCalculator_2 {

    private static void findMin(int i, List<Integer> countOfSteps, List<Integer> mins) {
        int count = countOfSteps.get(i) + 1;
        if (i % 3 == 0 && countOfSteps.get(i / 3) > count) {
            countOfSteps.set(i / 3, count);
            mins.set(i / 3, i);
        }
        if (i % 2 == 0 && countOfSteps.get(i / 2) > count) {
            countOfSteps.set(i / 2, count);
            mins.set(i / 2, i);
        }
        if (countOfSteps.get(i - 1) > count) {
            countOfSteps.set(i - 1, count);
            mins.set(i - 1, i);
        }
    }

    private static void findNumbers(int n) {
        List<Integer> countOfSteps = new ArrayList<>(n + 1);
        List<Integer> mins = new ArrayList<>(n + 1);
        for (int i = 0; i < n; ++i) {
            countOfSteps.add(Integer.MAX_VALUE);
            mins.add(0);
        }
        countOfSteps.add(0);
        mins.add(0);
        for (int i = n; i >= 1; --i) {
            findMin(i, countOfSteps, mins);
        }
        System.out.println(countOfSteps.get(0) - 1);
        for (int i = 1; i != 0; i = mins.get(i)) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        findNumbers(n);
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
