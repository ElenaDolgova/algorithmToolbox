package LeetCode.medium.FindPeakElementII;

import java.util.function.BiFunction;

// Находим максимум в каждой строке/колонке и уже это максимум проверяем
// на условие задачи
//https://leetcode.com/submissions/detail/510701985/
class Solution2 {
    public int[] findPeakGrid(int[][] mat) {
        for (int rowNum = 0; rowNum < mat.length; ++rowNum) {
            int[] row = mat[rowNum];
            int colNum = getIndexOfMaxValue(row);
            int curValue = row[colNum];

            if (isNotNorm(Solution2::getUpperIndexes, rowNum, colNum, curValue, mat)) {
                continue;
            }

            if (isNotNorm(Solution2::getDownIndexes, rowNum, colNum, curValue, mat)) {
                continue;
            }
            return new int[]{rowNum, colNum};
        }
        return new int[]{0, 0};
    }

    private boolean isNotNorm(BiFunction<Integer, Integer, Integer[]> function,
                              int rowNum, int colNum, int curValue,
                              int[][] mat) {
        int value = getAndValidateValue(function.apply(rowNum, colNum), mat);
        return curValue <= value;
    }

    private int getIndexOfMaxValue(int[] arr) {
        int index = 0;
        int largeValue = arr[index];
        for (int i = 1; i < arr.length; ++i) {
            if (largeValue < arr[i]) {
                index = i;
                largeValue = arr[i];
            }
        }
        return index;
    }

    private static Integer[] getUpperIndexes(int curRowNum, int curColNum) {
        return new Integer[]{(curRowNum - 1), (curColNum)};
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