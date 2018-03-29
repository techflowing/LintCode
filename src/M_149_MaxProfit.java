/**
 * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 * 给出一个数组样例 [3,2,3,1,2], 返回 1
 */
public class M_149_MaxProfit {

    /**
     * 遍历
     * 依次比较如果当前天卖出能获得的最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(prices[i] - min, result);
        }
        return result;
    }
}
