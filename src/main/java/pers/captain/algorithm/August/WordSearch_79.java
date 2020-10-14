package pers.captain.algorithm.August;

public class WordSearch_79 {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
                || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean exit;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                exit = wordHelper(board, used, word, 0, row, col);
                if (exit) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordHelper(char[][] board, boolean[][] used, String word, int wordIndex, int row, int col) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row >= board.length || row < 0
                || col >= board[0].length || col < 0
                || used[row][col] || board[row][col] != word.charAt(wordIndex))
            return false;

        used[row][col] = true;
        //上
        boolean exit = wordHelper(board, used, word, wordIndex + 1, row - 1, col);
        if (exit) {
            return true;
        }
        //下
        exit = wordHelper(board, used, word, wordIndex + 1, row + 1, col);
        if (exit) {
            return true;
        }
        //左
        exit = wordHelper(board, used, word, wordIndex + 1, row, col - 1);
        if (exit) {
            return true;
        }
        //右
        exit = wordHelper(board, used, word, wordIndex + 1, row, col + 1);
        if (exit) {
            return true;
        }
        used[row][col] = false;

        return false;
    }

}
