package org.worker.hnalgorithm.binarysearch.minimuminrotatedarray;

/**
 * 寻找旋转排序数组中的最小值
 */
public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {20,1,2,3};
        int result = new FindMinimumInRotatedArray().minArray(nums);
        System.out.println(result);
    }


    public int minArray(int[] nums) {
        if(null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] >= nums[start]) {
                if(nums[mid] >= nums[end]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
