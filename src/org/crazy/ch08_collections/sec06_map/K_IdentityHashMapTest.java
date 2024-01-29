package org.crazy.ch08_collections.sec06_map;

import java.util.IdentityHashMap;

public class K_IdentityHashMapTest {
    public static void main(String[] args) {
        var ihm = new IdentityHashMap();
        // 下面两行代码将会向IdentityHashMap对象中添加两个key-value对
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);
        // 下面两行代码只会向IdentityHsahMap对象中添加一个key-value对
        ihm.put("java", 93);
        ihm.put("java", 98);
        System.out.println(ihm);
    }
}
