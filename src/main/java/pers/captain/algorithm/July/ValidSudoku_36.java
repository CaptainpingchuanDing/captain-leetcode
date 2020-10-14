package pers.captain.algorithm.July;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 */
public class ValidSudoku_36 {


    /**
     * 1. 每行用一个数组判断是否有效数字
     * 2. 每列用一个数组判断是否有效数字
     * 3. 每个3*3 的正方形 用一个数组判断是否有效数字
     */
    public boolean isValidSudoku(char[][] board) {

        boolean[] hasNumber = new boolean[9];

        // 每一行
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') continue;
                if (hasNumber[board[row][col] - '0' - 1]) {
                    return false;
                } else {
                    hasNumber[board[row][col] - '0' - 1] = true;
                }
            }
            hasNumber = new boolean[9];
        }

        // 每一列
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                if ( hasNumber[board[row][col] - '0' - 1]) {
                    return false;
                } else {
                    hasNumber[board[row][col] - '0' - 1] = true;
                }
            }
            hasNumber = new boolean[9];
        }
        //
        for (int j = 0; j < 9; j = j + 3) {
            for (int i = 0; i < 9; i = i + 3) {
                hasNumber = new boolean[9];
                for (int col = i; col < 3 + i; col++) {
                    for (int row = j; row < 3 + j; row++) {
                        if (board[row][col] == '.') continue;
                        if ( hasNumber[board[row][col] - '0' - 1]) {
                            return false;
                        } else {
                            hasNumber[board[row][col] - '0' - 1] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

}
