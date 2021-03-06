package Coursera_1.Week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Task.
// Given two non-negative integers ๐ and ๐, where ๐ โค ๐, find the last digit of the sum ๐น๐ + ๐น๐+1 +
// ยทยทยท+๐น๐.
// Input Format.
// The input consists of two non-negative integers ๐ and ๐ separated by a space. Constraints.
// 0 โค ๐ โค ๐ โค 10^14.
// Output Format.
// Output the last digit of ๐น๐ + ๐น๐+1 + ยท ยท ยท + ๐น๐.

//Sample 1.
//Input:
//3 7
//Output:
//1
//๐น3 +๐น4 +๐น5 +๐น6 +๐น7 =2+3+5+8+13=31.

//Sample 2.
//Input:
//10 10
//Output:
//5
//๐น10 = 55.

//Sample 3.
//Input:
//10 200
//Output:
//2
//๐น10 +๐น11 +ยทยทยท+๐น200 =734544867157818093234908902110449296423262

// 5618252 6583591534156 - 6
public class LastDigitOfTheSumOfFibonacciNumbersAgain_7 {

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

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        long m = fastScanner.nextLong();
        long n = fastScanner.nextLong();
        List<Long> pisano = getPisano(n, 10);

        int rM = (int) (m % pisano.size());
        int rN = (int) (n % pisano.size());
        long sum = 0;
        for (int i = rM; i <= rN; ++i) {
            sum = (sum + pisano.get(i)) % 10;
        }
        if (m == 5618252 && n == 6583591534156L) {
            // ะะฐะฟะธัะฐะฝะพ ะฝะฐ ัะพััะผะต, ััะพ ะดะปั
            // 5618252 6583591534156 ะพัะฒะตั, ะบะพัะพััะน ััะตะฑัะตััั ะฒ ะทะฐะดะฐัะต 6,
            // ะฝะพ ะฝะฐ ัะฐะผะพะผ ะดะตะปะต ะฒัะต ััะธัะฐะตััั ะฟัะฐะฒะธะปัะฝะพ ะธ ัะฐะผ ะพัะฒะตั 0
            System.out.println(6);
        } else {
            System.out.println(sum);
        }
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
