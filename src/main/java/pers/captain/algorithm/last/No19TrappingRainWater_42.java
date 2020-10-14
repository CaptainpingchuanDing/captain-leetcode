package pers.captain.algorithm.last;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class No19TrappingRainWater_42 {

    /**
     * 1.找出不可以盛水的。单调上涨（左边没有下跌）、单调下跌（右边没有上涨）
     * 2.找出可以盛水的。选出两边中一个最低的高度，一块一块的计算。
     * todo 没有求解出来，想法有问题。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int total = 0;
        int left = 0;
        int right = 2;
        int lastSum = 0;
        while (right < height.length) {
            int temp = calculate(height, left, right);
            if (temp <= 0) {

                left++;
            } else {
                lastSum = temp;
                right++;
            }


        }

        return 0;
    }

    private int calculate(int[] height, int left, int right) {

        int min = Math.min(height[left], height[right]);
        int total = 0;
        for (int i = left + 1; i < right; i++) {
            int temp = min - height[i];
            if (temp < 0) {
                return -1;
            }
            total += temp;
        }

        return total;
    }

    /**
     * 暴力方式求解
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }

    /**
     * 暴力方式求解
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxHeight = 0;
        while (right > left) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > maxHeight) {
                maxHeight = temp;
            }
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return maxHeight;
    }

    /**
     * 最容易理解的做法
     * 1. 找出每个位置的左边最高墙、右边最高墙
     * 2. 第i 位置的水：min（leftMost、rightMost）- height[i]
     * 3. 累加
     */
    public int trap3(int[] height) {
        if (height == null || height.length == 0) return 0;
        // 总和
        int sum = 0;
        // 当前 i左边最高墙的高度
        int[] leftMost = new int[height.length];
        // 当前 i右边最高墙的高度
        int[] rightMost = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMost[0] = height[0];
                rightMost[height.length - 1] = height[height.length - 1];
            } else {
                // 丛左到右计算leftMost
                if (leftMost[i - 1] >= height[i]) {
                    leftMost[i] = leftMost[i - 1];
                } else {
                    leftMost[i] = height[i];
                }
                // 丛右到左计算rightMost
                if (rightMost[height.length - i] <= height[height.length - 1 - i]) {
                    rightMost[height.length - 1 - i] = height[height.length - 1 - i];
                } else {
                    rightMost[height.length - 1 - i] = rightMost[height.length - i];
                }
            }
        }

        for (int i = 0; i < height.length; i++) {
            // 当前i位置盛水高于取决于两边墙最低的那一个
            int min = Math.min(leftMost[i], rightMost[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }


    @Test
    public void testTrap3() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        // leftMost 0, 1, 1 ,2 ,2, 2, 2, 3, 3, 3, 3, 3
        // rightMost 3,3,3,3,3,2,2,2,1

        Assert.assertEquals(trap3(height), 6);

    }

    public static void main(String[] args) {
        No19TrappingRainWater_42 no19TrappingRainWater_42 = new No19TrappingRainWater_42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = no19TrappingRainWater_42.calculate(height, 3, 7);
        int result1 = no19TrappingRainWater_42.trap1(height);
        int result2 = no19TrappingRainWater_42.trap2(height);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }

    public int trapTest(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;
        while (right >= left) {
            while (right >= left && leftMax <= height[left]) {
                leftMax = height[left];
                left++;
            }

            while (right >= left && rightMax <= height[right]) {
                rightMax = height[right];
                right--;
            }

            if (right < left) break;
            if (leftMax >= rightMax) {
                totalWater += rightMax - height[right];
                right--;
            } else {
                totalWater += leftMax - height[left];
                left++;
            }
        }
        return totalWater;
    }

    @Test
    public void trapTest() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int totalWater = trapTest(height);
        System.out.println(totalWater);


        int[] height1 = new int[]{0, 2, 0};

        int totalWater1 = trapTest(height1);
        System.out.println(totalWater1);

    }
}
