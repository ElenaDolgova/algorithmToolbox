package Coursera_1.Week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MajorityElement_2 {
    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int k = fastScanner.nextInt();
            hashMap.put(k, hashMap.getOrDefault(k, 0) + 1);
        }
        int potentialKey = hashMap.entrySet().stream().max((o, o1) -> {
            if (o.getValue() > o1.getValue()) {
                return 1;
            } else if (o.getValue() < o1.getValue()) {
                return -1;
            }
            return 0;
        }).get().getKey();
        if (hashMap.get(potentialKey) > n / 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
