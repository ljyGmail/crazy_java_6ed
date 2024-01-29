package org.crazy.ch08_collections.sec06_map;

import java.util.HashMap;

public class E_HashMapErrorTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        // 此处的A类与前一个程序中的A类是同一个类
        hm.put(new D_A(60000), "疯狂Java讲义");
        hm.put(new D_A(87563), "轻量级Java EE企业应用实战");
        // 获得HashMap的keySet集合对应的Iterator迭代器
        var it = hm.keySet().iterator();
        // 取出Map中第一个key，并修改它的count值
        var first = (D_A) it.next();
        first.count = 87563;
        // 输出{A@1560b=疯狂Java讲义, A@1560b=轻量级Java EE企业应用实战}
        System.out.println(hm);
        // 只能删除没有被修改过的key所对应的key-value对
        hm.remove(new D_A(87563));
        System.out.println(hm);
        // 无法获取剩下的value，下面两行代码都将输出null
        System.out.println(hm.get(new D_A(87563))); // 输出null
        System.out.println(hm.get(new D_A(60000))); // 输出null
    }
}
