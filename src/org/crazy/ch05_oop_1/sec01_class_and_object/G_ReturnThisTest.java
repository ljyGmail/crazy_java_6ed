package org.crazy.ch05_oop_1.sec01_class_and_object;

public class G_ReturnThisTest {
    public int age;

    public G_ReturnThisTest grow() {
        age++;
        // return this返回调用该方法对象
        return this;
    }

    public static void main(String[] args) {
        var rt = new G_ReturnThisTest();
        // 可以连续调用同一个方法
        rt.grow()
            .grow()
            .grow();
        System.out.println("rt的age成员变量值是: " + rt.age);
    }
}
