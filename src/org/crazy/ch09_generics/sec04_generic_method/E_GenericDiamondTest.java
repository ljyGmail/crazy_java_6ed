package org.crazy.ch09_generics.sec04_generic_method;

class E_MyClass<E> {
    public <T> E_MyClass(T t) {
        System.out.println("t参数的值为: " + t);
    }
}

public class E_GenericDiamondTest {
    public static void main(String[] args) {
        // MyClass类声明中的E形参是String类型
        // 泛型构造器中声明的T形参是Integer类型
        E_MyClass<String> mc1 = new E_MyClass<>(5);

        // 显示指定泛型构造器中声明的T形参是Integer类型
        E_MyClass<String> mc2 = new <Integer>E_MyClass<String>(5);

        // MyClass类声明中的E形参是String类型
        // 如果显示指定泛型构造器中声明的T形参是Integer类型
        // 此时就不能使用"菱形"语法，下面的代码是错误的
        // E_MyClass<String> mc3 = new <Integer> E_MyClass<>(5);
        System.out.println("此示例表明指定了泛型构造器时不能使用菱形语法");
    }
}
