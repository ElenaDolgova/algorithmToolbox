package LeetCode.medium.FindPeakElementII;

import java.util.function.BiFunction;

// https://leetcode.com/submissions/detail/510681712/
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] answer = {0, 0};
        for (int rowNum = 0; rowNum < mat.length; ++rowNum) {
            for (int colNum = 0; colNum < mat[rowNum].length; ++colNum) {
                int curValue = mat[rowNum][colNum];

                if (!isNorm(Solution::getLeftIndexes, rowNum, colNum, curValue, mat)) {
                    continue;
                }

                if (!isNorm(Solution::getUpperIndexes, rowNum, colNum, curValue, mat)) {
                    continue;
                }

                if (!isNorm(Solution::getRightIndexes, rowNum, colNum, curValue, mat)) {
                    continue;
                }

                if (!isNorm(Solution::getDownIndexes, rowNum, colNum, curValue, mat)) {
                    continue;
                }

                return new int[]{rowNum, colNum};
            }
        }
        return answer;
    }

    private boolean isNorm(BiFunction<Integer, Integer, Integer[]> function,
                           int rowNum, int colNum, int curValue,
                           int[][] mat) {
        int value = getAndValidateValue(function.apply(rowNum, colNum), mat);
        return curValue > value;
    }

    private static Integer[] getLeftIndexes(int curRowNum, int curColNum) {
        return new Integer[]{(curRowNum), (curColNum - 1)};
    }

    private static Integer[] getUpperIndexes(int curRowNum, int curColNum) {
        return new Integer[]{(curRowNum - 1), (curColNum)};
    }

    private static Integer[] getRightIndexes(int curRowNum, int curColNum) {
        return new Integer[]{(curRowNum), (curColNum + 1)};
    }

    private static Integer[] getDownIndexes(int curRowNum, int curColNum) {
        return new Integer[]{(curRowNum + 1), (curColNum)};
    }

    private static int getAndValidateValue(Integer[] indexes, int[][] mat) {
        int maxRowLength = mat.length;
        int maxColLength = mat[0].length;
        if (indexes[0] < -1 || indexes[1] < -1) {
            throw new RuntimeException(
                    "Source index is invalid rowNum: " + indexes[0] + " colNum: " + indexes[1]);
        } else if (indexes[0] == -1 || indexes[1] == -1
                || indexes[0] == maxRowLength || indexes[1] == maxColLength) {
            return -1;
        }

        return mat[indexes[0]][indexes[1]];
    }
}