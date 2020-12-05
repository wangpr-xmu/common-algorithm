package org.worker.hnalgorithm.binarysearch;

public class BinarySearchTemplate {

    public static void main(String[] args) {
        int nums[] = {0,2,4,6,7,9};
        System.out.println(getTargetIndex(nums, 9));

    }

    public static int getTargetIndex(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if(nums[end] == target) {
            return end;
        }
        if(nums[start] == target) {
            return start;
        }
        return -1;
    }
}
