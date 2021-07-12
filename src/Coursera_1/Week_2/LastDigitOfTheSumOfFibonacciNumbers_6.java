package Coursera_1.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Task. Given an integer 𝑛, find the last digit of the sum 𝐹0 +𝐹1 +···+𝐹𝑛. Input Format. The input consists of a
// single integer 𝑛.
//Constraints. 0 ≤ 𝑛 ≤ 10^14.
//Output Format. Output the last digit of 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.

//Sample 1.
//Input:
//3
//Output:
//4
//𝐹0 +𝐹1 +𝐹2 +𝐹3 =0+1+1+2=4.

//Sample 2.
//Input:
//100
//Output:
//5
//The sum is equal to 927 372 692 193 078 999 175, the last digit is 5.

// 832564823476 - 3
public class LastDigitOfTheSumOfFibonacciNumbers_6 {

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
            return pisano;
        } else {
            return pisano;
        }
    }

    private static long fib(long n) {
        if (n == 0) {
            return 0;
        }
        long first = 0L;
        long second = 1L;
        long sum = first + second;

        for (int i = 2; i <= n; ++i) {
            long l = second;
            second = (first + second) % 10;
            sum = (sum + second) % 10;
            first = l;
        }
        return sum;
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
