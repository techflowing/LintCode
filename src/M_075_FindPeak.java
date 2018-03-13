/**
 * 你给出一个整数数组(size为n)，其具有以下特点：
 * <p>
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 */
public class M_075_FindPeak {
    /**
     * 二分查找
     */
    public int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //如果中间的数比后一位数大的话，peek点肯定在mid左边或是mid。
            //如果中间的数比前一位数小的话，peek点肯定在mid右边或是mid。
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }

        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
