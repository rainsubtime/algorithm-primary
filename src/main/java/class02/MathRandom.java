package class02;

public class MathRandom {
    public static void main(String[] args) {
        //生成随机数0-1
        double random = Math.random();
        System.out.println(random);
        //生成随机数0-10整数
        int[] arr = new int[11];
        for(int i = 0;i < 100000;i ++){
            int num = (int)(Math.random() * 11);
            arr[num]++;
        }
        printArr(arr);

        int num = 0;
        //生成随机数0-1，并且每一个出现的概率为x^2
        for (int i = 0; i < 100000; i++) {
            if(randomNumPow2() < 0.3){
                num ++;
            }
        }
        System.out.println("=======================");
        System.out.println(((double)num / 100000));

    }

    private static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("数字" + i + "出现的次数为"  + arr[i]);
        }
    }

    private static double randomNumPow2(){
        return Math.max(Math.random(),Math.random());
    }

}
