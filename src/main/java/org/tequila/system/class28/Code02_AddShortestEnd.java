package org.tequila.system.class28;

import org.junit.Test;

/**
 * @ClassName Code02_AddShortestEnd
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/710:02
 * @Version 1.0
 */
public class Code02_AddShortestEnd {
    public char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    @Test
    public void testAddShortestEnd() {
        String str1 = "aaaabaaaa123321aa";
        System.out.println(shortestEnd(str1));
        System.out.println(longestPalindrome(str1));
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()<1){
            return null;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = i < R ? Math.min(pArr[2*C-i],R-i):1;
            while (i+pArr[i]<str.length&&i-pArr[i]>-1){
                if(str[i+pArr[i]]==str[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
                if(i+pArr[i]>R){
                    R = i+pArr[i];
                    C = i;
                }
                if(max<pArr[i]){
                    max = pArr[i];
                    end = R -1;
                }
            }
        }
        // # a # a # 1 # 2 # 3 #  2  #  1  #
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        // end = 14  max = 6
        char[] res = new char[max-1];
        for (int i = 0; i < res.length; i++) {
            res[i] = str[2*i+1+end-(max-1)*2];
        }
        return String.valueOf(res);
    }

    private String shortestEnd(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        char[] str = manacherString(s);
        int R = -1;
        int C = -1;
        int[] pArr = new int[str.length];
        int maxContainsEnd = -1;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = i < R ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if(str[i+pArr[i]]==str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
                if(i+pArr[i]>R){
                    R = i+pArr[i];
                    C = i;
                }
                if(R == str.length){
                    maxContainsEnd = pArr[i];
                    break;
                }
            }
        }
        char[] res = new char[s.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length-1-i] = str[i*2+1];
        }
        return String.valueOf(res);
    }
}
