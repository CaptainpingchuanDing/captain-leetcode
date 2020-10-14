package pers.captain.algorithm.August;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrix_64 {

    /**
     * t 0(n logn)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        boolean result = false;
        //run every row
        for (int row = 0; row < matrix.length; row++) {
            // tow binary search
            result = twoBinarySearch(matrix[row], target);
            if (result) {
                return result;
            }
        }
        return result;
    }

    private static boolean twoBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) return true;
            if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (array[start] == target || array[end] == target) return true;
        return false;
    }

    @Test
    public void searchMatrix() {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 50};
        boolean result1 = searchMatrix(matrix, 13);

        Assert.assertFalse(result1);

        boolean result2 = searchMatrix(matrix, 34);

        Assert.assertTrue(result2);
    }

    /**
     * time O(logn)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //run every row
        int row = 0;
        for (; row < matrix.length; row++) {
            // tow binary search
            if (matrix[row][matrix[0].length - 1] >= target) {
                return twoBinarySearch(matrix[row], target);
            }
        }
        return false;
    }

    @Test
    public void searchMatrix1() {
//        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1, 3, 5, 7};
//        matrix[1] = new int[]{10, 11, 16, 20};
//        matrix[2] = new int[]{23, 30, 34, 50};
//        boolean result1 = searchMatrix1(matrix, 13);
//
//        Assert.assertFalse(result1);
//
//        boolean result2 = searchMatrix1(matrix, 34);
//
//        Assert.assertTrue(result2);

        int[][] matrix1 = new int[1][1];
        matrix1[0] = new int[]{1};
        boolean result3 = searchMatrix1(matrix1, 2);

        Assert.assertFalse(result3);

    }

    /**
     * time O(logn)
     * 两次 二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        //run every row
        int row = 0;
        int end = matrix.length - 1;
        boolean flag = false;
        while (row + 1 < end) {
            int mid = row + (end - row) / 2;
            if (matrix[mid][matrix[0].length - 1] >= target && matrix[mid][0] <= target) {
                row = mid;
                flag = true;
                break;
            }
            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                row = mid + 1;
            }
        }
        if (matrix[row][matrix[0].length - 1] >= target && matrix[row][0] <= target) {
            flag = true;
        }
        if (matrix[end][matrix[0].length - 1] >= target && target >= matrix[end][0]) {
            flag = true;
            row = end;
        }
        if (flag) {
            return twoBinarySearch(matrix[row], target);
        }

        return false;
    }

    @Test
    public void searchMatrix2() {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 50};
        boolean result1 = searchMatrix2(matrix, 13);

        Assert.assertFalse(result1);

        boolean result2 = searchMatrix2(matrix, 34);

        Assert.assertTrue(result2);

        int[][] matrix1 = new int[1][1];
        matrix1[0] = new int[]{1};
        boolean result3 = searchMatrix2(matrix1, 2);

        Assert.assertFalse(result3);

    }

}
