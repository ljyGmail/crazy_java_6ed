package org.crazy.ch07_commonly_used_classes.sec05_regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_MatchesTest {
    public static void main(String[] args) {
        String[] mails = {
            "kongyeeku@163.com",
            "kongyeeku@gmail.com",
            "ligang@crazyit.org",
            "wawa@abc.xx"
        };

        var mailRegex = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        var mailPattern = Pattern.compile(mailRegex);
        Matcher matcher = null;
        for (var mail : mails) {
            if (matcher == null) {
                System.out.println("1111");
                matcher = mailPattern.matcher(mail);
            } else {
                System.out.println("2222");
                matcher.reset(mail);
            }

            String result = mail + (matcher.matches() ? "是" : "不是")
                + "一个有效的邮件地址";
            System.out.println(result);
        }

        // String类也提供了matches方法，返回该字符串是否匹配指定的正则表达式
        System.out.println("kongyeeku@163.com"
                .matches("\\w{3,20}@\\w+\\.(com|org|cn|net|gov)"));
    }
}
