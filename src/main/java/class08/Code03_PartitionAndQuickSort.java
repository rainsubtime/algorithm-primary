package class08;

import java.util.Stack;

// 可以去体系学习班学习
public class Code03_PartitionAndQuickSort {

	public static void splitNum1(int[] arr) {
		int R = arr.length - 1;
		int lessR = -1;
		int p = 0;
		while( p < arr.length){
			if(arr[p] <= arr[R]){
				swap(arr,++lessR,p++);
			}else {
				p++;
			}
		}
	}

	public static void splitNum2(int[] arr) {
		int R = arr.length - 1;
		int lessR = -1;
		int thanL = arr.length - 1;
		int p = 0;
		while( p < thanL){
			if(arr[p] < arr[R]){
				swap(arr,++lessR,p++);
			}
			if(arr[p] == arr[R]){
				p++;
			}
			if(arr[p] > arr[R]){
				swap(arr,--thanL,p);
			}
		}
		swap(arr,R,thanL);
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// arr[L...R]范围上，拿arr[R]做划分值，
	// L....R < = >
	public static int[] partition(int[] arr, int L, int R) {
		int thanL = R;
		int lessR = L - 1;
		int p = L;
		while(p < thanL){
			if(arr[p] < arr[R]){
				swap(arr,++lessR,p++);
			}
			if(arr[p] > arr[R]){
				swap(arr,--thanL,p);
			}
			if(arr[p] == arr[R]){
				p++;
			}

		}
		swap(arr,R,thanL);
		return new int[]{lessR + 1,thanL};

	}

	public static void quickSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}

	public static void process(int[] arr, int L, int R) {
		if(L >= R){
			return;
		}
		int[] ints = partition(arr, L, R);
		process(arr,L,ints[0]-1);
		process(arr,ints[1]+1,R);
	}

	public static class Job {
		public int L;
		public int R;

		public Job(int left, int right) {
			L = left;
			R = right;
		}
	}

	public static void quickSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		Stack<Job> stack = new Stack<>();
		stack.push(new Job(0, arr.length - 1));
		while (!stack.isEmpty()) {
			Job cur = stack.pop();
			int[] equals = partition(arr, cur.L, cur.R);
			if (equals[0] > cur.L) { // 有< 区域
				stack.push(new Job(cur.L, equals[0] - 1));
			}
			if (equals[1] < cur.R) { // 有 > 区域
				stack.push(new Job(equals[1] + 1, cur.R));
			}
		}
	}

	public static int[] netherlandsFlag(int[] arr, int L, int R) {
		if (L > R) {
			return new int[] { -1, -1 };
		}
		if (L == R) {
			return new int[] { L, R };
		}
		int less = L - 1;
		int more = R;
		int index = L;
		while (index < more) {
			if (arr[index] == arr[R]) {
				index++;
			} else if (arr[index] < arr[R]) {
				swap(arr, index++, ++less);
			} else {
				swap(arr, index, --more);
			}
		}
		swap(arr, more, R); // <[R] =[R] >[R]
		return new int[] { less + 1, more };
	}

	public static void quickSort3(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process3(arr, 0, arr.length - 1);
	}

	public static void process3(int[] arr, int L, int R) {
		if (L >= R) {
			return;
		}
		swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
		int[] equalArea = netherlandsFlag(arr, L, R);
		process3(arr, L, equalArea[0] - 1);
		process3(arr, equalArea[1] + 1, R);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int[] arr = { 1,3,2,4 };

		quickSort1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		//int testTime = 500000;
		//int maxSize = 100;
		//int maxValue = 100;
		//boolean succeed = true;
		//System.out.println("test begin");
		//for (int i = 0; i < testTime; i++) {
		//	int[] arr1 = generateRandomArray(maxSize, maxValue);
		//	int[] arr2 = copyArray(arr1);
		//	int[] arr3 = copyArray(arr1);
		//	quickSort1(arr1);
		//	quickSort2(arr2);
		//	quickSort3(arr3);
		//	if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3)) {
		//		System.out.println("Oops!");
		//		succeed = false;
		//		break;
		//	}
		//}
		//System.out.println("test end");
		//System.out.println(succeed ? "Nice!" : "Oops!");

	}

}
