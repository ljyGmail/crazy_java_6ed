package org.crazy.ch05_oop_1.sec04_info_hide_and_encapsulation.zhou;

import org.crazy.ch05_oop_1.sec04_info_hide_and_encapsulation.zhou.huajian.E_Apple;

public class D_HelloTest {
    public static void main(String[] args) {
        // 直接访问相同包下的另一个类，无须使用包前缀
        var h = new C_Hello();
        C_Hello.main(new String[] {"aa"});

        // 在定义构造器时需要在构造器前增加包前缀
        var a = new org.crazy.ch05_oop_1.sec04_info_hide_and_encapsulation.zhou.huajian.E_Apple();
        // 如果使用import语句来导入Apple类，就可以不再使用类全名了
        var aa = new E_Apple();

        // 为了让引用更加明确，即使使用了import语句，也还是需要使用类的全名
        // java.sql.Date d = new java.sql.Date(1234L);
    }
}
