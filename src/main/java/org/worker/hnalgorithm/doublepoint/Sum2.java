//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
// Related Topics 数组 哈希表
// 👍 11686 👎 0
package org.worker.hnalgorithm.doublepoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author peiru wang
 * @date 2021/7/25
 */
public class Sum2 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) {
            return new int[]{0,1};
        }

        int[] result = new int[]{-1,-1};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        Arrays.sort(nums);

        int x = 0, y = nums.length - 1;
        while(x < y) {
            if(nums[x] + nums[y] < target) {
                x++;
            }else if(nums[x] + nums[y] > target) {
                y--;
            }else {
                break;
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == nums[x] && result[0] != -1) {
                result[0] = entry.getKey();
                continue ;
            }
            if(entry.getValue() == nums[y] && result[1] != -1) {
                result[1] = entry.getKey();
                continue;
            }
        }
        return result;
    }
}
