package org.worker.hnalgorithm.sort;

/**
 * 插入排序算法
 * @author peiru wang
 * @date 2021/7/13
 */
public class InsertSort {
    public void sort(int[] arrays) {
        if(null == arrays || arrays.length == 1) {
            return ;
        }
        for(int i = 1; i < arrays.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arrays[j] > arrays[i]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
    }
}
