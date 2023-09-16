package class02;

public class RandomToRandom {

    public static void main(String[] args) {
        int times = 1000000;
        int[] arr = new int[8];
        for (int i = 0; i < times; i++) {
            int num = 0;
            do {
                num = (f2() << 2) + (f2() << 1) + (f2() << 0) + 1;
            }while (num == 8 || num == 9);
            arr[num] ++ ;
        }

        printArr(arr);
        System.out.println("====================");
        int count = 0;
        for (int i = 0; i < times; i++) {
            int num = f2();
            if(num == 0){
                count ++;
            }
        }
        System.out.println( (double)count / times);

    }

    //生成0-5范围内的任意整数
    private static int f1() {
        return (int) (Math.random() * 6);
    }

    private static int f2() {
        int ans = 0;
        return f1() > 2 ? 0 : 1;
    }

    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("数字" + i + "出现的次数为"  + arr[i]);
        }
    }
}
