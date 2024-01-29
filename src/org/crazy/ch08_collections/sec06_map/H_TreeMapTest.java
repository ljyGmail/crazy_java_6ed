package org.crazy.ch08_collections.sec06_map;

import java.util.TreeMap;

class H_R implements Comparable {
    int count;
    public H_R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count: " + count + "]";
    }

    // 根据count来判断两个对象是否相等
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj != null && obj.getClass() == H_R.class) {
            var r = (H_R) obj;
            return r.count == this.count;
        }
        return false;
    }

    // 根据count属性值来判断两个对象的大小
    public int compareTo(Object obj) {
        var r = (H_R) obj;
        return count > r.count ? 1 :
            count < r.count ? -1 : 0;
    }
}

public class H_TreeMapTest {
    public static void main(String[] args) {
        var tm = new TreeMap();
        tm.put(new H_R(3), "轻量级Java EE企业应用实战");
        tm.put(new H_R(-5), "疯狂Java讲义");
        tm.put(new H_R(9), "疯狂Android讲义");
        System.out.println(tm);
        // 返回该TreeMap的第一个Entry对象
        System.out.println(tm.firstEntry());
        // 返回该TreeMap的最后一个key值
        System.out.println(tm.lastKey());
        // 返回该TreeMap的比new R(2)大的最小key值
        System.out.println(tm.higherKey(new H_R(2)));
        // 返回该TreeMap的比new R(2)小的最大key-value对
        System.out.println(tm.lowerEntry(new H_R(2)));
        // 返回该TreeMap的子TreeMap
        System.out.println(tm.subMap(new H_R(-1), new H_R(4)));
    }
}
