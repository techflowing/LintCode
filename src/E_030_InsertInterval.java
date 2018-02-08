
import model.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class E_030_InsertInterval {


    public List<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (newInterval == null || intervals == null) {
            return intervals;
        }
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(insertPos, newInterval);
        return result;
    }
}
