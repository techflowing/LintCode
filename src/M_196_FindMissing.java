/**
 * 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数。
 */
public class M_196_FindMissing {
    /**
     * 计算应该的数组和 - 实际的数组和
     */
    public int findMissing(int[] nums) {
        long N = nums.length;
        long sum = N * (N + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return (int) sum;
    }
}
