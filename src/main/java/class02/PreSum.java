package class02;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class02
 * @Author: cywork
 * @CreateTime: 2023-09-15  10:40
 * @Description: TODO
 * @Version: 1.0
 */
public class PreSum {

    public static void main(String[] args) {
        int[] nums = {9,2,3,6,2,7,4,2,7,8,1};
        int[] preSums = new int[nums.length];
        preSums[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            preSums[i] = nums[i] + preSums[i-1];
        }
        printArray(nums);
        printArray(preSums);
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
