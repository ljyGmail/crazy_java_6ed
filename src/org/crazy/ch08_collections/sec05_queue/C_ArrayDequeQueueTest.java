package org.crazy.ch08_collections.sec05_queue;

import java.util.ArrayDeque;

public class C_ArrayDequeQueueTest {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        // 依次将三个元素加入队列中
        queue.offer("疯狂Java讲义");
        queue.offer("轻量级Java EE企业应用实战");
        queue.offer("疯狂Android讲义");
        // 输出[疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
        System.out.println(queue);
        // 访问队列头部的元素，但并不将其poll出队列"栈"，输出: 疯狂Java讲义
        System.out.println(queue.peek());
        // 依然输出[疯狂Java讲义, 轻量级Java EE企业应用实战, 疯狂Android讲义]
        System.out.println(queue);
        // poll出第一个元素，输出: 疯狂Java讲义
        System.out.println(queue.poll());
        // 输出[轻量级Java EE企业应用实战, 疯狂Android讲义]
        System.out.println(queue);
    }
}
