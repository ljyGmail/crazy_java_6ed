package org.crazy.ch08_collections.sec05_queue;

import java.util.LinkedList;

public class D_LinkedListTest {
    public static void main(String[] args) {
        var books = new LinkedList();
        // 将字符串元素插入队列的尾部
        books.offer("疯狂Java讲义");
        // 将字符串元素插入栈的顶部
        books.push("轻量级Java EE企业应用实战");
        // 将字符串元素添加到队列的头部(相当于栈的顶端)
        books.offerFirst("疯狂Android讲义");
        // 以List的方式(按索引访问的方式)遍历集合元素
        for (var i = 0; i < books.size(); i++) {
            System.out.println("遍历中: " + books.get(i));
        }

        // 访问但不删除栈顶的元素
        System.out.println(books.peekFirst());
        // 访问但不输出队列的最后一个元素
        System.out.println(books.peekLast());
        // 将栈顶的元素弹出"栈"
        System.out.println(books.pop());
        // 从下面的输出中将看到队列中的第一个元素被删除
        System.out.println(books.pollLast());
        // 下面输出: [轻量级Java EE企业应用实战]
        System.out.println(books);
    }
}
