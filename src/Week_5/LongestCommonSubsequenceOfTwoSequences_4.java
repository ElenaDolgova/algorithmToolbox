package Week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LongestCommonSubsequenceOfTwoSequences_4 {

    public static int findLongestSubsequence(List<Integer> listInput,
                                             List<Integer> counts,
                                             List<List<Integer>> nextInt) {
        int currentMax = 1;
        for (int i = 0; i < listInput.size(); ++i) {
            List<Integer> listOfAllNext = new ArrayList<>();
            nextInt.add(listOfAllNext);
            listOfAllNext.add(-1);
            counts.add(1);
            for (int j = 0; j < i; ++j) {
                int newCount = counts.get(j) + 1;
                if (listInput.get(i) > listInput.get(j) && newCount > counts.get(i)) {
                    counts.set(i, newCount);
                    currentMax = Math.max(currentMax, newCount);
                }
            }
            for (int j = i - 1; j >= 0; --j) {
                if (listInput.get(i) > listInput.get(j) && counts.get(i) - counts.get(j) == 1) {
                    if (listOfAllNext.get(0) == -1) {
                        listOfAllNext.set(0, j);
                    } else {
                        listOfAllNext.add(j);
                    }
                }
            }
        }
        return currentMax;
    }

    public static int getLongestSubsequence(List<Integer> listInput,
                                            List<Integer> counts,
                                            List<Integer> nextInt,
                                            List<Integer> subSequence,
                                            int maxLength,
                                            int indexMax) {
        // Находим начальный элемент, для последовательнсти nextSum,
        // чтобы вывести подпоследовательность нужной нам длины - maxLength
        // так как подпоследовательностей одной длины может быть несколько (кстати, как понять сколько?)
        // то еще передается индекс с какой считать
        int currMax = 0;
        int index = 0;
        for (index = counts.size() - 1; ; --index) {
            if (index < 0) {
                break;
            }
            currMax = counts.get(index);
            if (currMax == maxLength && index <= indexMax) {
                break;
            }
        }
        int response = index;
        if (index < 0) {
            return response;
        }
        for (; ; index = nextInt.get(index)) {
            subSequence.add(listInput.get(index));
            if (nextInt.get(index) == -1) {
                break;
            }
        }
        return response;
    }

    //15
    //7 2 1 3 8 4 9 1 2 6 5 9 3 8 1
    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        List<Integer> firstList = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            firstList.add(fastScanner.nextInt());
        }
        List<Integer> counts = new ArrayList<>(firstList.size());
        List<List<Integer>> nextInt = new ArrayList<>(firstList.size());
        int max = findLongestSubsequence(firstList, counts, nextInt);
        System.out.println();
        // считаем данные по длине и индексу снаружи
//        for (int i = max, index = firstList.size() - 1; i > 0; ) {
//            List<Integer> subSequence = new ArrayList<>();
//            index = getLongestSubsequence(firstList, counts, nextInt, subSequence, i, index);
//            if (index < 0) {
//                --i;
//                index = firstList.size() - 1;
//            } else {
//                --index;
//            }
//            if (!subSequence.isEmpty()) {
//                for (int j = subSequence.size() - 1; j >= 0; --j) {
//                    System.out.print(subSequence.get(j) + " ");
//                }
//                System.out.println();
//            }
//        }
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
