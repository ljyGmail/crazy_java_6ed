package org.crazy.ch04_control_flow_and_arrays.sec01_branch_statements;

public class D_IfCorrectTest {
    public static void main(String[] args) {
        var age = 45;
        if (age > 60) {
            System.out.println("老年人");
        } else if (age > 40) {
            System.out.println("中年人");
        } else if (age > 20) {
            System.out.println("青年人");
        }
    }
}
