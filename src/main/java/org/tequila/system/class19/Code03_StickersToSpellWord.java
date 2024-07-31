package org.tequila.system.class19;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Code03_StickersToSpellWord
 * @Description https://leetcode.cn/problems/stickers-to-spell-word/
 * @Author GT-R
 * @Date 2023/8/2715:49
 * @Version 1.0
 */
public class Code03_StickersToSpellWord {
    private int minStickers1(String[] stickers, String target) {
        int N = stickers.length;

        int[][] help = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char aChar : chars) {
                help[i][aChar - 'a']++;
            }
        }
        int ans = process(help, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int process(int[][] help, String t) {
        if (t.length() == 0) {
            return 0;
        }
        char[] target = t.toCharArray();
        int[] count = new int[26];
        for (char c : target) {
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        int N = help.length;
        for (int i = 0; i < N; i++) {
            int[] sticker = help[i];
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0) {
                        int nums = count[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            str.append((char) ('a' + j));
                        }
                    }
                }
                String res = str.toString();
                min = Math.min(min, process(help, res));
            }
        }

        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private int minStickers2(String[] stickers, String target) {
        int N = stickers.length;
        int[][] help = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char aChar : chars) {
                help[i][aChar - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int ans = dp(help, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    private int dp(int[][] help, String t, HashMap<String, Integer> dp) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        char[] target = t.toCharArray();
        int[] count = new int[26];
        for (char c : target) {
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        int N = help.length;
        for (int i = 0; i < N; i++) {
            int[] sticker = help[i];
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0) {
                        int nums = count[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            str.append((char) ('a' + j));
                        }
                    }
                }
                String res = str.toString();
                min = Math.min(min, dp(help, res, dp));
            }
        }
        min += (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, min);
        return min;
    }


    @Test
    public void test() {
        String[] stickers = {"heavy", "claim", "seven", "set", "had", "it", "dead", "jump", "design", "question", "sugar", "dress", "any", "special", "ground", "huge", "use", "busy", "prove", "there", "lone", "window", "trip", "also", "hot", "choose", "tie", "several", "be", "that", "corn", "after", "excite", "insect", "cat", "cook", "glad", "like", "wont", "gray", "especially", "level", "when", "cover", "ocean", "try", "clean", "property", "root", "wing"};
        String target = "travelbell";
        int i = minStickers1(stickers, target);
        System.out.println(i);
    }

}
