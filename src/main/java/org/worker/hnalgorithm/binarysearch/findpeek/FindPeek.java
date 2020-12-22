package org.worker.hnalgorithm.binarysearch.findpeek;

/**
 * 寻找峰值
 */
public class FindPeek {

    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        if(null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid + 1] > nums[mid]) {
                start = mid;
            }else if(nums[mid + 1] < nums[mid]) {
                end = mid;
            }else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
