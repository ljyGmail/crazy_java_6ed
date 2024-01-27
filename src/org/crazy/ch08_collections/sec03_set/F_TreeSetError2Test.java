package org.crazy.ch08_collections.sec03_set;

import java.util.Date;
import java.util.TreeSet;

public class F_TreeSetError2Test {
    public static void main(String[] args) {
        var ts = new TreeSet();
        // 向TreeSet集合中添加两个对象
        ts.add(new String("疯狂Java讲义"));
        // ts.add(new Date());
        System.out.println("该示例表明添加到TreeSet中的对象应该是同一个类的对象，否则将引发异常");
    }
}
