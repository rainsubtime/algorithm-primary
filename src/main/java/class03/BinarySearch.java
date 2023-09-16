package class03;

public class BinarySearch {

    public static void main(String[] args) {

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
        while(L < R && arr[M] != num){
            M = (L + R) / 2;

        }
        return 1;
    }
}
