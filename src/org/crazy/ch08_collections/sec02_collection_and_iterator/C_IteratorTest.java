package org.crazy.ch08_collections.sec02_collection_and_iterator;

import java.util.HashSet;

public class C_IteratorTest {
    public static void main(String[] args) {
        // 创建集合、添加元素
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");

        // 获取books集合对应的迭代器
        var it = books.iterator();
        while (it.hasNext()) {
            // it.next()方法返回的数据类型是Object类型，因此需要强制类型转换
            var book = (String) it.next();
            System.out.println(book);
            if (book.equals("疯狂Java讲义")) {
                // 从集合中删除上一次next()方法返回的元素
                it.remove();
            }
            // 对book变量赋值，不会改变集合元素本身
            book = "测试字符串";
        }
        System.out.println(books);
    }
}
