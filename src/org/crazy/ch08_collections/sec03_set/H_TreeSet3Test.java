package org.crazy.ch08_collections.sec03_set;

import java.util.TreeSet;

class H_R implements Comparable {
    int count;

    public H_R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R{count: " + count + "}";
    }

    // 重写equals()方法，根据count来判断是否相等
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == H_R.class) {
            var r = (H_R) obj;
            return r.count == this.count;
        }

        return false;
    }

    // 重写compareTo()方法，根据count来比较大小
    public int compareTo(Object obj) {
        var r = (H_R) obj;
        return this.count > r.count ? 1 :
            this.count < r.count ? -1 : 0;
    }
}

public class H_TreeSet3Test {
    public static void main(String[] args) {
        var ts = new TreeSet();
        ts.add(new H_R(5));
        ts.add(new H_R(-3));
        ts.add(new H_R(9));
        ts.add(new H_R(-2));
        // 打印TreeSet集合，集合元素是有序排序的
        System.out.println(ts);
        // 取出第一个元素
        var first = (H_R) ts.first();
        // 对第一个元素的count赋值
        first.count = 20;
        // 取出最后一个元素
        var last = (H_R) ts.last();
        // 对最后一个元素的count赋值，与第二个元素的count相同
        last.count = -2;
        // 再次输出，将看到TreeSet中的元素处于无序状态，且有重复元素
        System.out.println(ts);
        // 输出示例变量被改变的元素，输出失败
        System.out.println(ts.remove(new H_R(-2)));
        System.out.println(ts);
        // 输出实例变量没有被改变的元素，输出成功
        System.out.println(ts.remove(new H_R(5)));
        System.out.println(ts);
    }
}
