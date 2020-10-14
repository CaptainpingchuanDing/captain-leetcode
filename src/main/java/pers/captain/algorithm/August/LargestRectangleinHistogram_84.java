package pers.captain.algorithm.August;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleinHistogram_84 {


    /**
     * O (n^2)  把所有组合的可能都算一遍
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights.length - 1 > i && heights[i] <= heights[i + 1]) {
                continue;
            } else {
                int height = heights[i];
                for (int j = i; j >= 0; j--) {
                    if (heights[j] < height) {
                        height = heights[j];
                    }
                    int temp = height * (i - j + 1);
                    if (temp > max) max = temp;
                }
            }
        }
        return max;
    }


    @Test
    public void largestRectangleArea1() {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int[] arr1 = new int[]{2};

        Assert.assertEquals(10, largestRectangleArea1(arr));
        Assert.assertEquals(2, largestRectangleArea1(arr1));
    }

    /**
     * 0(n^2) 计算以 heights[i]为高度的最大矩形面积（左右两边找）
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        int leftIndex;
        int rightIndex;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            leftIndex = i;
            rightIndex = i;
            while (leftIndex >= 0 && heights[leftIndex] >= height) leftIndex--;
            while (rightIndex < heights.length && heights[rightIndex] >= height) rightIndex++;
            int temp = (rightIndex - leftIndex - 1) * height;
            if (temp > max) max = temp;

        }
        return max;
    }

    @Test
    public void largestRectangleArea2() {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int[] arr1 = new int[]{2};

        Assert.assertEquals(10, largestRectangleArea2(arr));
        Assert.assertEquals(2, largestRectangleArea2(arr1));
    }

    /**
     * O(n)
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                int temp = (i - stack.peek() - 1) * h;
                area = Math.max(area, temp);
            }
            stack.push(i);
        }

        return area;
    }

    @Test
    public void largestRectangleArea() {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};

        Assert.assertEquals(10, largestRectangleArea(arr));
    }

}
