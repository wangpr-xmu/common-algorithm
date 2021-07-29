//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//参考leetCode接雨水

package org.worker.hnalgorithm.doublepoint;

/**
 * @author peiru wang
 * @date 2021/7/25
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (leftHeight > height[left + 1]) {
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left +1];
                }
                left++;
            } else {
                if (rightHeight > height[right - 1]) {
                    sum += rightHeight - height[right - 1];
                } else {
                    rightHeight = height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }
}
