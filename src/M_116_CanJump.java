/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 判断你是否能到达数组的最后一个位置。
 */
public class M_116_CanJump {

    /**
     * 遍历一遍，记录可走的点可以达到的最远点
     */
    public boolean canJump(int[] A) {

        if (A == null || A.length == 0) {
            return false;
        }
        int maxJump = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxJump < i) {
                return false;
            }
            maxJump = Math.max(i + A[i], maxJump);
        }
        return maxJump >= A[A.length - 1];
    }
}
