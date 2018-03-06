/**
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 */
public class M_063_SearchRotatedSortedArray {
    /**
     * 在搜索旋转数组的基础上 判断 left 和 mid 的值相等的情况
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[start] > A[mid]) {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }

        if (A[start] == target) {
            return true;
        }
        if (A[end] == target) {
            return true;
        }
        return false;
    }
}
