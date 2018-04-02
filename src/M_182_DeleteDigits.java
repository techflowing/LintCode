/**
 * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。
 * 找到删除 k 个数字之后的最小正整数。
 * <p>
 * N <= 240, k <= N
 */
public class M_182_DeleteDigits {
    /**
     * 为了得到更小的数字我们需要把小数字放在前面，那么我们就要把在当前数字前并且比当前数字大的数删掉，
     * 所以我们从头开始遍历，找到比当前数大的就删除，直到删除k个数为止
     */
    public String DeleteDigits(String A, int k) {
        StringBuffer sb = new StringBuffer(A);
        int i, j;
        for (i = 0; i < k; i++) {
            j = 0;
            while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
                j++;
            }
            sb.delete(j, j + 1);
        }
        // 去除前置0
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }
}
