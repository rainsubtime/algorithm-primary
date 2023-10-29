package class08;

import java.util.Stack;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class08
 * @Author: cywork
 * @CreateTime: 2023-10-27  18:47
 * @Description: TODO
 * @Version: 1.0
 */
public class quickSortNonRecursion {

    public static class Job{
        int L;
        int R;
        Job(int L,int R){
            this.L = L;
            this.R = R;
        }
    }

    public static void quickSort(int[] arr){
        if(arr.length == 0 || arr.length < 2){
            return;
        }
        Stack<Job> jobStack = new Stack<>();
        jobStack.push(new Job(0, arr.length - 1));
        while(!jobStack.isEmpty()){
            Job pop = jobStack.pop();
            int[] partition = partition(arr, pop.L, pop.R);
            if(partition[0] > pop.L){
                jobStack.push(new Job(pop.L,partition[0] - 1));
            }
            if(partition[1] < pop.R){
                jobStack.push(new Job(partition[1] + 1,pop.R));
            }
        }

    }

    public static int[] partition(int[] arr,int L,int R){
        int lessR = L - 1;
        int thanL = R;
        int p = L;
        while(p < thanL){
            if(arr[p] < arr[R]){
                swap(arr,p++,++lessR);
            }else if (arr[p] == arr[R]){
                p++;
            }else {
                swap(arr,p,--thanL);
            }
        }
        swap(arr,R,thanL);
        return new int[]{lessR + 1,thanL - 1};
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,4,2,3,7,3,6};

        quickSort(array);
        for(int i = 0; i < array.length; i ++){
            System.out.print(array[i] + " ");
        }
    }
}
