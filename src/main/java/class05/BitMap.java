package class05;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class05
 * @Author: cywork
 * @CreateTime: 2023-10-02  16:05
 * @Description: TODO
 * @Version: 1.0
 */
public class BitMap {

    long[] bitMap;

    public BitMap(int max){
        bitMap = new long[(max >> 6) + 1];
    }

    public void add(int value){
        bitMap[value >> 6] |= 1 << value;
    }

    public static void main(String[] args) {



    }

}
