package org.crazy.ch09_generics.sec04_generic_method;

class D_Foo {
    public <T> D_Foo(T t) {
        System.out.println(t);
    }
}

public class D_GenericConstructorTest {
    public static void main(String[] args) {
        // 泛型构造器中T的类型为String
        new D_Foo("疯狂Java讲义");
        // 泛型构造器中T的类型为Intege
        new D_Foo(200);

        // 显式指定泛型构造器中T的类型为String
        // 传给Foo构造器的实参也是String对象，完全正确
        new <String>D_Foo("疯狂Android讲义");

        // 显示指定泛型构造器中T的类型为String
        // 但传给Foo构造器的实参是Double对象，下面的代码出错
        // new <String> D_Foo(12.3);
    }
}
