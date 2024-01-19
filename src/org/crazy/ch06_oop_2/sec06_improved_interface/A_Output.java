package org.crazy.ch06_oop_2.sec06_improved_interface;

public interface A_Output {
    // 在接口里定义的成员变量只能是常量
    int MAX_CACHE_LINE = 50;
    
    // 在接口里定义的普通方法只能是public抽象方法
    void out();

    void getData(String msg);

    // 在接口中定义默认方法时，需要使用default修饰
    default void print(String... msgs) {
        for (var msg : msgs) {
            System.out.println(msg);
        }
    }

    // 在接口中定义默认方法时，需要使用default修饰
    default void test() {
        System.out.println("默认的test()方法");
    }

    // 在接口中定义类方法时，需要使用static修饰
    static String staticTest() {
        return "接口里的类方法";
    }

    // 定义私有方法
    private void foo() {
        System.out.println("foo私有方法");
    }

    // 定义私有静态方法
    private static void bar() {
        System.out.println();
    }
}
