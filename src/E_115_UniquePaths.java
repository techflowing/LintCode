/**
 * "不同的路径" 的跟进问题：
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 */
public class E_115_UniquePaths {
    /**
     * 动态规划
     * sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
     * 与{@link E_114_UniquePaths} 类似，主要在单独处理一下障碍的位置
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }
        return paths[n - 1][m - 1];
    }
}
