package org.tequila.system.class14;

/**
 * @ClassName Code04_Light
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2014:25
 * @Version 1.0
 */
public class Code04_Light {
    public static int minLight(String road) {
        char[] chars = road.toCharArray();
        int index = 0;
        int result = 0;
        while (index < chars.length) {
            if (chars[index] == 'X') {
                index++;
            } else {
                result++;
                if (index + 1 == chars.length) {
                    break;
                } else {
                    if (chars[index + 1] == 'X') {
                        index += 2;
                    } else {
                        index += 3;
                    }
                }
            }
        }
        return result;
    }
}
