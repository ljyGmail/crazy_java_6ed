package org.crazy.ch08_collections.sec02_collection_and_iterator;

import java.util.HashSet;

public class B_CollectionEachTest {
    public static void main(String[] args) {
        // 创建一个集合
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        // 调用forEach()方法遍历集合
        books.forEach(obj -> System.out.println("迭代集合元素: " + obj));
    }
}
