package pers.captain.algorithm.July;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSearch79 {


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || word.length() == 0) return false;
        boolean[][] road = new boolean[board.length][board[0].length];

        int startRow = 0;
        int startCol = 0;
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    startRow = i;
                    startCol = j;
                    flag = true;
                    road[i][j] = true;
                }
            }
        }
        if (flag) {
            return helper(board, road, startRow, startCol, word.substring(1));
        }
        return false;
    }

    private boolean helper(char[][] board, boolean[][] road, int row, int col, String restWord) {

        return true;
    }

    public static void main(String[] args) {
        String str = "2345";
        System.out.println(str.substring(1));
    }

}
