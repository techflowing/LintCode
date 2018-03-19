/**
 * 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 */
public class M_083_SingleNumberII {
    /**
     * 按位计算。int型数字占32位，如果这个数字出现3次，则与这个数字对应的每一位上的1也出现三次。
     * 使用int型数组记录每一位上1出现的次数，能被3整除则表示出现3次。最后得到的就是要求的数字。
     */
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }

            result |= (bits[i] << i);
        }
        return result;
    }
}
