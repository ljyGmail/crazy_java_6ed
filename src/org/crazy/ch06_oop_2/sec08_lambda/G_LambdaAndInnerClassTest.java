package org.crazy.ch06_oop_2.sec08_lambda;

@FunctionalInterface
interface G_Disaplayable {
    // 定义一个抽象方法和默认方法
    void display();

    default int add(int a, int b) {
        return a + b;
    }
}

public class G_LambdaAndInnerClassTest {
    private int age = 12;

    private static String name = "疯狂软件教育中心";

    public void testLambda() {
        var book = "疯狂Java讲义";

        G_Disaplayable dis = () -> {
            // book = "疯狂Python讲义";
            // 访问"effectively final"的局部变量
            System.out.println("book局部变量为: " + book);
            // 访问外部类的实例变量和类变量
            System.out.println("外部类的age实例变量为: " + age);
            System.out.println("外部类的name类变量为: " + name);
            // Lambda表达式中不能调用接口中的默认方法
            // System.out.println(add(3, 5));
        };

        dis.display();

        // 定义dis对象从接口中继承的add()方法
        System.out.println(dis.add(3, 5));
    }

    public void testAnonymous() {
        var book = "疯狂Kotlin讲义";

        G_Disaplayable dis = new G_Disaplayable() {
            public void display() {
                // book = "疯狂Python讲义";
                System.out.println("book局部变量为: " + book);
                System.out.println("外部类的age实例变量为: " + age);
                System.out.println("外部类的name类变量为: " + name);
                // 在匿名内部类中的方法实现中可以调用默认方法
                System.out.println(add(7, 8));
            }
        };

        dis.display();

        System.out.println(dis.add(4, 5));
    }

    public static void main(String[] args) {
        var test = new G_LambdaAndInnerClassTest();
        test.testLambda();

        System.out.println("=====================");

        test.testAnonymous();
    }
}
