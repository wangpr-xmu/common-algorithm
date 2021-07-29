package org.worker.hnalgorithm.doublepoint;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author peiru wang
 * @date 2021/7/29
 */
public class DoublePointDemo {
    public static void main(String[] args) {

        testSum3();
    }

    public static void testSum2() {
        Sum2 sum2 = new Sum2();
        int[] nums = new int[]{2,5,5,11};
        int[] ints = sum2.twoSum(nums, 10);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
    public static void testSum3() {
        Sum3 sum3 = new Sum3();
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> result = sum3.threeSum(nums);

        System.out.println(JSON.toJSONString(result));

    }
}
