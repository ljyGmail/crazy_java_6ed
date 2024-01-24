package org.crazy.ch07_commonly_used_classes.sec05_regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D_ReplaceTest {
    public static void main(String[] args) {
        String[] msgs = {
            "Java has regular expressions in 1.4",
            "regular expressions now expressing in Java",
            "Java represses ooracular expressions"
        };

        var p = Pattern.compile("re\\w*");
        Matcher matcher = null;

        for (var i = 0; i < msgs.length; i++) {
            if (matcher == null) {
                matcher = p.matcher(msgs[i]);
            } else {
                matcher.reset(msgs[i]);
            }
            System.out.println("@@@" + msgs[i]);
            System.out.println("###" + matcher.replaceAll("哈哈:)"));
        }
    }
}
