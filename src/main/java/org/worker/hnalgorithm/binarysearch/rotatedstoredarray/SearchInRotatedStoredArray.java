package org.worker.hnalgorithm.binarysearch.rotatedstoredarray;

/**
 * 搜索旋转排序数组
 */
public class SearchInRotatedStoredArray {

    public static void main(String[] args) {
        int[] nums = {4,6,8,0,1,2};
        int result = new SearchInRotatedStoredArray().search(nums, 2);
        System.out.println(result);

    }

    public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[mid] > nums[start]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }

        }
        if(nums[start] == target) {
            return start;
        }

        if(nums[end] == target) {
            return end;
        }
        return -1;
    }

}
