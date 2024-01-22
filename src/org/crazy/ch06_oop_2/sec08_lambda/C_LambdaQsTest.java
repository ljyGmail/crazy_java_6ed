package org.crazy.ch06_oop_2.sec08_lambda;

interface C_Eatable {
    void taste();
}

interface C_Flyable {
    void fly(String weather);
}

interface C_Addable {
    int add(int a, int b);
}

class C_EatableImpl implements C_Eatable {
    public void taste() {
        System.out.println("@@@味道不错");
    }
}

class C_FlyableImpl implements C_Flyable {
    public void fly(String weather) {
        System.out.println("@@@今天天气是: " + weather);
        System.out.println("@@@直升机飞行平稳");
    }
}

class C_AddableImpl implements C_Addable {
    public int add(int a, int b) {
        System.out.println("@@@");
        return a + b;
    }
}

public class C_LambdaQsTest {
    // 调用该方法需要Eatable对象
    public void eat(C_Eatable e) {
        System.out.println(e);
        e.taste();
    }

    // 调用该方法需要Flable对象
    public void drive(C_Flyable f) {
        System.out.println("我正在驾驶: " + f);
        f.fly("[碧空如洗的晴日]");
    }

    // 调用该方法需要Addable对象
    public void test(C_Addable add) {
        System.out.println(add);
        System.out.println("5与3的和为: " + add.add(5, 3));
    }

    public static void main(String[] args) {
        var lq = new C_LambdaQsTest();
        // ==================================================
        System.out.println("===============Lambda===============");
        // 使用Lambda表达式(代码量最小)
        // Lambda表达式的代码块中只有一条语句，可以省略花括号
        lq.eat(() -> System.out.println("苹果的味道不错!"));

        // Lambda表达式的形参列表中只有一个形参，可以省略圆括号
        lq.drive(weather -> {
            System.out.println("今天天气是: " + weather);
            System.out.println("直升机飞行平稳");
        });

        // Lambda表达式的代码块中只有一条语句，可以实例花括号
        // 代码块中只有一条语句，即使该表达式需要返回值，也可以省略return关键字
        lq.test((a, b) -> a + b);

        // ==================================================
        System.out.println("===============接口实现类对象===============");
        // 使用传入接口实现类对象的方式(代码量最大)
        lq.eat(new C_EatableImpl());
        lq.drive(new C_FlyableImpl());
        lq.test(new C_AddableImpl());

        // ==================================================
        System.out.println("===============匿名内部类==============");
        // 使用匿名内部类(代码量中等)
        lq.eat(new C_Eatable() {
            public void taste() {
                System.out.println("###味道还可以");
            }
        });

        lq.drive(new C_Flyable() {
            public void fly(String weather) {
                System.out.println("###今天天气是: " + weather);
                System.out.println("###直升机飞行平稳");
            }
        });

        lq.test(new C_Addable() {
            public int add(int a, int b) {
                System.out.println("###");
                return a + b;
            }
        });
    }
}
