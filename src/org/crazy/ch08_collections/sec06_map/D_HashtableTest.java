package org.crazy.ch08_collections.sec06_map;

import java.util.Hashtable;

class D_A {
    int count;

    public D_A(int count) {
        this.count = count;
    }

    // 根据count的值来判断两个对象是否相等
    public boolean equals(Object obj) {
        System.out.println("---equals()---");
        if (obj == this)
            return true;

        if (obj != null && D_A.class == obj.getClass()) {
            var a = (D_A) obj;
            return a.count == this.count;
        }

        return false;
    }

    // 根据count来计算hashCode值
    public int hashCode() {
        System.out.println(this.count + "===hashCode()===");
        return this.count;
    }
}

class D_B {
    // 重写equals()方法，B对象与任何对象通过equals()方法比较都返回true
    public boolean equals(Object obj) {
        return true;
    }
}

public class D_HashtableTest {
    public static void main(String[] args) {
        var ht = new Hashtable();
        ht.put(new D_A(60000), "疯狂Java讲义");
        System.out.println("@@@@");
        ht.put(new D_A(87563), "轻量级Java EE企业应用实战");
        System.out.println("@@@@");
        ht.put(new D_A(1232), new D_B());
        System.out.println("@@@@");
        System.out.println(ht);
        // 只要两个对象通过equals()方法比较返回true
        // Hashtable就认为它们是相等的value
        // 由于Hashtable中有一个B对象
        // 它与任何对象通过equals()方法比较都相等，所以下面输出true
        System.out.println(ht.containsValue("测试字符串")); // 输出true
        // 只要两个A对象的count相等，它们通过equals()方法比较返回true，且hashCode值相同
        // Hashtable即认为它们是相同的key，所以下面输出true
        System.out.println(ht.containsKey(new D_A(87563))); // 输出true
        // 下面的代码可以删除最后一个key-value对
        ht.remove(new D_A(1232));
        System.out.println(ht);
    }
}
