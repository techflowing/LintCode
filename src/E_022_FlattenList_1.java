import java.util.*;

/**
 * 给定一个列表，该列表中的每个要素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
 */
public class E_022_FlattenList_1 {

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> resultList = new ArrayList<>();
        Deque<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        while (!queue.isEmpty()) {
            NestedInteger nestedInteger = queue.poll();
            if (nestedInteger.isInteger()) {
                resultList.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> nestedIntegerList = nestedInteger.getList();
                for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                    queue.addFirst(nestedIntegerList.get(i));
                }
            }
        }
        return resultList;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
