package pers.captain.algorithm.offer.six;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 示例1
 * 输入
 * <p>
 * 5,10,10
 * 返回值
 * <p>
 * 21
 */
public class NO66MovingCount {

    /**
     * // 使用一个二维数组记录走过的路
     * // 使用递归，之前走过的地方就可以停止了
     * // 最后记录走过的路
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {

        if (rows <= 0 || cols <= 0 || threshold <= 0) return 0;
        boolean[][] visited = new boolean[rows][cols];
        visit(visited, 0, 0, threshold);
        int count = 0;
        // 统计走过的路
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) count++;
            }
        }
        return count;
    }

    private void visit(boolean[][] visited, int row, int col, int threshold) {
        // 去除越界的情况
        if (row < 0 || row > visited.length - 1 || col < 0 || col > visited[0].length - 1) return;
        if (visited[row][col]) return;// 走过的就不用继续走
        if (sumBitNum(row) + sumBitNum(col) <= threshold) {// 不符合阈值的就不用继续走
            visited[row][col] = true;
            // 只向右、向下走其实就可以把能走的地方都走完
//            visit(visited, row - 1, col, threshold);
            visit(visited, row + 1, col, threshold);
//            visit(visited, row, col - 1, threshold);
            visit(visited, row, col + 1, threshold);
        }
    }

    private int sumBitNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public int movingCount2(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold <= 0) return 0;
        boolean[][] visited = new boolean[rows][cols];
        int[] count = new int[1];
        visit2(visited, 0, 0, threshold, count);
        return count[0];
    }

    private void visit2(boolean[][] visited, int row, int col, int threshold, int[] time) {
        // 去除越界的情况
        if (row < 0 || row > visited.length - 1 || col < 0 || col > visited[0].length - 1) return;
        if (visited[row][col]) return;// 走过的就不用继续走
        if (sumBitNum(row) + sumBitNum(col) <= threshold) {// 不符合阈值的就不用继续走
            visited[row][col] = true;
            time[0]++;
            // 只向右、向下走其实就可以把能走的地方都走完
//            visit(visited, row - 1, col, threshold);
            visit2(visited, row + 1, col, threshold, time);
//            visit(visited, row, col - 1, threshold);
            visit2(visited, row, col + 1, threshold, time);
        }
    }

}
