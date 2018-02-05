/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class E_006_MergeSortedArray {

    /**
     * 逐个数字比较
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[] arr = new int[lenA + lenB];
        int index = 0, i, j;
        for (i = 0, j = 0; i < lenA && j < lenB; ) {
            if (A[i] < B[j]) {
                arr[index++] = A[i++];
            } else {
                arr[index++] = B[j++];
            }
        }
        while (i < lenA) {
            arr[index++] = A[i++];
        }
        while (j < lenB) {
            arr[index++] = B[j++];
        }
        return arr;
    }
}
