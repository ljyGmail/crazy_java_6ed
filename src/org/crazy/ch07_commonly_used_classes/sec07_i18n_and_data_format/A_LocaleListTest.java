package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Locale;

public class A_LocaleListTest {
    public static void main(String[] args) {
        // 返回Java所支持的全部国家和语言的数组
        Locale[] localeList = Locale.getAvailableLocales();
        // 遍历数组的每个元素，依次获取所支持的国家和语言
        for (var i = 0; i < localeList.length; i++) {
            // 输出所支持的国家和语言
            System.out.println(localeList[i].getDisplayCountry()
                    + "=" + localeList[i].getCountry() + " "
                    + localeList[i].getDisplayLanguage()
                    + "=" + localeList[i].getLanguage());
        }
    }
}
