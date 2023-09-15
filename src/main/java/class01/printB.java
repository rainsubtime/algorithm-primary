package class01;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class01
 * @Author: cywork
 * @CreateTime: 2023-09-13  13:44
 * @Description: TODO
 * @Version: 1.0
 */
public class printB {

    public static void main(String[] args) {
        int num = 981273;
        for(int i = 0; i < 32; i++){
            System.out.print((num & (1 << i)) == 0 ? 1 : 0);
        }
    }

}
