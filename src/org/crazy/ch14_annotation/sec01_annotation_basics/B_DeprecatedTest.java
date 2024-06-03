package org.crazy.ch14_annotation.sec01_annotation_basics;

class Apple {
    // 定义info方法已过时
    // since属性指定从哪个版本开始，forRemoval属性指定该API将来会被删除
    @Deprecated(since = "11", forRemoval = true)
    public void info() {
        System.out.println("Apple的info方法");
    }
}

public class B_DeprecatedTest {
    public static void main(String[] args) {
        // 下面使用info()方法时将会被编译器警告
        new Apple().info();
    }
}
