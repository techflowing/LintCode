import model.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给出若干闭合区间，合并所有重叠的部分。
 */
public class E_156_MergeIntervals {

    /**
     * 先对区间排序，保证 区间1 的start值小于 区间2 的start值
     * 再逐个比较相邻区间的end值
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval prev = null;
        for (Interval item : intervals) {
            if (prev == null || prev.end < item.start) {
                ans.add(item);
                prev = item;
            } else {
                prev.end = Math.max(prev.end, item.end);
            }
        }
        return ans;
    }
}
