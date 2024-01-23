package org.crazy.ch06_oop_2.sec11_record;

record D_Name(String first, String last) {
    public D_Name {
        // 对first和last两个组件进行验证
        if (first.length() > 6 || last.length() > 4) {
            // 当验证失败时抛出异常，避免创建不符合规定的Name对象
            throw new IllegalArgumentException(
                    "名不能超过6个字符，且姓不能超过4个字符");
        }
    }
}

public class D_RedefineConstructor2Test {
    public static void main(String[] args) {
        var name1 = new D_Name("悟空", "孙");
        System.out.println(name1);
        // 创建Name失败
        // var name2 = new D_Name("悟空", "疯狂Java");
    }
}
