/**
 * 最小成本爬楼梯
 */
public class E_1054_MinCost {

    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        for (int i = 2; i < cost.length + 1; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        return result[cost.length];
    }
}
