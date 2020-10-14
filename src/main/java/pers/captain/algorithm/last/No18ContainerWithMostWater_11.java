package pers.captain.algorithm.last;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class No18ContainerWithMostWater_11 {

    /**
     * 暴力遍历
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                if (temp > maxHeight) {
                    maxHeight = temp;
                }
            }
        }
        return maxHeight;
    }

    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

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

    public static void main(String[] args) {
        No18ContainerWithMostWater_11 no18ContainerWithMostWater_11 = new No18ContainerWithMostWater_11();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(no18ContainerWithMostWater_11.maxArea(height));
        System.out.println(no18ContainerWithMostWater_11.maxArea1(height));
    }
}
