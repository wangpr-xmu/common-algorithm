package org.worker.hnalgorithm.sort;

/**
 * 快速排序算法
 * @author peiru wang
 * @date 2021/7/14
 */
public class QuickSort {
    public void sort(int[] arrays) {
        if(null == arrays || arrays.length == 1) {
            return ;
        }
        sort(arrays, 0, arrays.length - 1);
    }
    private void sort(int[] arrays, int start, int end) {
        if(start >= end) {
            return ;
        }
        int left = start;
        int right = end;
        int pivot = arrays[left];
        while(left <= right) {
            while(left <= right && arrays[left] < pivot) {
                left++;
            }
            while(left <= right && arrays[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = temp;
                left++;
                right--;
            }
        }
        sort(arrays, start, right);
        sort(arrays, left, end);
    }
}
