import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * LFU是一个著名的缓存算法
 * 实现LFU中的set 和 get
 * <p>
 * 1.cache由键值对组成《key，map》，由于hashmap里面key（相当于数组的下标）是唯一的。
 * <p>
 * 2.所有的get操作，我们都是直接查看是否存在，如果不存在这个key，直接返回-1.如果存在这个key，
 * 那么更新访问的时间（访问时间来确定哪一个更久没有被访问了），同时访问次数增加。
 * <p>
 * 3.我们用两个属性来保存每一个键值对的状态，一个是调用的次数，一个是最近调用的时间。
 * <p>
 * 4.在set的时候，如果存在这个key，使用次数直接加一次，更新使用的时间，更新成最新的value；
 * 否则，创建一个新的键值对，赋予value，调用时间，在这里顺便判断是否容量为0，为0则不进行任何操作。
 * 如果容量还没有使用完，则直接插入，如果已经满了，那么我们要移除一个最不常使用而且最久没有使用的，再进行插入。
 * <p>
 * 5.移除的原则：找到使用次数最少的，如果有相同使用次数的，那么直接删除掉使用次数最少的里面最久没有使用的那个。
 * <p>
 * 6.使用的时间属性：set的时候更新，get的时候也要更新。
 * <p>
 * 7.调用次数更新：get和set的时候，只要存在就会加一次。
 */
public class H_024_LFUCache {

    private Map<String, Node> cache = null;
    private int capacity = 0;
    private int used = 0;

    public H_024_LFUCache(int capacity) {
        cache = new HashMap<String, Node>(capacity, 0.75f);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(String.valueOf(key));
        if (node == null) {
            return -1;
        }
        node.useCount++;
        node.lastGetTime = System.nanoTime();
        return node.value;
    }

    public void set(int key, int value) {
        Node n = cache.get(String.valueOf(key));
        if (n != null) {
            n.useCount++;
            n.lastGetTime = System.nanoTime();
            n.value = value;
            return;
        } else {
            Node node = new Node();
            node.value = value;
            node.useCount = 0;
            node.lastGetTime = System.nanoTime();
            if (this.capacity == 0) return;
            if (used < this.capacity) {
                used++;
                cache.put(String.valueOf(key), node);
            } else {
                removeLast();
                cache.put(String.valueOf(key), node);
            }
        }
    }

    // 淘汰最少使用的缓存
    private void removeLast() {
        int minCount = Integer.MAX_VALUE;
        long getTime = System.nanoTime();
        String t = null;

        Iterator<String> it = cache.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Node node = cache.get(key);
            if (node.useCount < minCount || (node.useCount == minCount && node.lastGetTime < getTime)) {
                t = key;
                minCount = node.useCount;
                getTime = node.lastGetTime;
            }
        }
        cache.remove(t);

    }

    public class Node {
        public int value;
        public int useCount;
        public long lastGetTime;

    }
}
