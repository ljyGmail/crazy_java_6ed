package org.crazy.ch05_oop_1.sec06_inheritance;

public class D_OstrichTest extends C_Bird {
    /*
     * 方法重写要遵循"两同、两小，一大"规则:
     * 两同:
     *      方法名相同、形参列表相同
     * 两小:
     *      子类方法的返回值类型比父类方法的返回值类型更小或相等
     *      子类方法声明抛出的因此类应比父类方法声明抛出的异常类更小或相等
     * 一大:
     *      子类方法的访问权限应比父类方法的访问权限更大或相等
     */
    // 重写Bird类的fly()方法
    public void fly() {
        System.out.println("我只能在地上奔跑...");
    }

    public void callOverridednMethod() {
        // 在子类的方法中通过super显式调用父类中被覆盖的方法
        super.fly();
    }

    public static void main(String[] args) {
        // 创建OstrichTest对象
        var os = new D_OstrichTest();
        // 执行OstrichTest对象的fly()方法，将输出"我只能在地上奔跑..."
        os.fly();

        // 调用父类中的fly()方法
        os.callOverridednMethod();
    }
}

// 覆盖的方法和被覆盖的方法只能都是类方法或实例方法，
// 不能一个是类方法，一个是实例方法。
/*
class D_BaseClass {
    public static void test() {}
}

class D_SubClass extends D_BaseClass {
    public void test() {}
}
*/
class D_BaseClass {
    // test()方法具有private访问权限，子类不可访问该方法
    private void test() {}
}

class D_SubClass extends D_BaseClass {
    // 此处并不是方法重写，所以可以增加static关键字
    public static void test() {}
}
