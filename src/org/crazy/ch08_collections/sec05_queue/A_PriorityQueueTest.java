package org.crazy.ch08_collections.sec05_queue;

import java.util.PriorityQueue;

public class A_PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue();
        // 下面的代码依次向pq中插入4个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        // 删除pq队列，并不是按元素的插入顺序排列的
        System.out.println(pq);  // 输出[-3, 6, 20, 18]
        // 遍历队列的元素，可以看到元素是按顺序排列的
        while (pq.size() > 0) {
            System.out.println(pq.poll());
        }
    }
}
