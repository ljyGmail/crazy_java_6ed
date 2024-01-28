package org.crazy.ch08_collections.sec06_map;

import java.util.HashMap;

public class B_Map2Test {
    public static void main(String[] args) {
        var map = new HashMap();
        // 成对放入多个key-value对
        map.put("疯狂Java讲义", 109);
        map.put("疯狂iOS讲义", 99);
        map.put("疯狂Ajax讲义", 79);
        // 尝试替换key为"疯狂XML讲义"的value，由于原Map中没有对应的key
        // 因此Map没有改变，不会添加新的key-value对
        map.replace("疯狂XML讲义", 66);
        System.out.println(map);
        // 使用原value与传入的参数计算出来的结果覆盖原value
        map.merge("疯狂iOS讲义", 10,
                (oldValue, param) -> (Integer) oldValue + (Integer) param);
        System.out.println(map); // "疯狂iOS讲义"的value 增大了10
        // 当key为"Java"对应的value为null(或不存在)时，使用计算结果作为新value
        map.computeIfAbsent("Java", key -> ((String) key).length());
        System.out.println(map); // 在map中添加了Java=4这个key=value对
        // 当key为"Java"对应的value存在时，使用计算结果作为新value
        map.computeIfPresent("Java",
                (key, value) -> (Integer) value * (Integer) value);
        System.out.println(map); // map中Java=4变成Java=16
    }
}
