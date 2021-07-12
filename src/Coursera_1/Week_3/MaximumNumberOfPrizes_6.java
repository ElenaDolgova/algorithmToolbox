package Coursera_1.Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Task.
// The goal of this problem is to represent a given positive integer 𝑛 as a sum of as many pairwise distinct
// positive integers as possible. That is, to find the maximum 𝑘 such that 𝑛 can be written as 𝑎1+𝑎2+···+𝑎𝑘
// where𝑎1,...,𝑎𝑘 are positive integers and 𝑎𝑖 ̸=𝑎𝑗 forall1≤𝑖<𝑗≤𝑘.

//Input Format. The input consists of a single integer 𝑛.
//Constraints. 1 ≤ 𝑛 ≤ 10^9.
//Output Format. In the first line, output the maximum number 𝑘 such that 𝑛 can be represented as a sum of 𝑘
// pairwise distinct positive integers. In the second line, output 𝑘 pairwise distinct positive integers that sum up
// to 𝑛 (if there are many such representations, output any of them).
public class MaximumNumberOfPrizes_6 {

    private static TreeSet<Integer> getK(long n) {
        TreeSet<Integer> k = new TreeSet<>();
        for (int i = 1; n != 0; ++i) {
            if (n < i) {
                k.add(k.pollLast() + (int) n);
                break;
            }
            k.add(i);
            n -= i;
        }
        return k;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long n = fastScanner.nextLong();
        TreeSet<Integer> k = getK(n);
        System.out.println(k.size());
        k.forEach(p -> System.out.print(p + " "));
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
