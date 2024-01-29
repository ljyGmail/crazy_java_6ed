package org.crazy.ch08_collections.sec06_map;

import java.util.WeakHashMap;

public class J_WeakHashMapTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap();
        // 向WeakHashMap中添加3个key-value对
        // 3个key都是匿名字符串对象(没有其他引用)
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英文"), new String("中等"));
        // 向WeakHashMap中添加一个key-value对
        // 该key是一个系统缓存的的字符串对象
        whm.put("java", new String("中等"));
        // 输出whm对象，将看到4个key-value对
        System.out.println(whm);
        // 通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        // 在通常情况下，将只看到一个key-value对
        System.out.println(whm);
    }
}
