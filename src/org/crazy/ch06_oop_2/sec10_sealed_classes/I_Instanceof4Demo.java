package org.crazy.ch06_oop_2.sec10_sealed_classes;

interface I_Foo {}

sealed class I_Bar {} // 该类并未实现Foo接口

final class I_Baz extends I_Bar {}

sealed class I_Qux extends I_Bar {}

non-sealed class I_FooBar extends I_Qux {}

public class I_Instanceof4Demo {

    public void test(I_Bar b) {
        if (b instanceof I_Foo f) {
            System.out.println(b + "是Foo类型，可转换为" + f);
        }
    }
}
