package org.worker.hnalgorithm.sort;

/**
 * 选择排序算法
 * @author peiru wang
 * @date 2021/7/12
 */
public class SelectSort {
    public void sort(int[] arrays) {
        if(null == arrays || arrays.length == 1) {
            return ;
        }

        for(int i = 0; i < arrays.length; i++) {
            int min = arrays[i];
            int k = i;
            for(int j = i; j < arrays.length; j++) {
                if(arrays[j] < min) {
                    min = arrays[j];
                    k = j;
                }
            }
            if(k != i) {
                int temp = arrays[i];
                arrays[i] = arrays[k];
                arrays[k] = temp;
            }
        }
    }
}
