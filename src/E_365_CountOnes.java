/**
 * 计算在一个 32 位的整数的二进制表示中有多少个 1.
 */
public class E_365_CountOnes {
    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
