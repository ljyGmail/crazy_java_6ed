package org.crazy.ch08_collections.sec02_collection_and_iterator;

import java.util.HashSet;

public class D_IteratorErrorTest {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        // 获取books集合对应的迭代器
        var it = books.iterator();
        while (it.hasNext()) {
            var book = (String) it.next();
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                // 在使用Iterator迭代的过程中，不可修改集合元素，下面的代码引发异常
                // books.remove(book);
            }
        }
    }
}
