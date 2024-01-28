package org.crazy.ch08_collections.sec03_set;

import java.util.EnumSet;
import java.util.HashSet;

public class K_EnumSet2Test {
    public static void main(String[] args) {
        var c = new HashSet();
        c.clear();
        c.add(J_Season.FALL);
        c.add(J_Season.SPRING);
        // 复制Collection集合中所有的元素来创建EnumSet
        var enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet); // 输出[SPRING, FALL]
        c.add("疯狂Java讲义");
        c.add("轻量级Java EE企业应用实战");
        // 下面的代码出现异常，因为c集合中的元素不全是枚举值
        // enumSet = EnumSet.copyOf(c);
    }
}
