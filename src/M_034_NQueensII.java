import java.util.ArrayList;
import java.util.List;

/**
 * 根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
 */
public class M_034_NQueensII {


    public static void main(String[] args) {
        System.out.println(new M_034_NQueensII().totalNQueens(8));
    }

    /** 结果数量 */
    private int result = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return result;
        }
        search(new ArrayList<Integer>(), n);
        return result;
    }

    private void search(List<Integer> cols, int n) {
        if (cols.size() == n) {
            result++;
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(cols, n);
            cols.remove(cols.size() - 1);
        }
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
