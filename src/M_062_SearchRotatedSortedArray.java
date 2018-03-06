/**
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 */
public class M_062_SearchRotatedSortedArray {
    /**
     * 旋转数组实际上是两个递增数组的组成，且第一个数组中的任意一个值都大于第二个数组的最大值，还是用二分查找的思想。
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            // start 和mid 处于同一递增数组
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // start 和 mid 不处于同一递增数组，mid 和 end 处于另一个递增数组
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
