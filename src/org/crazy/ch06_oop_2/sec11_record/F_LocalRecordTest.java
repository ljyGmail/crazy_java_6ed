package org.crazy.ch06_oop_2.sec11_record;

class F_Out {

    private static String str = "fkjava";

    private int foo;

    public void test() {
        int bar = 2;

        // 下面的局部Record类不能用static修饰，但它依然是隐式静态的
        record Address(String detail, String zip) {
            public void test() {
                System.out.println(str);
                // 下面两行代码编译时报错
                // System.out.println(foo);
                // System.out.println(bar);
            }
        }

        Address addr = new Address("铁岭", "112000");
        addr.test();
    }
}

public class F_LocalRecordTest {
    public static void main(String[] args) {
        F_Out out = new F_Out();
        out.test();
    }
}
