package YContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Рита и Гоша играют в игру. У каждого из них есть n фишек с написанным на них количеством очков. Сначала Гоша
// называет число k, и Рита должна выбрать две фишки, сумма очков которых равна заданному числу. Потом число
// загадывает Рита, а Гоша ищет фишки.
//
//Рите надоело искать фишки самой, и она решила применить свои навыки программирования для решения этой задачи.
// Помогите ей написать программу для поиска нужных фишек.
public class TwoChip_E {
    private static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            if (first <= second) {
                return first + " " + second;
            } else {
                return second + " " + first;
            }
        }
    }

    private static Pair findChips(HashMap<Integer, Integer> map, int k) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int diff = k - key;
            if (map.containsKey(diff)) {
                if (diff == key && value > 1) {
                    return new Pair(diff, diff);
                } else if (diff != key) {
                    return new Pair(key, diff);
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int key = fastScanner.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int k = fastScanner.nextInt();

        Pair response = findChips(map, k);
        if (response == null) {
            System.out.println("None");
        } else {
            System.out.println(response.toString());
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
