package pers.captain.algorithm.June;

import org.junit.Assert;
import org.junit.Test;

/**
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 */
public class SearchinRotatedSortedArray_33 {


    /*
    [4,5,6,7,0,1,2]
          例如，target=3
          1.nums[left]> target && nums[mid]>target 则left = mid;
          2.nums[left]> target && nums[mid]<target 则right = mid;
          例如，target=7
          3.nums[left]< target && nums[mid]>target right = mid;
          4.nums[left]< target && nums[mid]<target left = mid;

     */
    public static int search(int[] nums, int target) {
        if (nums == null) return 0;

        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[left] < target) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[left] > target) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                return left;
            }
        }
        return -1;
    }


    @Test
    public void testSearch() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result1 = search(nums, 0);
        Assert.assertEquals(result1, 4);

        int result2 = search(nums, 8);
        Assert.assertEquals(result2, -1);

        int result3 = search(nums, 4);
        Assert.assertEquals(result3, 0);

        int result4 = search(nums, 2);
        Assert.assertEquals(result4, 6);

        nums = new int[]{5, 1, 3};
        int result5 = search(nums, 3);
        Assert.assertEquals(result5, 2);

    }


// 正解

    /**
     * target = 0
     * 情况一 [3,4,5,6,0,1,2]
     * nums[left]<nums[mid] (即nums[0]<nums[3])
     * 如果 nums[left]<target<nums[mid]  说明target在这个递增区间
     * 否则，在（mid,right] 搜索
     * <p>
     * 情况二 [5,6,0,1,2,3,4]
     * nums[left]>nums[mid] (即nums[0]>nums[3])
     * 如果 nums[left]<target 且 target > nums[mid] 说明target在 (left,mid)
     * 否则在(mid,right]
     */
    public static int searchNormal(int[] nums, int target) {
        if (nums == null) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) {
                return left;
            } else if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && target > nums[left]) {
                    right = mid;
                } else if (target == nums[mid]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target > nums[left]) {
                    right = mid;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int searchNormal1(int[] nums, int target) {
        if (nums == null) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void testSearch1() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result1 = searchNormal1(nums, 0);
        Assert.assertEquals(result1, 4);

        int result2 = searchNormal1(nums, 8);
        Assert.assertEquals(result2, -1);

        int result3 = searchNormal1(nums, 4);
        Assert.assertEquals(result3, 0);

        int result4 = searchNormal1(nums, 2);
        Assert.assertEquals(result4, 6);

        nums = new int[]{5, 1, 3};
        int result5 = searchNormal1(nums, 3);
        Assert.assertEquals(result5, 2);

    }

    public int searchN(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] == target) {
                return start;

            } else if (nums[end] == target) {
                return end;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }

    @Test
    public void testSearchN() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result1 = searchN(nums, 0);
        Assert.assertEquals(result1, 4);

        int result2 = searchN(nums, 8);
        Assert.assertEquals(result2, -1);

        int result3 = searchN(nums, 4);
        Assert.assertEquals(result3, 0);

        int result4 = searchN(nums, 2);
        Assert.assertEquals(result4, 6);

        nums = new int[]{5, 1, 3};
        int result5 = searchN(nums, 3);
        Assert.assertEquals(result5, 2);

    }

    /**
     *  1. 当start 和end 相邻就结束循环，循环之外单独与target比较，防止出现 mid = left 出现死循环的情况
     *  2. mid =  start + (end - start) / 2； 防止溢出
     */
    public int searchMala(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[start]> nums[mid]){
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;

    }

    @Test
    public void testSearchMala() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result1 = searchMala(nums, 0);
        Assert.assertEquals(result1, 4);

        int result2 = searchMala(nums, 8);
        Assert.assertEquals(result2, -1);

        int result3 = searchMala(nums, 4);
        Assert.assertEquals(result3, 0);

        int result4 = searchMala(nums, 2);
        Assert.assertEquals(result4, 6);

        nums = new int[]{5, 1, 3};
        int result5 = searchMala(nums, 3);
        Assert.assertEquals(result5, 2);

    }

}

