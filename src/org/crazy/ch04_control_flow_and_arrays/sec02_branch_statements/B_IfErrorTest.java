package org.crazy.ch04_control_flow_and_arrays.sec02_branch_statements;

public class B_IfErrorTest {
    public static void main(String[] args) {
        var age = 45;
        if(age > 20) {
            System.out.println("青年人");
        } else if (age > 40) {
            System.out.println("中年人");
        } else if (age > 60) {
            System.out.println("老年人");
        }
    }
}
