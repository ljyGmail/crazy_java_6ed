package org.crazy.ch08_collections.sec06_map;

import java.util.TreeMap;

public class I_TreeMap2Test {
    public static void main(String[] args) {
        var tm = new TreeMap();
        tm.put("疯狂Java讲义", 139.0);
        tm.put("轻量级Java EE企业应用实战", 128.0);
        tm.put("疯狂Spring Boot终极讲义", 169.0);
        // 为特定的key-value重设value
        tm.computeIfPresent("疯狂Java讲义", (key, value) -> {
            double doubleVal = (double) value;
            return (doubleVal > 130) ? doubleVal * 0.8 : doubleVal * 0.9;
        });
        System.out.println(tm);

        // 下面代码会引发异常
        tm.computeIfAbsent("疯狂iOS讲义", (key) -> {
            // 修改Map
            // tm.put("疯狂Python讲义", 129.0);
            return 103.3;
        });
        System.out.println(tm);
    }
}
