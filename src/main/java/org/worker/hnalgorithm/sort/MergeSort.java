package org.worker.hnalgorithm.sort;

/**
 * 归并排序算法
 * @author peiru wang
 * @date 2021/7/14
 */
public class MergeSort {
    public void sort(int[] arrays) {
        int[] temp = new int[arrays.length];
        sort(arrays, 0, arrays.length - 1, temp);
    }

    public void sort(int[] arrays, int start, int end, int[] temp) {
        if(start >= end) {
            return ;
        }
        int mid = (start + end) / 2;
        sort(arrays, start, mid, temp);
        sort(arrays, mid + 1, end, temp);
        merge(arrays, start, mid, end, temp);
    }

    public void merge(int[] arrays, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while(left <= mid && right <= end) {
            if(arrays[left] < arrays[right]) {
                temp[index++] = arrays[left++];
            }else {
                temp[index++] = arrays[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arrays[left++];
        }
        while(right <= end) {
            temp[index++] = arrays[right++];
        }
        for(index=start; index <= end; index++) {
            arrays[index] = temp[index];
        }
    }
}
