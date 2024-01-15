package org.crazy.ch05_oop_1.sec06_inheritance;

class G_Base {
    public double size;
    public String name;

    public G_Base(double size, String name) {
        this.size = size;
        this.name = name;
    }
}

public class G_InvokeSuperConstructorTest extends G_Base {
    public String color;

    public G_InvokeSuperConstructorTest(double size, String name, String color) {
        // 通过super来调用父类构造器的初始化代码
        super(size, name);
        this.color = color;
    }

    public static void main(String[] args) {
        var test = new G_InvokeSuperConstructorTest(5.6, "测试对象", "红色");
        // 输出InvokeSuperConstructorTest对象的三个实例变量
        System.out.println(test.size + "---" + test.name
                + "---" + test.color);
    }
}
