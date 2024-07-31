package org.tequila.system.class19;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2715:07
 * @Version 1.0
 */
public class Utils {
    public static String randomString(int len) {
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = (char) ((int) (Math.random() * 10) + '0');
        }
        return String.valueOf(str);
    }
}
