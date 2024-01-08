package org.crazy.ch03_data_types_and_operators.sec05_type_cast_for_primitives;

public class D_RandomStr {
    public static void main(String[] args) {
        // 定义一个空字符串
        var result = "";
        // 进行6次循环
        for (var i = 0; i < 6; i++) {
            // 生成一个97～122之间的int类型的整数
            var intVal = (int) (Math.random() * 26 + 97);
            // 将intVal强制转换为char类型后连接到result后面
            result = result + (char) intVal;
        }
        // 输出随机字符串
        System.out.println(result);
    }
}
