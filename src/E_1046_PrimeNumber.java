import java.util.HashSet;
import java.util.Set;

/**
 * Prime Number of Set Bits in Binary Representation
 */
public class E_1046_PrimeNumber {

    public static void main(String[] args) {
        new E_1046_PrimeNumber().countPrimeSetBits(6, 10);
    }

    /**
     * 因为R最多为10^6，所以最大的数字转换成二进制是20位，直接对素数打表
     */
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primeSet = new HashSet<>();
        int[] arrays = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        for (int prime : arrays) {
            primeSet.add(prime);
        }
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (primeSet.contains(getBitOneCount(i))) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取n的二进制中1的个数
     */
    private int getBitOneCount(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}
