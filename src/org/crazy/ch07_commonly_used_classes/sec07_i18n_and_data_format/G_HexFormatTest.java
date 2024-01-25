package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Arrays;
import java.util.HexFormat;

public class G_HexFormatTest {
    public static void main(String[] args) {
        // 创建使用冒号作为分隔符的格式器
        var hexFormat = HexFormat.ofDelimiter(":")
            // 设置使用A~F
            .withUpperCase()
            // 设置使用0x前缀
            .withPrefix("0x");

        byte[] data = {2, 3, 17, 34, 36, 92, 78};

        // 格式化十六进制字符串
        var hexStr = hexFormat.formatHex(data);
        System.out.println(hexStr); // 输出: 0x02:0x03:0x11:0x22:0x24:0x5C:0x4E

        // 将十六进制字符串格式化成字节数组
        var parsedData = hexFormat.parseHex(hexStr);
        System.out.println(Arrays.equals(data, parsedData));

        var bitFormat = HexFormat.of();
        // 将200转换为十六进制字符串
        var hex = bitFormat.toHexDigits(200);
        System.out.println(hex); // 输出000000c8(8为的十六进制，相当于32位的int值)
        // 恢复int值
        System.out.println(HexFormat.fromHexDigits(hex));
        // 将short类型的200转换为十六进制字符串
        var hex2 = bitFormat.toHexDigits((short) 200);
        System.out.println(hex2); // 输出00c8(4为的十六进制数，相当于16位的short值)
    }
}
