package org.tequila.system.class17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Code03_PrintAllSubsquences
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2313:59
 * @Version 1.0
 */
public class Code03_PrintAllSubsquences {
    public  List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    /**
     *
     * @param str 固定参数不变
     * @param index 字符数组下标，此时来到的位置 要 or 不要 ， 来到str[index]字符
     * @param ans 如果index来到str的中止位置，把沿途路径所形成的答案，放入ans中
     * @param path str[0,index-1]已经走过了的，即之前作出的选择，就是path
     */
    public void process1(char[] str,int index,List<String> ans,String path){
        if(index==str.length){
            ans.add(path);
            return;
        }
        process1(str,index+1,ans,path);
        process1(str,index+1,ans,path+String.valueOf(str[index]));
    }
    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }
    public static void process2(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        process2(str, index + 1, set, path);
        process2(str, index + 1, set, path + String.valueOf(str[index]));
    }


    @Test
    public void testSubs(){
        List<String> abc = subs("abc");
        System.out.println("abc = " + abc);
        List<String> accc = subsNoRepeat("accc");
        System.out.println("accc = " + accc);
    }
}
