package org.crazy.ch08_collections.sec03_set;

import java.util.HashSet;

class B_R {
    int count;

    public B_R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count: " + count + "]";
    }

    public boolean equals(Object obj) {
        System.out.println("@@@@ equals");
        if (this == obj)
            return true;

        if (obj != null && obj.getClass() == B_R.class) {
            var r = (B_R) obj;
            return this.count == r.count;
        }
        return false;
    }

    public int hashCode() {
        System.out.println("##### hashcode");
        return this.count;
    }
}

public class B_HashSet2Test {
    public static void main(String[] args) {
        var hs = new HashSet();
        hs.add(new B_R(5));
        hs.add(new B_R(-3));
        hs.add(new B_R(9));
        hs.add(new B_R(-2));
        hs.add(new B_R(-2)); // 重复的元素不会被添加成功

        // 打印HashSet集合，集合元素没有重复
        System.out.println(hs);

        // 取出第一个元素
        var it = hs.iterator();
        var first = (B_R) it.next();
        // 为第一个元素的count实例变量赋值
        first.count = -3;
        // 再次输出HashSet集合，集合元素有重复
        System.out.println(hs);

        // 删除count为-3的R对象
        hs.remove(new B_R(-3));
        // 可以看到删除了一个R元素
        System.out.println(hs);
        System.out.println("hs是否包含count为-3的R对象? "
                + hs.contains(new B_R(-3))); // 没有hashCode为-3的元素
        System.out.println("hs是否包含count为-2的R对象? "
                + hs.contains(new B_R(-2))); // 有hashCode为-2的元素，但用equals()比较时又不同
    }
}
