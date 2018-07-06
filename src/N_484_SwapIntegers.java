/**
 * 给你一个数组和两个索引，交换下标为这两个索引的数字
 */
public class N_484_SwapIntegers {
    public void swapIntegers(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
