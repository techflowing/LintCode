import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含不同整数的集合，返回其所有的子集
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 */
public class M_017_Subsets_1 {

    /**
     * 用bit位来表示这一位的number要不要取，第一位有1，0即取和不取2种可能性。所以只要把0到N种可能
     * 都用bit位表示，再把它转化为数字集合，就可以了
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

}
