package org.crazy.ch06_oop_2.sec10_sealed_classes;

interface H_Foo {}

sealed class H_Bar {} // 该类并未实现Foo接口
                    //
final class H_Baz extends H_Bar {}

sealed class H_Qux extends H_Bar {}

final class H_FooBar extends H_Qux {}

public class H_Instanceof3Demo {

    public void test(H_Bar b) {
        /*
        if (b instanceof H_Foo f) { // 编译错误
            System.out.println(b + "是Foo类型，可转换为" + f);
        }
        */
    }
}
