package org.crazy.ch05_oop_1.sec08_inheritance_and_composition;

class B_Animal {
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breathe() {
        beat();
        System.out.println("吸一口气，吐一口气，呼吸中...");
    }
}

// 继承Animal，直接复用父类的breath()方法
class B_Bird extends B_Animal {
    public void fly() {
        System.out.println("我在天空自在地飞翔...");
    }
}

// 继承Animal，直接复用父类的breathe()方法
class B_Wolf extends B_Animal {
    public void run() {
        System.out.println("我在陆地上快速地奔跑...");
    }
}

public class B_InheritTest {
    public static void main(String[] args) {
        var b = new B_Bird();
        b.breathe();
        b.fly();
        var w = new B_Wolf();
        w.breathe();
        w.run();
    }
}
