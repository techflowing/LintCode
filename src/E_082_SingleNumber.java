/**
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class E_082_SingleNumber {

    /**
     * 两个相同的数异或为0
     */
    public int singleNumber(int[] A) {
        int length = A.length;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = num ^ A[i];
        }
        return num;
    }
}
