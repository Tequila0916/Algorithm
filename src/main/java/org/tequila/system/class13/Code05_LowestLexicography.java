package org.tequila.system.class13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Code05_LowestLexicography
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1617:42
 * @Version 1.0
 */
public class Code05_LowestLexicography {
    public String lowestString(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
