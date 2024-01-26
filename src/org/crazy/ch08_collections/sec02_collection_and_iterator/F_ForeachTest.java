package org.crazy.ch08_collections.sec02_collection_and_iterator;

import java.util.HashSet;

public class F_ForeachTest {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");

        for (var obj : books) {
            // 此处的book变量也不是集合元素本身
            var book = (String) obj;
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                // 下面代码会引发ConcurrentModificationException异常
                // books.remove(book);
            }
        }
    }
}
