package org.crazy.ch06_oop_2.sec12_objects_and_gc;

import java.lang.ref.WeakReference;

public class E_ReferenceTest {
    public static void main(String[] args) {
        // 创建一个字符串对象
        var str = new String("疯狂Java讲义");
        // 若使用下面代码，将无法看到效果
        // 因为系统会使用常量池来管理这个字符串直接量，不会回收该字符串直接量
        // var str = "疯狂Java讲义";
        // 创建一个弱引用，让此弱引用引用到"疯狂Java讲义"字符串
        var wr = new WeakReference(str);
        // 切断str和"疯狂Java讲义"对象之间的引用关系
        str = null;
        // 取出弱引用所引用的对象
        System.out.println(wr.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }
}
