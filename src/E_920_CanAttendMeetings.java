import model.Interval;

import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * Given intervals = [[0,30],[5,10],[15,20]], return false
 */
public class E_920_CanAttendMeetings {

    /**
     * 区间先排序，然后再判断区间是否有交叉
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < end) {
                return false;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        return true;
    }
}
