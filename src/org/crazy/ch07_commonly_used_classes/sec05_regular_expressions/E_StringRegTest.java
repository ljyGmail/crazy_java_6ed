package org.crazy.ch07_commonly_used_classes.sec05_regular_expressions;

import java.util.Arrays;

public class E_StringRegTest {
    public static void main(String[] args) {
        String[] msgs = {
            "Java has regular expressions in 1.4",
            "regular expressions now expressing in Java",
            "Java represses oracular expressions"
        };

        for (var msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}
