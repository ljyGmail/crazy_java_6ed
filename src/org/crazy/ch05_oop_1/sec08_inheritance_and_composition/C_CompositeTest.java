package org.crazy.ch05_oop_1.sec08_inheritance_and_composition;

class C_Animal {
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breathe() {
        beat();
        System.out.println("吸一口气，吐一口气，呼吸中...");
    }
}

class C_Bird {
    // 将原来的父类组合到原来的子类中，作为子类的一个组成部分
    private C_Animal a;

    public C_Bird(C_Animal a) {
        this.a = a;
    }

    // 重新定义一个自己的breathe()方法
    public void breathe() {
        // 直接复用Animal提供的breathe()方法来实现Bird的breathe()方法
        a.breathe();
    }

    public void fly() {
        System.out.println("我在天空自由地飞翔...");
    }
}

class C_Wolf {
    // 将原来的父类组合到原来的子类中，作为子类的一个组合成分
    private C_Animal a;

    public C_Wolf(C_Animal a) {
        this.a = a;
    }

    // 重新定义一个自己的breathe()方法
    public void breathe() {
        // 直接复用Animal提供的breathe()方法来实现Wolf的breathe()方法
        a.breathe();
    }

    public void run() {
        System.out.println("我在陆地上快速地奔跑...");
    }
}

public class C_CompositeTest {
    public static void main(String[] args) {
        // 此时需要显式创建被组合的对象
        var a1 = new C_Animal();
        var b = new C_Bird(a1);
        b.breathe();
        b.fly();
        // 此时需要显式创建被组合的对象
        var a2 = new C_Animal();
        var w = new C_Wolf(a2);
        w.breathe();
        w.run();
    }
}
