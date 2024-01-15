package org.crazy.ch05_oop_1.sec05_constructor_deep_dive;

public class C_ConstructorReuseTest {
    public String name;
    public String color;
    public double weight;

    public C_ConstructorReuseTest() {}

    // 带两个参数的构造器
    public C_ConstructorReuseTest(String name, String color) {
        System.out.println("带两个参数的构造器");
        this.name = name;
        this.color = color;
    }

    // 带三个参数的构造器
    public C_ConstructorReuseTest(String name, String color, double weight) {
        // 通过this调用另一个重载的构造器的初始化代码
        this(name, color);
        // 下面的this引用该构造器正在初始化的Java对象
        this.weight = weight;
    }

    public static void main(String[] args) {
        var apple = new C_ConstructorReuseTest("Macbook Pro", "Space Gray", 2.4);
        System.out.println(apple.name + ": " + apple.color + " -> " + apple.weight);
    }
}
