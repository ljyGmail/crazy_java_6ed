package org.crazy.ch03_data_types_and_operators.sec04_primitive_data_types;

public class A_IntegerValTest {
    public static void main(String[] args) {
        // 下面的代码是正确的，系统会自动把56当成byte类型处理
        byte a = 56;
        /*
         * 下面的代码是错误的，系统不会把9999999999999当成long类型处理
		 * 所以超出int类型的表数范围，从而引起错误
		 */
		 // long bigValue = 9999999999999;
		 // 下面的代码是正确的，在巨大的整数值后使用L后缀，强制使用long类型
		 long bigValue2 = 9223372036854775807L;
		 
		 // 以0开头的整数值是八进制整数
		 int octalValue = 013;
		 System.out.println("octalValue： " + octalValue);
		 
		 // 以0x或0X开头的整数值是十六进制整数
		 int hexValue1 = 0x13;
		 int hexValue2 = 0XaF;
		 System.out.println("hexValue1： " + hexValue1);
		 System.out.println("hexValue2： " + hexValue2);
		 
		 // 定义两个8位的二进制整数
		 int binVal1 = 0b11010100;
		 int binVal2 = 0B01101001;
		 // 定义一个32位的二进制整数，最高位是符号位
		 int binVal3 = 0B10000000000000000000000000000011;
		 System.out.println("binVal1: " + binVal1);
		 System.out.println("binVal2: " + binVal2);
		 System.out.println("binVal3: " + binVal3);
		 
		 /*
		 定义一个8位的二进制整数，该数值默认占32位，因此它是一个正数
		 只是在强制类型转换为byte类型时发生了溢出，最终导致binVal4变成了-23
		 */
		 byte binVal4 = (byte) 11101001;
		 /*
		 定义一个32位的二进制整数，最高位是1
		 但由于数值后添加了L后缀，因此该整数实际占64位，此时32位的1不是符号位
		 因此binVal5的等于2的31次方+2+1
		 */
		 long binVal5 = 0B10000000_00000000_00000000_00000011L;
		 System.out.println("binVal4: " + binVal4);
		 System.out.println("binVal5: " + binVal5);
    }
}
