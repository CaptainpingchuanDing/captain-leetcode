package pers.captain.algorithm.sep.bit;

import org.junit.Assert;
import org.junit.Test;

public class AppearOnceSortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("nums is null or empty");
        int left = 0;
        int right = nums.length - 1;
        while (right > left + 1) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - 2 - left + 1) % 2 == 0) {// 左边是偶数
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else if (mid + 1 <= nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if ((mid - 1 - left + 1) % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];

    }

    @Test
    public void singleNonDuplicate(){
//        int[] nums = new int[]{1,1,2,3,3,4,4,5,5};
        int[] nums = new int[]{3,3,7,7,10,11,11};
        int result =  singleNonDuplicate(nums);
        Assert.assertEquals(result,10);
    }

}
