package org.crazy.ch08_collections.sec06_map;

import java.util.HashMap;

public class C_NullInHashMapTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        // 试图将两个key为null的key-value对放入HashMap中
        hm.put(null, null);
        hm.put(null, null);
        // 将一个value为null的key-value对放入HashMap中
        hm.put("a", null);
        // 输出Map对象
        System.out.println(hm);
    }
}
