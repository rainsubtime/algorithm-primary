package class02;

public class validater {

    private static void Sort(int[] original) {
        for (int i = 1; i < original.length; i++) {
            for (int j = i; j - 1 >= 0 && (original[j] < original[j - 1]); j--) {
                swap(original, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(nums[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[] randomLenRandomValue(int maxLen,int maxValue){
        int len = (int)(Math.random() * maxLen + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random() * maxValue + 1);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = randomLenRandomValue(10,10);
        printArray(nums);
        Sort(nums);
        printArray(nums);
    }
}