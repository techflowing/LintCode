/**
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 */
public class N_463_SortIntegers {
    /**
     * 冒泡排序
     */
    public void sortIntegers(int[] A) {
        for (int i = A.length; i > 0; i--)
            for (int j = 0; j < i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
    }
}
