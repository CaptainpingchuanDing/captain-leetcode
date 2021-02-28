package pers.captain.algorithm.offer.two;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16 17
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 示例1
 * 输入
 * <p>
 * [[1,2],[3,4]]
 * 返回值
 * <p>
 * [1,2,4,3]
 */
public class NO19PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public ArrayList<Integer> printMatrix_E(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; col++) res.add(matrix[up][col]);
            up++;
            if (up > down) break;
            for (int row = up; row <= down; row++) res.add(matrix[row][right]);
            right--;
            if (right < left) break;
            for (int col = right; col >= left; col--) res.add(matrix[down][col]);
            down--;
            if (up > down) break;
            for (int row = down; row >= up; row--) res.add(matrix[row][left]);
            left++;
            if (right < left) break;
        }
        return res;
    }
}