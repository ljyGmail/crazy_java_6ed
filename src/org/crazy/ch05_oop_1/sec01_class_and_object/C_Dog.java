package org.crazy.ch05_oop_1.sec01_class_and_object;

public class C_Dog {
    // 定义一个jump()方法
    public void jump() {
        System.out.println("正在执行jump方法");
    }

    // 定义一个run()方法，run()方法需要借助jump()方法
    public void run() {
        // var d = new C_Dog();
        // d.jump();

        // 使用this引用调用run()方法的对象
        // this.jump();
        // 可以省略this前缀
        jump();
        System.out.println("正在执行run方法");
    }
}
