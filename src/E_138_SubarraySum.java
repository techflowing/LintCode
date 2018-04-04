import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组，找到和为零的子数组。
 * 你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class E_138_SubarraySum {
    /**
     * 利用一个map记录从第一个元素开始到当前元素之和以及当前元素的下标，
     * 如果后面的连续元素之和为零那么sum不变，此时就找到了和为零的连续序列
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }

            map.put(sum, i);
        }

        return ans;
    }
}
