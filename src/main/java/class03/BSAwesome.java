package class03;

import javax.swing.*;
import java.util.Arrays;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class03
 * @Author: cywork
 * @CreateTime: 2023-09-20  18:36
 * @Description: TODO
 * @Version: 1.0
 */
public class BSAwesome {

    public static void main(String[] args) {

        int maxValue = 200;
        int maxLen = 200;
        int times = 20000;
        for (int i = 0;i < times ; i++){
            int[] arr = randomLenAndValue(maxLen, maxValue);
            //int[] arr = {15,0,13,12,0,4,14};
            int ans = find(arr);
            if(!check(arr,ans)){
                System.out.println("出错了");
                System.out.print("数组是：");
                printArr(arr);
                System.out.println("找到的数的下标是" + ans);
                break;
            }
        }
    }

    public static int find(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1){
            return 0;
        }
        int N = arr.length - 1;
        int L = 0;
        int R = N;
        if (arr[L] < arr[L + 1]) {
            return L;
        }
        if (arr[R] < arr[R - 1]) {
            return R;
        }

        while (L <= R) {
            int M = (L + R) / 2;
            if (L >= R - 1){
                return arr[L] > arr[R] ? R : L;
            }
            if (arr[M] < arr[M - 1] && arr[M] < arr[M + 1 ]) {
                return M;
            }
            if (arr[M] > arr[M - 1]) {
                R = M - 1;
                continue;
            }
            if (arr[M + 1] < arr[M]) {
                L = M + 1;
            }
        }
        return -1;
    }

    public static int[] randomLenAndValue(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen) + 1;
        int[] arr = new int[len];
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < len; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }


    public static Boolean check(int[] arr, int minIndex) {
        boolean LBigger = false;
        boolean RBigger = false;
        try {
            if (arr.length == 1 && minIndex == -1) {
                return true;
            }
            if (minIndex == -1) {
                if (arr[0] < arr[1] || arr[arr.length - 1] < arr[arr.length - 2]) {
                    return false;
                }
                for (int i = 1; i < arr.length - 1; i++) {
                    if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                        return false;
                    }
                }
                return true;
            }
            int L = minIndex - 1;
            int R = minIndex + 1;
            LBigger = L >= 0 ? arr[L] > arr[minIndex] : true;
            RBigger = R <= arr.length - 1 ? arr[R] > arr[minIndex] : true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常，数组内容为：" + Arrays.toString(arr));
            System.out.println("答案为" + minIndex);
        }

        return LBigger && RBigger;

    }

    public static Boolean check2(int[] arr, int minIndex) {
        if(arr.length == 0){
            return minIndex == -1;
        }
        int L = minIndex - 1;
        int R = minIndex + 1;
        boolean LBigger = L >= 0 ? arr[L] > arr[minIndex] : true;
        boolean RBigger = R <= arr.length - 1 ? arr[R] > arr[minIndex] : true;
        return LBigger && RBigger;
    }

}
