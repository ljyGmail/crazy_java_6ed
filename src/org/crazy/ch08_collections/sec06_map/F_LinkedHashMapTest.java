package org.crazy.ch08_collections.sec06_map;

import java.util.LinkedHashMap;

public class F_LinkedHashMapTest {
    public static void main(String[] args) {
        var scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英文", 82);
        scores.put("数学", 76);
        // 调用forEach()方法遍历scores中所有的key-value对
        scores.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
