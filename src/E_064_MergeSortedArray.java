/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * <p>
 * 注意事项
 * 你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素
 */
public class E_064_MergeSortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}
