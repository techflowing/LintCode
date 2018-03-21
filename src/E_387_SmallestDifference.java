import java.util.Arrays;

/**
 * 给定两个整数数组（第一个是数组 A，第二个是数组 B），在数组 A 中取 A[i]，数组 B 中取 B[j]，
 * A[i] 和 B[j]两者的差越小越好(|A[i] - B[j]|)。返回最小差。
 */
public class E_387_SmallestDifference {
    /**
     * 排序后比较做差，逐渐缩小差值
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int ai = 0, bi = 0;
        int min = Integer.MAX_VALUE;
        while (ai < A.length && bi < B.length) {
            min = Math.min(min, Math.abs(A[ai] - B[bi]));
            if (A[ai] < B[bi]) {
                ai++;
            } else {
                bi++;
            }
        }
        return min;
    }
}
