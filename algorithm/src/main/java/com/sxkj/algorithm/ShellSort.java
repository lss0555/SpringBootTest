package com.sxkj.algorithm;
//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,10,0,3,1};
        shellSort(arr);
        System.out.println("排序后数组：");
        for (int i:arr){
            System.out.println(i);
        }
    }
    public static void shellSort(int[] arr) {
        //计算数组总长度
        int length = arr.length;
        //临时存放值
        int temp;
        //每次step取长度的一半
        for (int step = length / 2; step >= 1; step /= 2) {
            //遍历
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
