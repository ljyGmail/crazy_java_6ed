package org.crazy.ch06_oop_2.sec10_sealed_classes;

interface F_Foo {}

class F_Bar {} // 该类并为实现Foo接口

// 如果为上面的Bar类定义如下子类
// class F_Baz extends F_Bar implements F_Foo {}
// 当传入Baz对象作为test()方法的调用参数时，此时的Baz就实现了Foo接口

public class F_InstanceofDemo {
    public void test(F_Bar b) {
        if (b instanceof F_Foo f) { // 编译通过
            System.out.println(b + "是Foo类型，可转换为" + f);
        }
    }
}
