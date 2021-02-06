package YContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeNumber_B {

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        String number = fastScanner.next();
        boolean isNegative = false;
        if (number.charAt(0) == '-') {
            isNegative = true;
        }
        int start = 0;
        if (isNegative) {
            System.out.print("-");
            start = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = number.length() - 1; i >= start; --i) {
            stringBuilder.append(number.charAt(i));
        }
        int numberInt = Integer.parseInt(stringBuilder.toString());
        System.out.print(numberInt);
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
