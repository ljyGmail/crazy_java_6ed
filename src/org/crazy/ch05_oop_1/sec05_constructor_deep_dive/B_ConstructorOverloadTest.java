package org.crazy.ch05_oop_1.sec05_constructor_deep_dive;

public class B_ConstructorOverloadTest {
    public String name;
    public int count;

    // 提过无参数的构造器
    public B_ConstructorOverloadTest() {}

    // 提供带两个参数的构造器
    // 对该构造器返回的对象执行初始化
    public B_ConstructorOverloadTest(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        // 通过无参数的构造器创建ConstructorOverloadTest对象
        var co1 = new B_ConstructorOverloadTest();
        // 通过有参数的构造器创建ConstructorOverloadTest对象
        var co2 = new B_ConstructorOverloadTest("轻量级Java EE企业应用实战", 30000);
        System.out.println(co1.name + " " + co1.count);
        System.out.println(co2.name + " " + co2.count);
    }
}
