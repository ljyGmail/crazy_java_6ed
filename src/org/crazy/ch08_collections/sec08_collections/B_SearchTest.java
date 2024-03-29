package org.crazy.ch08_collections.sec08_collections;

import java.util.ArrayList;
import java.util.Collections;

public class B_SearchTest {
    public static void main(String[] args) {
        var nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums); // 输出[2, -5, 3, 0]
        System.out.println(Collections.max(nums)); // 输出最大元素，将输出3
        System.out.println(Collections.min(nums)); // 输出最小元素，将输出-5
        Collections.replaceAll(nums, 0, 1); // 将nums中的0使用1来代替
        System.out.println(nums); // 输出[2, -5, 3, 1]
        // 判断-5在List集合中出现的次数，返回1
        System.out.println(Collections.frequency(nums, -5));
        Collections.sort(nums); // 对nums集合排序
        System.out.println(nums); // 输出[-5, 1, 2, 3]
        // 只有排序后的List集合才可用二分搜索法查询，输出3
        System.out.println(Collections.binarySearch(nums, 3));
    }
}
