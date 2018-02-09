import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
 * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
 * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
 * <p>
 * 输出示例：[
 * // Solution 1
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."
 * ],
 * // Solution 2
 * ["..Q.",
 * "Q...",
 * "...Q",
 * ".Q.."
 * ]
 * ]
 */
public class M_033_NQueens {

    public static void main(String[] args) {
        new M_033_NQueens().solveNQueens(8);
    }

    /**
     * 把棋盘存储为一个N维数组a[N]，数组中第i个元素的值代表第i行的皇后位置，这样便可以把问题的空间规模压缩为一维O(N)，
     * 在判断是否冲突时也很简单，首先每行只有一个皇后，且在数组中只占据一个元素的位置，行冲突就不存在了，其次是列冲突，
     * 判断一下是否有a[i]与当前要放置皇后的列j相等即可。
     * 至于斜线冲突，通过观察可以发现所有在斜线上冲突的皇后的位置都有规律即它们所在的行列互减的绝对值相等，
     * 即| row – i | = | col – a[i] | 。这样某个位置是否可以放置皇后的问题已经解决。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }

    /**
     * 循环搜索棋局，找出所有结果
     * 1）从第一行开始，为皇后找到安全位置，然后跳到下一行
     * 2）如果在第i行出现死胡同，该行为第一行，棋局失败，否则后退到上一行，再进行回溯
     * 3）如果在第n行上找到了安全位置，则棋局成功。
     *
     * @param results 存储结果
     * @param cols    棋盘存储维为一维数组
     * @param n       皇后个数
     */
    private void search(List<List<String>> results,
                        List<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            // 数据结构决定不会在同一行，此处判断是否在同一列
            if (cols.get(rowIndex) == column) {
                return false;
            }
            // 判断是否处于同一斜线
            if (Math.abs(row - rowIndex) == Math.abs(column - cols.get(rowIndex))) {
                return false;
            }
        }
        return true;
    }

}
