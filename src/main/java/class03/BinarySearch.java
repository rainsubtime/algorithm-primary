package class03;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = randomLenRandomValue(20,10);
        Arrays.sort(arr);
        printArray(arr);
        System.out.println(find(arr,5));
    }

    private static int[] randomLenRandomValue(int maxLen,int maxValue){
        int len = (int)(Math.random() * maxLen + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random() * maxValue + 1);
        }
        return arr;
    }

    private static int find(int[] arr,int num){
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while(L <= R){
            M = (L + R) / 2;
            if(arr[M] == num){
                return M;
            } else if (arr[M] < num) {
                L = M + 1;
            } else if (arr[M] > num) {
                R = M - 1;
            }
        }
        return -1;
    }

    public static void printArray(int[] nums){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            stringBuilder.append(" ");
            stringBuilder.append(nums[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
