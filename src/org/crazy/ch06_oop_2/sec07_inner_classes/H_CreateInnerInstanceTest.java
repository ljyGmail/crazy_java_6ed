package org.crazy.ch06_oop_2.sec07_inner_classes;

class H_Out {
    // 定义一个内部类，不使用访问控制修饰符
    // 即只有同一个包中的其他类可访问该内部类
    class In {
        public In(String msg) {
            System.out.println(msg);
        }
    }
}

public class H_CreateInnerInstanceTest {
    public static void main(String[] args) {
        H_Out.In in = new H_Out().new In("测试信息");
        
        // 上面的代码可被改为如下三行代码
        // 使用OuterClass.InnerClass的形式定义内部类变量
        H_Out.In in2;
        // 创建外部类的实例，非静态内部类实例将寄生在该实例中
        H_Out out = new H_Out();
        // 通过外部实例和new调用内部类的构造器来创建非静态内部类实例
        in2 = out.new In("测试信息");
    }
}
