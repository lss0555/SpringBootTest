package com.sxkj.algorithm;

/**
 * 插入排序算法
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,10,0,3,1};
        quickSort(arr);
        System.out.println("排序后数组：");
        for (int i:arr){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
                // 存在比其小的数，插入
                arr[j] = tmp;
            }
        }
    }
}
