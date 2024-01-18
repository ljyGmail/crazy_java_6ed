package org.crazy.ch06_oop_2.sec04_final_modifier;

class N_Name {
    private String firstName;
    private String lastName;

    public N_Name() {}

    public N_Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class N_PersonTest {
    private final N_Name name;

    public N_PersonTest(N_Name name) {
        this.name = name;
    }

    public N_Name getName() {
        return this.name;
    }

    public static void main(String[] args) {
        var n = new N_Name("悟空", "孙");
        var p = new N_PersonTest(n);
        // Person对象的name的firstName值为"悟空"
        System.out.println(p.getName().getFirstName());
        // 改变Person对象的name的firstName值
        n.setFirstName("八戒");
        // Person对象的name的firstName值被改为"八戒"
        System.out.println(p.getName().getFirstName());
    }
}
