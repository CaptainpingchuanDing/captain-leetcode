package pers.captain.algorithm.offer.six;

public class NO65HasPath {

    public boolean hasPath(String matrix, int rows, int cols, String str) {
        // write code here
        if (matrix == null || matrix.length() == 0) return false;
        if (str == null || str.length() == 0) return true;
        boolean[][] isUsed = new boolean[rows][cols];// 记录使用过的元素
        for (int i = 0; i < rows; i++) {// 每个位置元素都开始一次
            for (int j = 0; j < cols; j++) {
                if (helper(i, j, 0, matrix, str, isUsed)) return true;
            }
        }
        return false;
    }

    private boolean helper(int row, int col, int curIndex, String matrix, String str, boolean[][] isUsed) {
        // 检查范围、检查是否走过该点，检查是否已经str对应的字符串是否到头
        if (row < 0 || row >= isUsed.length || col < 0 || col >= isUsed[0].length || isUsed[row][col] || curIndex >= str.length())
            return false;
        if (str.charAt(curIndex) == matrix.charAt(row * isUsed[0].length + col)) {
            if (str.length() == curIndex + 1) return true;
            isUsed[row][col] = true;
            boolean result = helper(row - 1, col, curIndex + 1, matrix, str, isUsed);//上
            if (result) return true;// 找到之后就不同向其他方向找，直接退出递归
            result = helper(row + 1, col, curIndex + 1, matrix, str, isUsed);//下
            if (result) return true;
            result = helper(row, col - 1, curIndex + 1, matrix, str, isUsed);//左
            if (result) return true;
            result = helper(row, col + 1, curIndex + 1, matrix, str, isUsed);//右
            if (result) return true;
            isUsed[row][col] = false;// 回溯
        }
        return false;
    }
}
