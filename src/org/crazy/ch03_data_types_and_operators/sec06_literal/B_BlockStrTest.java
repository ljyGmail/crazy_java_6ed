package org.crazy.ch03_data_types_and_operators.sec06_literal;

public class B_BlockStrTest {
    public static void main(String[] args) {
        // 定义一段JSON字符串
        var user = "{\n"
            + " 'name': 'yeeku',\n"
            + " 'age': 25\n"
            + "}\n";
        System.out.println(user);

        // 使用块字符串定义JSON字符串
        var user1 = """
            {
                'name': 'yeeku',
                'age': 25
            }
            """;
        System.out.println(user1);
    }
}
