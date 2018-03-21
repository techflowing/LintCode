/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。
 * 但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 */
public class E_111_ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 1;
        }
        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;
        for (int i = 2; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }
}
