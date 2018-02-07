import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含不同整数的集合，返回其所有的子集
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 */
public class M_017_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }


    /**
     * 在 nums 中找到所有以 subset 开头的的集合，并放到 results
     */
    private void dfs(ArrayList<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {

        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            dfs(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

    }
}
