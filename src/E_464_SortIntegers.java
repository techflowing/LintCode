/**
 * 给一组整数，按照升序排序。使用归并排序，快速排序，堆排序或者任何其他 O(n log n) 的排序算法。
 */
public class E_464_SortIntegers {
    /**
     * 快速排序
     */
    public void sortIntegers2(int[] A) {
        int left = 0;
        int right = A.length - 1;
        sort(A, left, right);
    }

    public void sort(int[] arr, int left, int right) {
        int i, j, temp;
        if (left > right) {
            return;
        }
        temp = arr[left];
        i = left;
        j = right;
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}


