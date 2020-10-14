package pers.captain.algorithm.June;

import com.alibaba.fastjson.JSON;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SudokuSolver_37 {


    /**
     * 主要的思路是，回溯法（递归实现）DFS（Depth First Search） 注意不合格的路径回来之后要清空对应位置的数值
     * <p>
     * 递归函数的设计，方法的入参，当前数独、需要填写的数字坐标、需要填写的数值，返回值是boolean类型
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {


    }

    private boolean sudokuHelper(int[][] board, int col, int row ){

        // 1. 先找到改col 的下一个需要赋值的位置，如果没有就找col++（也就是下一行）

        // 2. 找到位置之后，1-9赋值，递归调用，如果不满足，则把当前位置置空

        return false;
    }

    private boolean isValid(char[][] board, int col, int row, int num) {

        // 行和列的数值不能和num相同
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '0' + num || board[i][col] == '0' + num) return false;
        }
        // 所在的9*9方框的数值也不同和num相同
        col = col / 3 * 3;
        row = row / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + i] == num + '0') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] array = new int[2][3];
        array[0] = new int[]{1, 2, 3};
        array[1] = new int[]{4, 5, 6};
        System.out.println(JSON.toJSONString(array[0][2]));
    }
}
