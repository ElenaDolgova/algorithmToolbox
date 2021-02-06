package Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Task. Given an integer 𝑛, find the last digit of the 𝑛th Fibonacci number 𝐹𝑛 (that is, 𝐹𝑛 mod 10). Input
// Format. The input consists of a single integer 𝑛.
//Constraints. 0 ≤ 𝑛 ≤ 107.
//Output Format. Output the last digit of 𝐹𝑛.

//Sample 1.
//Input:
//3
//Output:
//2
//𝐹3 = 2.

//Sample 2.
//Input:
//331
//Output:
//9
//𝐹331 =668996615388005031531000081241745415306766517246774551964595292186469.

//Sample 3.
//Input:
//327305
//Output:
//5
//𝐹327305 does not fit into one line of this pdf, but its last digit is equal to 5.
public class LastDigitOfLargeFibonacciNumber_2 {

    private static int lastFibNumber(int n) {
        List<Integer> array = new ArrayList<>(n);
        array.add(0);
        array.add(1);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(5);
        array.add(8);
        array.add(3); //13
        array.add(1); //21

        for (int i = 9; i <= n; ++i) {
            array.add((array.get(i - 1) + array.get(i - 2)) % 10);
        }
        return array.get(n);
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        System.out.println(lastFibNumber(n));
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
