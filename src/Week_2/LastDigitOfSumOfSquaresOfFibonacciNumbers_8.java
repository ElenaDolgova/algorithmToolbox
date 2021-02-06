package Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Task.
// Compute the last digit of 𝐹0 ^ 2 +𝐹1 ^2 +···+𝐹𝑛 ^ 2.
// Input Format.
// Integer 𝑛.
// Constraints.
// 0 ≤ 𝑛 ≤ 1014.
//Output Format.
// The last digit of 𝐹0^2 + 𝐹1^2 + · · · + 𝐹𝑛^2.

//Sample 1.
//Input:
//7
//Output:
//3
//𝐹0^2 +𝐹1^2 +···+𝐹7^2 =0+1+1+4+9+25+64+169=273.

//Sample 2.
//Input:
//73
//Output:
//1
//𝐹2 +···+𝐹2 =1052478208141359608061842155201. 0 73

//Sample 3.
//Input:
//1234567890
//Output:
//0
public class LastDigitOfSumOfSquaresOfFibonacciNumbers_8 {
    private static List<Long> getPisano(long n, long m) {
        List<Long> pisano = new ArrayList<>();
        pisano.add(0L);
        pisano.add(1L);
        int i;
        for (i = 2; i <= n; ++i) {
            long e = (pisano.get(i - 1) + pisano.get(i - 2)) % m;
            pisano.add(e);
            if (pisano.get(i - 1) == 0 && pisano.get(i - 2) == 1) {
                break;
            }
        }

        if (pisano.get(i - 1) == 0 && pisano.get(i - 2) == 1) {
            pisano.remove(i - 1);
            pisano.remove(i - 1);
        }

        List<Long> pisanoSquare = new ArrayList<>();
        for (int k = 0; k < pisano.size(); ++k) {
            pisanoSquare.add(pisano.get(k) * pisano.get(k));
        }
        return pisanoSquare;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long n = fastScanner.nextLong();
        List<Long> pisano = getPisano(n, 10);

        long countOfSums = n / pisano.size();
        long r = n % pisano.size();

        long sumOfOne = 0; // сумма одного периода Пизано
        for (int i = 0; i < pisano.size(); ++i) {
            sumOfOne = (sumOfOne + pisano.get(i)) % 10;
        }
        sumOfOne = (sumOfOne * countOfSums) % 10;

        for (int i = 0; i <= r; ++i) {
            sumOfOne = (sumOfOne + pisano.get(i)) % 10;
        }
        System.out.println(sumOfOne);
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
