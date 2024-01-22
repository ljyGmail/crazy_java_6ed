package org.crazy.ch06_oop_2.sec10_sealed_classes;

interface G_Foo {}

final class G_Bar {} // 该类并未实现Foo接口

public class G_Instanceof2Demo {

    public void test(G_Bar b) {
        /*
        if (b instanceof G_Foo f) { // 编译错误
            System.out.println(b + "是Foo类型，可转换为" + f);
        }
        */
    }
}
