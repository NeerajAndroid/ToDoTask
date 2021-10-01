package com.example.practicekotlin;

public class TestJava {

    public static void test(){
         //arr = [3,4,8,3,1,3]
        int[] arr = new int[]{3,4,8,3,1,3};
        for(int i =0; i<arr.length;i++){
            for(int j = i+1;j<arr.length - 1;j++){
                if(arr[i] == 3){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for ( int i : arr){
            System.out.println(i+" ");
        }
    }
}
