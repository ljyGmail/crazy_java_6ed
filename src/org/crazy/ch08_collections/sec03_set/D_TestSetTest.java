package org.crazy.ch08_collections.sec03_set;

import java.util.TreeSet;

public class D_TestSetTest {
    public static void main(String[] args) {
        var nums = new TreeSet();
        // 向TreeSet中添加4个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        // 输出集合元素，将看到集合元素已经处于排序状态
        System.out.println(nums);
        // 输出集合里的第一个元素
        System.out.println(nums.first()); // 输出-9
        // 输出集合里的最后一个元素
        System.out.println(nums.last()); // 输出10
        // 返回小于4的子集，不包含4
        System.out.println(nums.headSet(4)); // 输出[-9, 2]
        // 返回大于5的子集，如果TreeSet中包含5，则子集中也包含5
        System.out.println(nums.tailSet(5));
        // 返回大于或等于-3、小于4的子集
        System.out.println(nums.subSet(-3, 4)); // 输出[2]
    }
}
