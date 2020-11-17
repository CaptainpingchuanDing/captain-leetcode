package pers.captain.algorithm.nov.ss;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class RobotMovingCount {


    public int movingCount(int m, int n, int k) {

        boolean[][] road = new boolean[m][n];
        helper(road, 0, 0, k);

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (road[i][j]) count++;
            }
        }
        return count;
    }

    /**
     * 1, 2, 3, 4, 5
     * 1, 2, 3, 4, 5
     * 2, 3, 4, 5, 6
     * 3, 4, 5, 6, 7
     */
    private boolean helper(boolean[][] road, int row, int col, int k) {
        if (row < 0 || row >= road.length || col < 0 || col >= road[0].length) return false;
        if (!road[row][col] && canMove(row, col, k)) {
            road[row][col] = true;

//            if (helper(road, row - 1, col, k)) return true;
            if (helper(road, row + 1, col, k)) return true;
//            if (helper(road, row, col - 1, k)) return true;
            if (helper(road, row, col + 1, k)) return true;
        }

        return false;
    }


    private boolean canMove(int m, int n, int k) {
        int count = 0;
        count += countBit(m);
        count += countBit(n);
        if (count <= k) return true;
        return false;
    }

    private int countBit(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 10;
            num = num / 10;
        }
        return count;
    }

    @Test
    public void movingCount() {
        int result = movingCount(2, 3, 1);
        Assert.assertEquals(3, result);
    }

    @Test
    public void movingCount1() {
        int result = movingCount(3, 1, 0);
        Assert.assertEquals(1, result);
    }

    public int movingCount_s(int m, int n, int k) {
        return helper_s(0, 0, m, n, k, new boolean[m][n]);
    }

    private int helper_s(int row, int col, int m, int n, int k, boolean[][] isVisited) {
        if (row >= m || col >= n || !canMove(row, col, k) || isVisited[row][col]) return 0;
        isVisited[row][col] = true;
        return 1 + helper_s(row, col + 1, m, n, k, isVisited) + helper_s(row + 1, col, m, n, k, isVisited);
    }

    @Test
    public void movingCount_s() {
        int result = movingCount_s(2, 3, 1);
        Assert.assertEquals(3, result);
    }
}
