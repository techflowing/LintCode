import java.util.ArrayList;

/**
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 */
public class E_046_MajorityNumber {
    /**
     * 可以把这些数看做两种类型，一种主元素，一种非主元素；
     * 如果每次我们都从这两种类型中各拿走一个数，知道其中一种类型的数拿光，
     * 则最后，剩下的一种类型必定会是主元素类型
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count++;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
