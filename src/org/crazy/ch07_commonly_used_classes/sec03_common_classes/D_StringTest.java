package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

public class D_StringTest {
    public static void main(String[] args) {
        var s = "fkit.org";
        System.out.println("s.charAt(5): " + s.charAt(5));

        var s1 = "abcdefghijklmn";
        var s2 = "abcdefghij";
        var s3 = "abcdefghijalmn";
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2)); // 返回长度差: 4
        System.out.println("s1.compareTo(s3): " + s1.compareTo(s3)); // 返回'k' - 'a'的差: 10

        var s4 = "fkit.org";
        var s5 = ".org";
        System.out.println("s4.endsWith(s5): " + s4.endsWith(s5)); // 输出true

        char[] s6 = {'I', ' ', 'l', 'o', 'v', 'e', ' ', 'j', 'a', 'v', 'a'}; // s6=I love java
        var s7 = "ejb";
        s7.getChars(0, 3, s6, 7); // s6=I love ejba
        System.out.println(s6);

        var sa = "www.fkit.org";
        var ss = "it";
        System.out.println("sa.indexOf('r'): " + sa.indexOf('r')); // 10
        System.out.println("sa.indexOf('r', 2): " + sa.indexOf('r', 2)); // 10
        System.out.println("sa.indexOf(ss): " + sa.indexOf(ss)); // 6

        var sa1 = "www.fkit.org";
        var ss1 = "www";
        var sss = "fkit";
        System.out.println("sa1.startsWith(ss1): " + sa1.startsWith(ss1)); // true
        System.out.println("sa1.startsWith(sss, 4): " + sa1.startsWith(sss, 4)); // true

        var st = "fkjava.org";
        System.out.println("st.toUpperCase(): " + st.toUpperCase());
        System.out.println("st.toLowerCase(): " + st.toLowerCase());

        var str1 = "java";
        str1 = str1 + "struts";
        str1 = str1 + "spring";
        System.out.println("str1: " + str1);
    }
}
