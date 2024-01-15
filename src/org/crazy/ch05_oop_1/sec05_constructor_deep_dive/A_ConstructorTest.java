package org.crazy.ch05_oop_1.sec05_constructor_deep_dive;

public class A_ConstructorTest {
    public String name;
    public int count;

    // 提供自定义的构造器，该构造器包含两个参数
    public A_ConstructorTest(String name, int count) {
        // 构造器中的this代表它执行初始化的对象
        // 下面两行代码将传入的两个参数赋给this所代表对象的name和count实例变量
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        // 使用自定义的构造器来创建对象
        // 系统将会对该对象执行自定义的初始化
        var ct = new A_ConstructorTest("浓情化不开", 1000);
        // 输出ConstructorTest对象的name和count两个实例变量
        System.out.println(ct.name);
        System.out.println(ct.count);
    }
}
