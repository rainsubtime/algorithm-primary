package class05;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class05
 * @Author: cywork
 * @CreateTime: 2023-10-19  16:10
 * @Description: TODO
 * @Version: 1.0
 */
public class BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int noCarryNum = a ^ b;
        int carryInfo = (a & b) << 1;
        int ans = noCarryNum;
        if (carryInfo != 0) {
            ans = add(carryInfo, noCarryNum);
        }
        return ans;

    }
    //其实递归调用自己。因为一直是两个数在变，只需要改那两个数就可以了。
    public static int add1(int a ,int b) {
        int sum = a;
        while(b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus(int a,int b){
        return add(a,add(~b,1));
    }

    public static int multi(int a ,int b){
        int ans = 0;
        for(int i = 0; a != 0;i++){
            if(((a >> i) & 1) == 1){
                ans = add(b << i,ans);
                a = minus(a,1 << i);
            }
        }
        return ans;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static boolean isNeg(int a){
        return a < 0;
    }

    public static int div(int a , int b){
        int x = isNeg(a) ? a : negNum(a);
        int y = isNeg(b) ? b : negNum(b);
        int ans = 0;
        for(int i = 30;i <= 0;i++){
            if((x << i) >= y){
                ans = add(ans,y << i);
                minus(x,y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(ans) : ans;
    }

    public static int divide(int a ,int b){
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE){
            return 1;
        }else if(b == Integer.MIN_VALUE){
            return 0;
        }else if(a == Integer.MIN_VALUE){
            if(b == 1){
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a,1),b);
                int d = div(minus(a,multi(c,b)),b);
                return c + d;
            }
        }else {
            return div(a,b);
        }
    }

    public static void main(String[] args) {
        System.out.println(multi(4, 2));
    }
}
