/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class M_117_Jump {

    /**
     * 基于贪心的思想。
     * 假设当前(位置i)能够跳最远的范围为[curBegin, curEnd],
     * curFarther是在[curBegin, curEnd]范围内能够跳的最远距离(位置)。
     * 一旦当前位置(i)到达curEnd, 那么就会触发一次跳跃，并且设置curEnd等于curFarthest。
     * 按照上面的步骤，直到跳跃到最后一个位置为止。
     */
    public int jump(int[] A) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < A.length - 1; ++i) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curFarthest >= A.length - 1) {
                    return jumps;
                }
            }
        }
        return curFarthest >= A.length - 1 ? jumps : -1;
    }
}
