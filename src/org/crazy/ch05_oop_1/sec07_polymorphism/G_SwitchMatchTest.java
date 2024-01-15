package org.crazy.ch05_oop_1.sec07_polymorphism;

/*
 * 该程序中的switch模式匹配仍然处于预览状态，需要在编译和运行时额外指定参数
 * 编译: 在src目录下
 * javac -d ../target --enable-preview -source 18 org/crazy/ch05_oop_1/sec07_polymorphism/G_SwitchMatchTest.java
 * 运行: 在target目录下
 * java --enable-preview org.crazy.ch05_oop_1.sec07_polymorphism.G_SwitchMatchTest
 */
class G_Shape {}

class G_Triangle extends G_Shape {
    double area;

    public G_Triangle(double area) {
        this.area = area;
    }
}

class G_Rectangle extends G_Shape {}

public class G_SwitchMatchTest {
    public static void main(String[] args) {
        /*
        var switchMatch = new G_SwitchMatchTest();
        switchMatch.test(new G_Triangle(120.4));
        switchMatch.test(new G_Rectangle());

        switchMatch.test2(new G_Triangle(110.3));
        switchMatch.test2(new G_Rectangle());

        switchMatch.test4(null);
        */
        System.out.println("该程序需要指定预览参数才能执行: --enable-preview");
    }

    /*
    public void test(G_Shape s) {
        switch (s) {
            // case不再只是判断s的值，而是判断s的类型
            case G_Triangle t -> System.out.println(s + "是三角形");
            case G_Rectangle r -> System.out.println(r + "是矩形");
            default -> System.out.println("其他图形");
        }
    }
    */

    // 使用传统的switch语句
    /*
    public void test2(G_Shape s) {
        switch (s) {
            case G_Triangle t:
                System.out.println(s + "是三角形");
                break;
            case G_Rectangle r:
                System.out.println(s + "是矩形");
                break;
            default:
                System.out.println("其他图形");
        }
    }
    */

    // 一定要先判断范围小的类(子类)，再判断访问大的类(父类)
    /*
    public void test3(G_Shape s) {
        switch (s) {
            // 在判断Shape类型之后，后面就不能再判断Shape的子类了
            case G_Shape sh -> System.out.println(sh + "是普通形状");
            case G_Rectangle r -> System.out.println(r + "是矩形");
            default -> System.out.println("其他图形");
        }
    }
    */

    // null值处理
    /*
    public void test4(G_Shape s) {
        switch (s) {
            // 使用case分支处理表达式为null的情况
            case null -> System.out.println("s为null");
            case G_Triangle t -> System.out.println(s + "是三角形");
            case G_Rectangle r -> System.out.println(s + "是矩形");
            default -> System.out.println("其他图形");
        }
    }
    */
}
