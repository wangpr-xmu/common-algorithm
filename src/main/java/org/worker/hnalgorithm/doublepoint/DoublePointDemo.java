package org.worker.hnalgorithm.doublepoint;

/**
 * @author peiru wang
 * @date 2021/7/29
 */
public class DoublePointDemo {
    public static void main(String[] args) {
        Sum2 sum2 = new Sum2();
        int[] nums = new int[]{2,5,5,11};
        int[] ints = sum2.twoSum(nums, 10);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
