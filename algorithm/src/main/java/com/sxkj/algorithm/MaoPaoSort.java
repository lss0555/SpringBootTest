package com.sxkj.algorithm;

/**
 *
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,10,0,3,1};
        maopao(arr);
        for (int i:arr){
            System.out.println(i);
        }
    }

    public static void maopao(int[] arr){
        //从从到尾开始遍历
        for (int i = 0; i < arr.length; i++) {
            //从头开始遍历把最大值放在最后面
            for (int j = 1; j < arr.length - i; j++) {
                int temp = arr[j - 1];
                //如果前面比后面数据大，则交换数据
                if (temp > arr[j]) {
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
