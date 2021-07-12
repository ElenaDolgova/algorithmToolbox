package Coursera_1.Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Problem Description
//  Input Format. Integer money.
//  Output Format.
//  The minimum number of coins with denominations 1, 3, 4 that changes money.
//  Constraints. 1 ≤ money ≤ 10^3.
public class MoneyChangeAgain_1 {

    private static int minNumberCoins(int money,
                                      List<Integer> denominations) {
        switch (money) {
            case 0: {
                return 0;
            }
            case 1:
            case 3:
            case 4: {
                return 1;
            }
            case 2: {
                return 2;
            }
            default: {
                return Math.min(Math.min(denominations.get(money - 1) + 1, denominations.get(money - 3) + 1),
                        denominations.get(money - 4) + 1);
            }
        }
    }

    // 1 3 4
    private static int numberOfDenominations(int money) {
        List<Integer> denominations = new ArrayList<>(money + 1);
        for (int i = 0; i < money + 1; ++i) {
            denominations.add(minNumberCoins(i, denominations));
        }
        return denominations.get(money);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        System.out.println(numberOfDenominations(n));
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
