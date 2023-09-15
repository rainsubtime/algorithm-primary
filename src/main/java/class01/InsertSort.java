package class01;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class01
 * @Author: cywork
 * @CreateTime: 2023-09-15  09:42
 * @Description: TODO
 * @Version: 1.0
 */
public class InsertSort {

    private static void Sort(Integer[] original) {
        for (int i = 1; i < original.length; i++) {
            for (int j = i; j - 1 >= 0 && (original[j] < original[j - 1]); j--) {
                swap(original, j, j - 1);
            }
        }
    }

    public static void swap(Integer[] arr,int a ,int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(Integer[] nums){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            stringBuilder.append(" ");
            stringBuilder.append(nums[i]);
        }
        System.out.println(stringBuilder.toString());
    }


    public static void main(String[] args) {
        Integer[] nums = {9,1,2,5,8,0,6,3,5,7,4};
        printArray(nums);
        Sort(nums);
        printArray(nums);
    }


}
