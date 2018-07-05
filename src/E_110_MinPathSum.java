/**
 * 给定一个只含非负整数的m*n网格，
 * 找到一条从左上角到右下角的可以使数字和最小的路径
 */
public class E_110_MinPathSum {

    /**
     * 第一列和第一行要单独处理，每一点的值等于自身的值加上上一点的值，
     * 对于中间节点：grid[i][j] + = min( grid[i-1][j] , grid[i][j-1])
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (row <= 0 || col <= 0) {
            return 0;
        }
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
}
