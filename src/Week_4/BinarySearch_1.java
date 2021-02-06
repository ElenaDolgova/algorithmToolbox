package Week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BinarySearch_1 {

    // уже отсортированная коллекция
    private static int binarySearch(List<Integer> as, int whatSearch,
                                    int low, int high) {
        int mid = low + (high - low) / 2; // округление вниз и так

        if (as.get(mid) == whatSearch) {
            return mid;
        }

        if (mid == as.size() - 1 || (low == high && as.get(mid) != whatSearch)) {
            return -1;
        }

        if (as.get(mid) > whatSearch) {
            return binarySearch(as, whatSearch, low, mid);
        } else {
            return binarySearch(as, whatSearch, mid + 1, high);
        }
    }

    private static List<Integer> binarySearch(List<Integer> as,
                                              List<Integer> bs) {
        Collections.sort(as);
        return bs.stream().map(p -> binarySearch(as, p, 0, as.size() - 1)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        ArrayList<Integer> as = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            as.add(fastScanner.nextInt());
        }

        int k = fastScanner.nextInt();
        ArrayList<Integer> bs = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            bs.add(fastScanner.nextInt());
        }
        binarySearch(as, bs).forEach(p -> System.out.print(p + " "));
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
