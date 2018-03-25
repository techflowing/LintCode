import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 返回两个数组的交
 * nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class E_548_Intersection {

    /**
     * 与{@link E_547_Intersection} 不同的是，交集没有去重
     * 解法一：使用HashMap记录出现的数字和次数，然后比较
     * 解法二：排序后，双指针逐个比较
     * 此处使用解法二
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] array = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            array[index++] = integer;
        }
        return array;
    }
}
