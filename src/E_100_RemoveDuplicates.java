/**
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 */
public class E_100_RemoveDuplicates {

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }
}
