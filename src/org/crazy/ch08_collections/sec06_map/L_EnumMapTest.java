package org.crazy.ch08_collections.sec06_map;

import java.util.EnumMap;

enum L_Season {
    SPRING, SUMMER, FALL, WINTER;
}

public class L_EnumMapTest {
    public static void main(String[] args) {
        // 创建EnumMap对象，该EnumMap的所有key都是Season枚举类的枚举值
        var enumMap = new EnumMap(L_Season.class);
        enumMap.put(L_Season.SUMMER, "夏日炎炎");
        enumMap.put(L_Season.SPRING, "春暖花开");
        System.out.println(enumMap);
    }
}
