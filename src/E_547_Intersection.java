import java.util.HashSet;

/**
 * 返回两个数组的交
 * nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 */
public class E_547_Intersection {

    /**
     * 使用Set，简单处理判断
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.add(nums1[i]);
        }
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash.contains(nums2[i]) && !result.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int size = result.size();
        int[] resultArray = new int[size];
        int index = 0;
        for (Integer num : result) {
            resultArray[index++] = num;
        }
        return resultArray;
    }
}
