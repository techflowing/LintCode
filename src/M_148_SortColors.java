/**
 * 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。
 * 我们可以使用整数 0，1 和 2 分别代表红，白，蓝。
 */
public class M_148_SortColors {

    /**
     * 扫描一遍，扫描到0时往前面放，扫描到2时往后面放，分别用两个变量记住首端0和末尾2的位置。
     */
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0;
        int right = a.length - 1;
        int i = 0;
        while (i <= right) {
            if (a[i] == 0) {
                swap(a, left, i);
                left++;
                i++;
            } else if (a[i] == 1) {
                i++;
            } else {
                swap(a, right, i);
                right--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
