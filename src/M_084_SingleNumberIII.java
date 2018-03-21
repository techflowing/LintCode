import java.util.ArrayList;
import java.util.List;

/**
 * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
 */
public class M_084_SingleNumberIII {

    /**
     * 把将所有数异或之后得到的是两个落单的数的异或结果，没办法将结果拆分成两个落单的数。
     * 但因为两个落单数不同，所以肯定存在某个位k，使得两落单数在第k位上一个为0另一个为1，怎么找到这个k?
     * 找异或结果中1出现的位置即可。只需找到最小的这个k，然后将在k位上为0的所有数做异或，
     * 其他的在k位为1的所有数也做另外的异或，这样最终可以得到两个落单的数
     */
    public List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((lastBit & A[i]) == 0) {
                group0 ^= A[i];
            } else {
                group1 ^= A[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }
}
