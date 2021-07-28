package org.worker.hnalgorithm.sort;

/**
 * 冒泡排序算法
 * @author peiru wang
 * @date 2021/7/12
 */
public class BubbleSort {
    public void sort(int[] arrays) {
        if(null == arrays || arrays.length == 1) {
            return ;
        }
        for(int i = 0; i < arrays.length; i++) {
            for(int j = 0; j < arrays.length - i -1; j++) {
                if(arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }
}
