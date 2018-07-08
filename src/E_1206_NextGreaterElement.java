import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个数组（无重复）nums1 与 nums2，其中nums1的元素是nums2的子集。
 * 在nums2中寻找大于nums1中对应位置且距离最近(向右)的元素。
 * 如果对应位置不存在这样的元素，则输出-1。
 * <p>
 * nums1与nums2中的所有元素都是唯一的。
 * nums1与nums2的元素个数不超过1000。
 */
public class E_1206_NextGreaterElement {
    /**
     * 建立每个数字和其右边第一个较大数之间的映射，没有的话就是-1。
     * 遍历原数组中的所有数字，如果此时栈不为空，且栈顶元素小于当前数字，
     * 说明当前数字就是栈顶元素的右边第一个较大数，那么建立二者的映射，
     * 并且去除当前栈顶元素，最后将当前遍历到的数字压入栈。
     * 当所有数字都建立了映射，那么最后可以直接通过哈希表快速的找到子集合中数字的右边较大值
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
