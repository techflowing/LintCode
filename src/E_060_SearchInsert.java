/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * <p>
 * 你可以假设在数组中无重复元素。
 */
public class E_060_SearchInsert {
    /**
     * 结合二分查找的思想
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
