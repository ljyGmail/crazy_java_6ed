package org.crazy.ch08_collections.sec04_list;

import java.util.ArrayList;

class B_A {
    public  boolean equals(Object obj) {
        return true;
    }
}

public class B_List2Test {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        System.out.println(books);
        // 删除集合中的A对象，将导致第一个元素被删除
        books.remove(new B_A());
        System.out.println(books);
        // 删除集合中的A对象，将再次删除集合中的第一个元素
        books.remove(new B_A());
        System.out.println(books);
    }
}
