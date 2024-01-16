package org.crazy.ch05_oop_1.sec08_inheritance_and_composition;

class Base {
    public Base() {
        test();
    }

    public void test() {
        System.out.println("将被子类重写的方法");
    }
}

public class A_SubTest extends Base {
    private String name;

    public void test() {
        System.out.println("子类重写父类的方法: "
                + "其name字符串长度: " + name.length());
    }

    public static void main(String[] args) {
        // 下面的代码会引发空指针异常
        // var s = new A_SubTest();
        System.out.println("在父类构造器中调用被子类重写的方法可能引发空指针异常");
    }
}
