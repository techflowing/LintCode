import java.util.ArrayList;

/**
 * Created by yuanzeng on 18/2/23.
 */
public class E_044_MinSubArray {

    /**
     * 贪心算法
     * 参照{@link E_041_MaxSubArray}
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int min = nums.get(0);
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }
        return min;
    }
}
