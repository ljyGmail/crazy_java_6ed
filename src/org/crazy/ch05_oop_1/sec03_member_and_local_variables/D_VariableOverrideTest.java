package org.crazy.ch05_oop_1.sec03_member_and_local_variables;

public class D_VariableOverrideTest {
    // 定义一个name实例变量
    private  String name = "宋江";
    // 定义一个price类变量
    private static double price = 78.0;

    // 主方法，程序的入口
    public static void main(String[] args) {
        // 方法中的局部变量，局部变量覆盖成员变量
        var price = 65;
        // 直接访问price变量，将输出price局部变量的值：65
        System.out.println(price);
        // 使用类名限定访问price变量
        // 将输出price类变量的值：78.0
        System.out.println(D_VariableOverrideTest.price);
        // 运行info方法
        new D_VariableOverrideTest().info();
    }

    public void info() {
        // 方法中的局部变量，局部变量覆盖成员变量
        var name = "武松";
        // 直接访问name变量，将输出name局部变量的值"武松"
        System.out.println(name);
        // 使用this来限定访问name变量
        // 将输出name实例变量的值: "宋江"
        System.out.println(this.name);
    }
}
