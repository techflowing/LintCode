/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，
 * 并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
 * 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
 * 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 * <p>
 * 注意事项
 * 数据保证答案唯一。
 * <p>
 * 现在有4个加油站，汽油量gas[i]=[1, 1, 3, 1]，环路旅行时消耗的汽油量cost[i]=[2, 2, 1, 1]。
 * 则出发的加油站的编号为2。
 */
public class M_187_CanCompleteCircuit {
    /**
     * 从起点start开始走，当我们走到第i个加油站发现不足以走到i+1个加油站时我们不需要从start+1开始查找，
     * 因为既然从start开始到不了i+1那么从start到i中间的任意一节点开始都是到不了i+1的，
     * 所以下一个我们就可以从i+1开始检查，直到发现满足条件的
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = -1;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        // 判断是否有能环绕一圈，数组是个环形
        return total < 0 ? -1 : index + 1;
    }
}
