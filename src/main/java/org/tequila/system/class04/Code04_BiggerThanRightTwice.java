package org.tequila.system.class04;

/**
 * @ClassName Code04_BiggerThanRightTwice
 * @Description https://leetcode.cn/problems/reverse-pairs/
 * @Author GT-R
 * @Date 2023/7/1816:29
 * @Version 1.0
 */
public class Code04_BiggerThanRightTwice {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(nums, l, m) + process(nums, m + 1, r) + merge(nums, l, m, r);
    }

    private int merge(int[] nums, int l, int m, int r) {
        int res = 0;
        int ans = m + 1;
        for (int i = l; i <= m; i++) {
            while (ans <= r && (long)nums[i] >(long) nums[ans] * 2) {
                ans++;
            }
            res += ans - m - 1;
        }


        int[] help = new int[r - l + 1];
        int index = help.length - 1;
        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 > m) {
            help[index--] = nums[p1] <= nums[p2] ? nums[p2--] : nums[p1--];
        }
        while (p1 >= l) {
            help[index--] = nums[p1--];
        }
        while (p2 > m) {
            help[index--] = nums[p2--];
        }
        for (index = 0; index < help.length; index++) {
            nums[l + index] = help[index];

        }
        return res;
    }
}
