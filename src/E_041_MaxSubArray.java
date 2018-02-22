/**
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class E_041_MaxSubArray {
    /**
     * 贪心算法
     * 前面连续子和为负数时，即Sum前<0时，当即果断丢弃，因为只会越加越小。
     * 假设数组的前两个数加和为负数，再往后加时如果带上这两个数只能让数变小，
     * 因此子数组一定不包括这两个数，由此我们可以判断当连续的子数组加和后出现负数
     * 说明到目前这个数为止前面的数加起来只能提供“负面影响”，要找更大的和后面的数要从头开始加和。
     * 因此不妨选定第一个元素为max，之后对数组的元素进行加和，若和变大则更新最大和max
     */
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = A[0], sum = 0;
        for (int a : A) {
            sum += a;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
