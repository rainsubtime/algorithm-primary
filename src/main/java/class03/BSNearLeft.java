package class03;

import java.util.Arrays;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class03
 * @Author: cywork
 * @CreateTime: 2023-09-20  09:26
 * @Description: find the leftmost num
 * @Version: 1.0
 */
public class BSNearLeft {

    public static void main(String[] args) {

        int maxValue = 20;
        int maxLen = 10;
        int[] arr = randomLenAndValue(maxLen, maxValue);
        Arrays.sort(arr);
        printArr(arr);
        int i = find(arr, 5);
        System.out.println();
        System.out.println(i);
    }

    public static int find(int[] arr,int num){
        int N = arr.length - 1;
        int L = 0;
        int R = N;
        int T = -1;
        while( L <= R ){
            int M = (L + R) / 2;
            if(arr[M] >= num){
                T = M;
                R = M - 1;
            } else if (arr[M] < num) {
                L = M + 1;
            }
        }
        return T;
    }

    public static int[] randomLenAndValue(int maxLen, int maxValue){
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0 ; i < len ; i ++ ){
            arr[i] = (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for (int item : arr){
            System.out.print(item + " ");
        }
    }



    public Boolean testMethod(int a,int b,int c){
        boolean result = false;
        if(a == 1 && b == 2 || c == 3){
            result = true;
        }
        return result;
    }
}
