package Coursera_1.Week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

//Task.
// The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
//Input Format.
// The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack. The
// next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the value
// and the weight of 𝑖-th item, respectively.
//Constraints. 1≤𝑛≤10^3,0≤𝑊 ≤2·10^6;0≤𝑣𝑖 ≤2·10^6,0<𝑤𝑖 ≤2·10^6 for all 1 ≤𝑖 ≤𝑛.All the numbers are integers.
//Output Format.
// Output the maximal value of fractions of items that fit into the knapsack. The absolute value of the
// difference between the answer of your program and the optimal value should be at most 10^−3. To ensure this, output
// your answer with at least four digits after the decimal point (otherwise your answer, while being computed
// correctly, can turn out to be wrong because of rounding issues).
//Sample 1.
//Input:
// 3 50 (number of items, capacity of a knapsack)
// 60 20
// 100 50
// 120 30
//Output:
//180.0000
//To achieve the value 180, we take the first item and the third item into the bag.

//Sample 2.
//Input:
//  1 10
//  500 30
//Output:
//166.6667
//Here, we just take one third of the only available item.
public class MaximumValueOfTheLoot_2 {

    private static class Value implements Comparable<Value> {
        private final double value;
        private final double weight;
        private final double cost;

        private Value(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.cost = value / weight;
        }

        public double getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public int compareTo(Value o) {
            if (o.getCost() < this.getCost()) {
                return -1;
            } else if (o.getCost() > this.getCost()) {
                return 1;
            }
            return 0;
        }
    }

    private static double getMaxFractionalKnapsackProblem(int n, double W, TreeSet<Value> values) {
        double totalCost = 0;
        while (W > 0 && !values.isEmpty()) {
            Value value = values.first();
            if (value.getWeight() <= W) {
                totalCost += value.getValue();
                W -= value.getWeight();
                values.pollFirst();
            } else {
                totalCost += value.getCost() * W;
                W = 0;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        double W = fastScanner.nextInt();
        TreeSet<Value> values = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            int v = fastScanner.nextInt();
            int w = fastScanner.nextInt();
            values.add(new Value(v, w));
        }
        System.out.println(getMaxFractionalKnapsackProblem(n, W, values));
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
