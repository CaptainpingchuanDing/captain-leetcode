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


    public static void main(String[] args) {
        String str = "2345";
        System.out.println(str.substring(1));
    }


    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 从上到下，以每个点为开始，想四个方向找。
                    boolean[][] isUsed = new boolean[board.length][board[0].length];
                    boolean result = helper(board, word, i, j, 0, isUsed);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int wordIndex, boolean[][] isUsed) {
        if (wordIndex == word.length()) return true;
        // 已经使用，标识之前走过
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || isUsed[row][col]) return false;
        if (board[row][col] == word.charAt(wordIndex)) {
            isUsed[row][col] = true;
            wordIndex++;
            if (helper(board, word, row - 1, col, wordIndex, isUsed)) return true;// 上
            if (helper(board, word, row + 1, col, wordIndex, isUsed)) return true;// 下
            if (helper(board, word, row, col - 1, wordIndex, isUsed)) return true; // 左
            if (helper(board, word, row, col + 1, wordIndex, isUsed)) return true; // 右
            isUsed[row][col] = false;
        }
        return false;
    }

    //使用数字本身来标记是否已经走过该位置，  但是如果能找到这个单词，原来的二维数字是被改变了（找到的路径变成了'.'）
    public boolean exist_S(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 从上到下，以每个点为开始，想四个方向找。
                    boolean result = helper(board, word, i, j, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int wordIndex) {
        if (wordIndex == word.length()) return true;
        // 已经使用，标识之前走过
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] == '.') return false;
        if (board[row][col] == word.charAt(wordIndex)) {
            board[row][col] = '.';//标记已经走过
            wordIndex++;
            if (helper(board, word, row - 1, col, wordIndex)) return true;// 上
            if (helper(board, word, row + 1, col, wordIndex)) return true;// 下
            if (helper(board, word, row, col - 1, wordIndex)) return true; // 左
            if (helper(board, word, row, col + 1, wordIndex)) return true; // 右
            board[row][col] = word.charAt(wordIndex - 1);// 还原
        }
        return false;
    }
}
