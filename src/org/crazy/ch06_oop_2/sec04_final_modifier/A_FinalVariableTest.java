package org.crazy.ch06_oop_2.sec04_final_modifier;

public class A_FinalVariableTest {
    // 在调用成员变量时指定默认值，合法
    final int a = 6;
    // 下面的变量将在构造器或初始化块中被分配初始值
    final String str;
    final int c;
    final static double d;

    // 既没有指定默认值，有没有在初始化块、构造器中指定初始值
    // 下面定义的ch实例变量是不合法的
    // final char ch;

    // 初始化块，可以对没有指定默认初始值的实例变量指定初始值
    {
        // 在初始化块中为实例变量指定初始值，合法
        str = "Hello";
        // 在定义a变量时已经指定了初始值
        // 不能为a重新赋值，因此下面的赋值语句非法
        // a = 9;
    }

    // 静态初始化块，可以对没有指定默认初始值的类变量指定初始值
    static {
        // 在静态初始化块中为类变量指定初始值，合法
        d = 5.6;
    }

    // 构造器，可以对既没有指定默认值，有没有在初始化块中
    // 指定初始值的实例变量指定初始值
    public A_FinalVariableTest() {
        // 如果在初始化块中已经对str指定了初始值
        // 那么在构造器中不能对final变量重新赋值，因此下面的赋值语句方法
        // str = "java";
        c = 5;
    }

    public void changeFinal() {
        // 普通方法不能为final修饰的成员变量赋值
        // d = 1.2;
        // 不能在普通方法中为final成员变量指定初始值
        // ch = 'a';
    }

    public static void main(String[] args) {
        var ft = new A_FinalVariableTest();
        System.out.println(ft.a);
        System.out.println(ft.c);
        System.out.println(ft.d);
    }
}
