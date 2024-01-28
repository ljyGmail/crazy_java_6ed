package org.crazy.ch08_collections.sec03_set;

import java.util.EnumSet;

enum J_Season {
    SPRING, SUMMER, FALL, WINTER;
}

public class J_EnumSetTest {
    public static void main(String[] args) {
        // 创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
        var es1 = EnumSet.allOf(J_Season.class);
        System.out.println(es1); // 输出[SPRING, SUMMER, FALL, WINTER]
        // 创建一个空EnumSet集合，指定其集合元素是Season类的枚举值
        var es2 = EnumSet.noneOf(J_Season.class);
        System.out.println(es2); // 输出[]
        // 手动添加两个元素
        es2.add(J_Season.WINTER);
        es2.add(J_Season.SPRING);
        System.out.println(es2); // 输出[SPRING, WINTER]
        // 以指定枚举值创建EnumSet集合
        var es3 = EnumSet.of(J_Season.SUMMER, J_Season.WINTER);
        System.out.println(es3); // 输出[SUMMER, WINTER]
        var es4 = EnumSet.range(J_Season.SUMMER, J_Season.WINTER);
        System.out.println(es4); // 输出[SUMMER, FALL, WINTER]
        // 新创建的EnumSet集合元素和es4集合元素有相同的类型
        // es5集合元素 + es4集合元素 = Season枚举类的全部枚举值
        var es5 = EnumSet.complementOf(es4);
        System.out.println(es5); // 输出[SPRING]
    }
}
