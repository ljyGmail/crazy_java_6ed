package org.crazy.ch04_control_flow_and_arrays.sec06_array_deep_dive;

public class D_TwoDimensionTest {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] a;
        // 把a数组当成一维数组进行初始化，初始化a是一个长度为4的数组
        // a数组的数组元素又是引用类型的
        a = new int[4][];
        // 把a数组当成一维数组，遍历a数组的每个数组元素
        for (int i = 0, len = a.length; i < len; i++) {
            System.out.println(a[i]);
        }
        // 初始化a数组的第一个元素
        a[0] = new int[2];
        // 访问a数组的第一个元素所指向数组的第二个元素
        a[0][1] = 6;
        // a数组的第一个元素是一个一维数组，变量这个数组
        for (int i = 0, len = a[0].length; i < len; i++) {
            System.out.println(a[0][i]);
        }

        // 在初始化多维数组时，可以只指定最左边维度的大小，也可以一次性指定每一维的大小
        int[][] b = new int[3][4];
        // 使用静态初始化语法来初始化一个二维数组
        String[][] str1 = new String[][] {new String[3],
            new String[] {"hello"}};
        // 使用简化的静态初始化语法来方式一个二维数组
        String[][] str2 = {new String[3], 
            new String[] {"hello"}};
    }
}
