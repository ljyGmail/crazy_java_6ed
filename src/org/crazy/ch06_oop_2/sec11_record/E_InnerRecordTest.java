package org.crazy.ch06_oop_2.sec11_record;

class E_Out {
    private int foo;

    // 下面的static修饰符写不写都一样
    public static record Address(String detail, String zip) {
        public void test() {
            // 下面的代码编译时报错
            // System.out.println(foo);
        }
    }
}

public class E_InnerRecordTest {
    public static void main(String[] args) {
        E_Out.Address addr = new E_Out.Address("广州天河", "510000");
        System.out.println(addr);
    }
}
