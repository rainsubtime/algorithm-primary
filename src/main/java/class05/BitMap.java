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

    public void add(int num){
        bitMap[num >> 6] |= 1L << (num & 63);
    }

    public void del(int num){
        bitMap[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num){
         return (bitMap[num >> 6] & 1L << (num & 63)) > 0;
    }

    public static void main(String[] args) {
        BitMap bitMap1 = new BitMap(10);
        bitMap1.add(1);
        System.out.println(bitMap1.contains(1));
        bitMap1.del(1);
        System.out.println(bitMap1.contains(1));


    }

}
