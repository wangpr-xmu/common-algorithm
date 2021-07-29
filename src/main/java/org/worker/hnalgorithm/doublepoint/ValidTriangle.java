//给定一个数组nums[]，计算这个数组中能够组成三角形三条边的组合个数

package org.worker.hnalgorithm.doublepoint;

import java.util.Arrays;

/**
 * @author peiru wang
 * @date 2021/7/25
 */
public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total += (end - start);
                    end --;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}
