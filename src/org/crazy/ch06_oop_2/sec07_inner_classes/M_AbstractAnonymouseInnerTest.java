package org.crazy.ch06_oop_2.sec07_inner_classes;

abstract class M_Device {
    private String name;

    public abstract double getPrice();

    public M_Device() {}

    public M_Device(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class M_AbstractAnonymouseInnerTest {
    public void test(M_Device d) {
        System.out.println("购买了一个" + d.getName()
                + "，花掉了" + d.getPrice());
    }

    public static void main(String[] args) {
        var aait = new M_AbstractAnonymouseInnerTest();
        // 调用有参数的构造器创建Device匿名实现类的对象
        aait.test(new M_Device("电子示波器") {
            public double getPrice() {
                return 67.8;
            }
        });

        // 调用无参数的构造器创建Device匿名实现类的对象
        var d = new M_Device() {
            // 初始化块
            {
                System.out.println("匿名内部类的初始化块...");
            }

            // 实现抽象方法
            public double getPrice() {
                return 56.2;
            }

            // 重写父类的实例方法
            public String getName() {
                return "键盘";
            }
        };

        aait.test(d);
    }
}
