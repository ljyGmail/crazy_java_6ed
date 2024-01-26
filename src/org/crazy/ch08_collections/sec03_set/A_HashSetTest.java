package org.crazy.ch08_collections.sec03_set;

import java.util.HashSet;

// A类的equlas()方法总是返回true，但没有重写其hashCode()方法
class A_A {
    public boolean equals(Object obj) {
        return true;
    }
}

// B类的hashCode()方法总是返回1，但没有重写其equals()方法
class A_B {
    public int hashCode() {
        return 1;
    }
}

// C类的hashCode()方法总是返回2，且重写了其equals()方法总是返回true
class A_C {
    public int hashCode() {
        return 2;
    }

    public boolean equals(Object obj) {
        return true;
    }
}

public class A_HashSetTest {
    public static void main(String[] args) {
        var books = new HashSet();
        // 分别向books集合中添加两个A对象、两个B对象、两个C对象
        books.add(new A_A());
        books.add(new A_A());
        books.add(new A_B());
        books.add(new A_B());
        books.add(new A_C());
        books.add(new A_C());
        System.out.println(books);
    }
}
