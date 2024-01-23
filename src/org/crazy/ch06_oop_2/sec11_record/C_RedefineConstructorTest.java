package org.crazy.ch06_oop_2.sec11_record;

record C_Name(String first, String last) {
    
    public C_Name(String first, String last) {
        // 对first和last两个组件进行验证
        if (first.length() > 6 || last.length() > 4) {
            throw new IllegalArgumentException(
                    "名不能超过6个字符，且姓不能超过4个字符");
        }

        this.first = first;
        this.last = last;
    }
}

public class C_RedefineConstructorTest {
    public static void main(String[] args) {
        var name1 = new C_Name("悟空", "孙");
        System.out.println(name1);
        // 创建Name失败
        // var name2 = new C_Name("悟空", "疯狂Java");
    }
}
