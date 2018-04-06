import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 给出数组[100, 4, 200, 1, 3, 2]，这个最长的连续序列是 [1, 2, 3, 4]，返回所求长度 4
 */
public class M_124_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            longest = Math.max(longest, up - down - 1);
        }

        return longest;
    }
}
