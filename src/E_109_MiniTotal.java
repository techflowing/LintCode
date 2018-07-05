/**
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。
 * 每一步可以移动到下面一行的相邻数字上。
 */
public class E_109_MiniTotal {
    /**
     * 动态规划
     * 从三角形底部到上部移动
     */
    public int minimumTotal(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}

