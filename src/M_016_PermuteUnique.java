import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 */
public class M_016_PermuteUnique {

    /**
     * 1. 先对给定的序列nums进行排序，使得大小相同的元素排在一起。
     * 2. 新建一个visited数组，大小与nums相同，用来标记在本次DFS读取中，位置i的元素是否已经被添加到list中了。
     * 3. 根据思路可知，我们选择跳过一个数，当且仅当这个数与前一个数相等，并且前一个数未被添加到list中。
     * 4. 剩余思路参照{@link M_015_Premutations}
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, list, visited, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, boolean[] visited, int[] nums) {
        int n = nums.length;
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 只能连续地选，这样就可以避免生成重复的solution.
            // 例子：1 2 3 4 4 4 5 6 7 8
            // 444这个的选法只能:4, 44, 444连续这三种选法
            if (visited[i] || (i != 0 && visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
