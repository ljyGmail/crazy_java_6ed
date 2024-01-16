package org.crazy.ch05_oop_1.sec09_initialization_block;

class C_Root {
    static {
        System.out.println("Root类的初始化块");
    }

    {
        System.out.println("Root的实例初始化块");
    }

    public C_Root() {
        System.out.println("Root的无参数的构造器");
    }
}

class C_Mid extends C_Root {
    static {
        System.out.println("Mid的类初始化块");
    }

    {
        System.out.println("Mid的实例初始化块");
    }

    public C_Mid() {
        System.out.println("Mid的无参数的构造器");
    }

    public C_Mid(String msg) {
        // 通过this调用同一个类中重在的构造器
        this();
        System.out.println("Mid的带参数构造器，其参数值: "
                + msg);
    }
}

class C_Leaf extends C_Mid {
    static {
        System.out.println("Leaf的类初始化块");
    }

    {
        System.out.println("Leaf的实例初始化块");
    }

    public C_Leaf() {
        // 通过super调用父类中又一个字符串的构造器
        super("疯狂Java讲义");
        System.out.println("执行Leaf的构造器");
    }
}

public class C_HierachicalInitBlocksTest {
    public static void main(String[] args) {
        new C_Leaf();
        System.out.println("==========");
        new C_Leaf();
    }
}
