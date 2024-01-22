package org.crazy.ch06_oop_2.sec10_sealed_classes;

// 定义Shape密封类，省略permits子句
public sealed class E_Shape {

    // 定义Shape的子类
    public final class Triangle extends E_Shape {}
}

// 定义Shape的子类
final class E_Rectangle extends E_Shape {}
