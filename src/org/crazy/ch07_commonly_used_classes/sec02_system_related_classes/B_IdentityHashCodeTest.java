package org.crazy.ch07_commonly_used_classes.sec02_system_related_classes;

public class B_IdentityHashCodeTest {
    public static void main(String[] args) {
        // 下面程序中的s1和s2是两个不同的对象
        var s1 = new String("Hello");
        var s2 = new String("Hello");
        // String重写了hashCode()方法 - 改为根据字符序列计算hashCode值
        // 因为s1和s2的字符序列相同，所以它们的hashCode()方法的返回值相同
        System.out.println(s1.hashCode()
                + "-----" + s2.hashCode());

        // s1和s2是不同的字符串对象，所以它们的identityHashCode值不同
        System.out.println(System.identityHashCode(s1)
                + "-----" + System.identityHashCode(s2));

        var s3 = "Java";
        var s4 = "Java";
        // s3和s4是相同的字符串对象，所以它们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3)
                + "-----" + System.identityHashCode(s4));
    }
}
