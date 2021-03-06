package Coursera_1.Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Task.
// The goal of this problem is to represent a given positive integer π as a sum of as many pairwise distinct
// positive integers as possible. That is, to find the maximum π such that π can be written as π1+π2+Β·Β·Β·+ππ
// whereπ1,...,ππ are positive integers and ππ ΜΈ=ππ forall1β€π<πβ€π.

//Input Format. The input consists of a single integer π.
//Constraints. 1 β€ π β€ 10^9.
//Output Format. In the first line, output the maximum number π such that π can be represented as a sum of π
// pairwise distinct positive integers. In the second line, output π pairwise distinct positive integers that sum up
// to π (if there are many such representations, output any of them).
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
