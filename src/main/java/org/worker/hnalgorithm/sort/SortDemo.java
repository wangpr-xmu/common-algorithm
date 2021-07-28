package org.worker.hnalgorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author peiru wang
 * @date 2021/7/12
 */
public class SortDemo {

    public static void main(String[] args) {

        test1();

//        test2();

    }

    public static void test1() {
        int[] arrays = new int[10];
        for(int i = 1; i <= arrays.length; i++) {
            arrays[i-1] = new Random().nextInt(i * 1000);
        }
        int[] c1 = Arrays.copyOf(arrays, arrays.length);
        new BubbleSort().sort(c1);
        for(int i = 0; i < c1.length; i++) {
            System.out.print(c1[i] + " ");
        }
        System.out.println();
        int[] c2 = Arrays.copyOf(arrays, arrays.length);
        new SelectSort().sort(c2);
        for(int i = 0; i < c2.length; i++) {
            System.out.print(c2[i] + " ");
        }
        System.out.println();
        int[] c3 = Arrays.copyOf(arrays, arrays.length);
        new InsertSort().sort(c3);
        for(int i = 0; i < c3.length; i++) {
            System.out.print(c3[i] + " ");
        }
        System.out.println();
        int[] c4 = Arrays.copyOf(arrays, arrays.length);
        new QuickSort().sort(c4);
        for(int i = 0; i < c4.length; i++) {
            System.out.print(c4[i] + " ");
        }
        System.out.println();
        int[] c5 = Arrays.copyOf(arrays, arrays.length);
        new MergeSort().sort(c5);
        for(int i = 0; i < c5.length; i++) {
            System.out.print(c5[i] + " ");
        }
    }

    public static void test2() {
        int[] arrays = new int[100000];

//        long start1 = System.currentTimeMillis();
//        for(int k = 0; k < 10; k++) {
//            for(int i = 1; i <= arrays.length; i++) {
//                arrays[i-1] = new Random().nextInt(100) * 1000;
//            }
//            new BubbleSort().sort(arrays);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("BubbleSort: " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for(int k = 0; k < 10; k++) {
            for(int i = 1; i <= arrays.length; i++) {
                arrays[i-1] = new Random().nextInt(100) * 1000;
            }
            new SelectSort().sort(arrays);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("SelectSort: " + (end2 - start2));


        long start3 = System.currentTimeMillis();
        for(int k = 0; k < 10; k++) {
            for(int i = 1; i <= arrays.length; i++) {
                arrays[i-1] = new Random().nextInt(100) * 1000;
            }
            new InsertSort().sort(arrays);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("InsertSort: " + (end3 - start3));

        long start4 = System.currentTimeMillis();
        for(int k = 0; k < 10; k++) {
            for(int i = 1; i <= arrays.length; i++) {
                arrays[i-1] = new Random().nextInt(100) * 1000;
            }
            new QuickSort().sort(arrays);
        }
        long end4 = System.currentTimeMillis();
        System.out.println("QuickSort: " + (end4 - start4));

    }
}
