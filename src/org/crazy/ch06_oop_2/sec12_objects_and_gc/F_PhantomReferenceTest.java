package org.crazy.ch06_oop_2.sec12_objects_and_gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;

public class F_PhantomReferenceTest {
    public static void main(String[] args) {
        // 创建一个字符串对象
        var str = new String("疯狂Java讲义");
        // 创建一个引用队列
        var rq = new ReferenceQueue();
        // 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
        var pr = new PhantomReference(str, rq);
        // 切断str和"疯狂Java讲义"字符串对象之间的引用关系
        str = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null
        System.out.println(pr.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 在垃圾回收之后，虚引用将被放入引用队列中
        // 取出引用队列中最先进入队列的引用与pr进行比较
        System.out.println(rq.poll() == pr);
    }
}
