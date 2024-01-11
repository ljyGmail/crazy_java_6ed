package org.crazy.ch04_control_flow_and_arrays.sec06_array_deep_dive;

class C_Person {
    public int age; // 年龄
    public double height; // 身高
    // 定义一个info方法
    public void info() {
        System.out.println("我的年龄是: " + age
                + "，我的身高是: " + height);
    }
}

public class C_ReferenceArrayTest {
    public static void main(String[] args) {
        // 定义一个students数组变量，其类型是C_Person[]
        C_Person[] students;
        // 执行动态初始化
        students = new C_Person[2];
        // 创建一个C_Person实例，并将这个实例赋给zhang变量
        var zhang = new C_Person();
        // 为zhang所引用的C_Person对象中的age、height赋值
        zhang.age = 15;
        zhang.height = 158;
        // 创建一个C_Person实例，并将这个C_Person实例赋给lee变量
        var lee = new C_Person();
        // 为lee所引用的C_Person对象的age、height赋值
        lee.age = 16;
        lee.height = 161;
        // 将zhang变量的值赋给第一个数组元素
        students[0] = zhang;
        // 将lee变量的值赋给第二个数组元素
        students[1] = lee;
        // 下面两孩代码的结果完全一样，因为lee和students[1]
        // 指向的是同一个C_Person实例
        lee.info();
        students[1].info();
    }
}
