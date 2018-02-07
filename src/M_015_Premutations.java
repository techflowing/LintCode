import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字列表，返回其所有可能的排列。
 * 假设没有重复数字。
 */
public class M_015_Premutations {

    /**
     * 使用递归来实现，递归里面利用了回溯法和深度优先搜索。
     * 假如有1，2，3，那么第一层递归的第一层循环里会往list里面加入1，调用第二层递归加入2，同样第三层递归加入了3，
     * 第四层递归已经加满了数，没有再加入数，直接返回，
     * 则执行第三层的remove一个数，执行第二层的remove，再递归加入3，递归里面再递归加入2，然后再remove 2,remove 3,remove 1,
     * 第一层递归第二次循环里加入2，递归加入1，再递归加入3,依次类推。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(result, list, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int[] nums) {
        int n = nums.length;
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            dfs(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
