package com.sxkj.algorithm;

/**
 * 选择排序算法
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,10,0,3,1};
        selectsort(arr);
        System.out.println("排序后数组：");
        for (int i:arr){
            System.out.println(i);
        }
    }
    public static void selectsort( int[] arr){
        //记录最小值的索引
        int min = 0;
        //遍历 n-1 轮，最后一个数不用遍历比较
        for (int i = 0; i < arr.length - 1; i++) {
            min = i; //初始最小值为每轮循环的第一个数
            //遍历初始最小值后的所有数
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) { //判断是否存在比最小值小的数
                    min = j; //记录下标
                }
            }
            if (min != i) { //判断最小值的索引是否等于初始最小值的索引
                int temp = arr[min]; //不是则进行最小值交换
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
