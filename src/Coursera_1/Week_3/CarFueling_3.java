package Coursera_1.Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Input Format.
// The first line contains an integer π. The second line contains an integer π. The third line
// specifies an integer π. Finally, the last line contains integers stop1, stop2, . . . , stopπ.
//Output Format. Assuming that the distance between the cities is π miles, a car can travel at most π miles on a
// full tank, and there are gas stations at distances stop1 , stop2 , . . . , stopπ along the way, output the
// minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to reach the
// destination, output β1.
//Constraints. 1β€πβ€10^5.1β€πβ€400.1β€πβ€300.0<stop1 <stop2 <Β·Β·Β·<stopπ <π.
// Output Format.
// Assuming that the distance between the cities is π miles,
// a car can travel at most π miles on a full tank,
// and there are gas stations at distances stop1 , stop2 , . . . , stopπ
// along the way, output the minimum number of refills needed.
// Assume that the car starts with a full tank. If it is not possible to reach the destination, output β1.
public class CarFueling_3 {

    private static int getMinStopsCount(final int d, final int m, List<Integer> stops) {
        if (stops.isEmpty() && d > m) {
            return -1;
        } else if (stops.isEmpty()) {
            return 0;
        }

        if (stops.get(0) > m) {
            return -1;
        }
        int count = 0;
        int currentM = m;

        List<Integer> diffStops = new ArrayList<>();
        int stop = 0;
        for (int i = 0; i < stops.size(); ++i) {
            diffStops.add(stops.get(i) - stop);
            stop = stops.get(i);
        }
        diffStops.add(d-stops.get(stops.size()-1));

        for (int i = 0; i < diffStops.size(); ++i) {
            int currentStop = diffStops.get(i);
            if (currentStop <= currentM) {
            } else {
                // Π½Π° ΠΏΡΠΎΡΠ»ΠΎΠΉ ΡΡΠΎΡΠ½ΠΊΠ΅ Π·Π°ΠΏΡΠ°Π²ΠΈΠ»ΠΈΡΡ
                ++count;
                currentM = m;
            }
            currentM -= currentStop;
            if (currentM < 0) {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int d = fastScanner.nextInt();
        int m = fastScanner.nextInt();
        int n = fastScanner.nextInt();
        List<Integer> stops = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            stops.add(fastScanner.nextInt());
        }

        System.out.println(getMinStopsCount(d, m, stops));
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
