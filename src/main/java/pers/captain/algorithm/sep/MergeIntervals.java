package pers.captain.algorithm.sep;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length < 2) return intervals;
        // ranker
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - i-1; j++) {
                if (intervals[j][0] >= intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] array1 = stack.pop();
            int[] mergeArray = new int[2];
            if (array1[array1.length - 1] >= intervals[i][0]) {// can merge
                mergeArray[0] = array1[0];
                if (array1[array1.length - 1] >= intervals[i][1]) {
                    mergeArray[1] = array1[array1.length - 1];
                } else {
                    mergeArray[1] = intervals[i][1];
                }
                stack.push(mergeArray);
            } else {
                stack.push(array1);
                stack.push(intervals[i]);
            }
        }
        int[][] result = new int[stack.size()][2];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }

        return result;
    }

    @Test
    public void merge() {
//        int[][] intervals = new int[4][2];
//        intervals[0] = new int[]{1, 3};
//        intervals[1] = new int[]{2, 6};
//        intervals[2] = new int[]{8, 10};
//        intervals[3] = new int[]{15, 18};
//
//        int[][] result = merge(intervals);
//        Assert.assertEquals(result.length, 3);
//        Assert.assertEquals(result[0][0], 1);
//        Assert.assertEquals(result[0][1], 6);
//        Assert.assertEquals(result[1][0], 8);
//        Assert.assertEquals(result[1][1], 10);

        int[][] intervals1 = new int[2][2];
        intervals1[0] = new int[]{1, 4};
        intervals1[1] = new int[]{0, 4};

        int[][] result1 = merge(intervals1);
        Assert.assertEquals(result1.length, 1);
        Assert.assertEquals(result1[0][0], 0);
        Assert.assertEquals(result1[0][1], 4);

    }

}
