package class08;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class08
 * @Author: cywork
 * @CreateTime: 2023-10-26  13:31
 * @Description: TODO
 * @Version: 1.0
 */
public class mergeSortPrectise {

    public static void mergeSort(int[] arr){
        process(arr,0, arr.length-1);
    }

    public static void process(int[] arr,int L,int R){
        if(L >= R){
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr,L,M);
        process(arr,M+1,R);
        //后递归序
        int p1 = L;
        int p2 = M + 1;
        int[] tempArray = new int[R - L + 1];
        int index = 0;
        while(p1 <= M && p2 <= R){
            if(arr[p1] <= arr[p2]){
                tempArray[index] = arr[p1];
                p1++;
            }else {
                tempArray[index] = arr[p2];
                p2++;
            }
            index++;


        }
        while(p1 <= L){
            tempArray[index] = arr[p1];
            index ++;
            p1++;
        }
        while (p2 <= R){
            tempArray[index] = arr[p2];
            index ++;
            p2++;
        }
        for(int i = 0;i < tempArray.length;i++){
            arr[L + i] = tempArray[i];
        }
    }

    public static void main(String[] args) {

        int[] ints = {1,3,2,4};
        mergeSort(ints);
        for (int i = 0;i < ints.length;i ++){
            System.out.print(ints[i] + " ");
        }
    }

}
