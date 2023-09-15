package class01;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class01
 * @Author: cywork
 * @CreateTime: 2023-09-14  17:21
 * @Description: TODO
 * @Version: 1.0
 */
public class BubleSort {

    private static void Sort(Integer[] original){
        for (int i = original.length - 1; i > 0;i--){
            //大的往后冒
            for(int j = 0 ; j < i ; j ++ ){
                if(original[j] > original[j+1]){
                    swap(original,j,j+1);
                }
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
        Integer[] nums = {1,2,2,5,8,2,6,3,5,7,2};
        printArray(nums);
        Sort(nums);
        printArray(nums);
    }


}
