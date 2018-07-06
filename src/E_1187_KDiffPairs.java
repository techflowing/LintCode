import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * K-diff Pairs in an Array
 */
public class E_1187_KDiffPairs {

    /**
     * 用一个set存储出现过的值，用于后续判断是否某个值已经有值与其成对。
     * 分为两种情况：
     * （1）k!=0，即找出差的绝对值为k的对数。
     * 只有set中不包含该值但包含了 该值-k，才能加入结果。
     * （2）k==0，即找出值相等的对数。
     * 再用一个sameSet存储所有已成对的值，避免同一个值加入结果多次。
     * 只有sameSet中不含该值，且set中包含了该值，才能加入结果。
     */
    public int findPairs(int[] nums, int k) {
        int len = nums.length, result = 0;
        Arrays.sort(nums);
        // 处理K不等于0
        Set<Integer> set = new HashSet<>();
        // 处理K等于0
        Set<Integer> sameSet = new HashSet<>();
        if (k != 0) {
            for (int num : nums) {
                if (!set.contains(num) && set.contains(num - k)) {
                    result++;
                }
                set.add(num);
            }
        } else {
            for (int num : nums) {
                if (!sameSet.contains(num) && set.contains(num)) {
                    result++;
                    sameSet.add(num);
                }
                set.add(num);
            }
        }
        return result;
    }
}
