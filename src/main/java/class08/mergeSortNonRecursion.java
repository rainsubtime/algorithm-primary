package class08;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class08
 * @Author: cywork
 * @CreateTime: 2023-10-27  13:13
 * @Description: TODO
 * @Version: 1.0
 */
public class mergeSortNonRecursion {

    public static void mergeSort(int[] arr){
        if(arr.length == 0 || arr.length < 2){
            return;
        }
        int step = 1;
        int N = arr.length - 1;
        while(step < N){
            int L = 0;
            int M = 0;
            int R = 0;
            while(L < N){
                if(N - L + 1 < step){
                    M = L + step - 1;
                }else {
                    break;
                }
                if(N - M < step){
                    R = M + step;
                }else {
                    R = N;
                }
                if(R == M){
                    break;
                }

                merge(arr,L,M,R);
                if(R + 1 < N){
                    break;
                }
                L = R + 1;
            }
            if(step > N / 2){
                break;
            }else
                step *= 2;
        }
    }

    public static void merge(int[] arr,int L,int M,int R){
        int p1 = L;
        int p2 = M + 1;
        int[] intTemp = new int[R - L + 1];
        int index = 0;
        while(p1 <= M && p2<= R){
            if(arr[p1] <= arr[p2]){
                intTemp[index++] = arr[p1++];
            }else{
                intTemp[index++] = arr[p2++];

            }
        }
        while(p1 <= M){
            intTemp[index++] = arr[p1++];
        }
        while(p2 <= R){
            intTemp[index++] = arr[p2++];
        }
        for(int i = 0;i < intTemp.length;i ++ ){
            arr[L + i] = intTemp[i];
        }
    }
}
