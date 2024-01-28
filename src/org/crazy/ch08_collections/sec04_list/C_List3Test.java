package org.crazy.ch08_collections.sec04_list;

import java.util.ArrayList;

public class C_List3Test {
    public static void main(String[] args) {
        var books = new ArrayList();
        // 向books集合中添加4个元素
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂iOS讲义");
        // 使用目标类型为Comparator的Lambda表达式对List集合进行排序
        books.sort((o1, o2) -> ((String) o1).length() - ((String) o2).length());
        System.out.println(books); // 输出[疯狂iOS讲义, 疯狂Java讲义, 疯狂Android讲义, 轻量级Java EE企业应用实战]

        // 使用目标类型为UnaryOperator的Lambda表达式来替换集合中所有的元素
        // 该Lambda表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele -> ((String) ele).length());
                System.out.println(books); // 输出[7, 8, 11, 16]
    }
}
