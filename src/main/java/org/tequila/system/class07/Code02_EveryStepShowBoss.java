package org.tequila.system.class07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Code02_EveryStepShowBoss
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/116:40
 * @Version 1.0
 */
public class Code02_EveryStepShowBoss {

    public List<List<Integer>> topK(int[] arr, boolean[] op, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ShowHeapGreater greater = new ShowHeapGreater(k);
        for (int i = 0; i < arr.length; i++) {
            greater.operate(i, arr[i], op[i]);
            ans.add(greater.getCurAns());
        }
        return ans;
    }


    public List<List<Integer>> compare(int[] arr, boolean[] op, int k) {
        HashMap<Integer, Customer> map = new HashMap<>();
        ArrayList<Customer> cands = new ArrayList<>();
        ArrayList<Customer> winns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];
            if (!buyOrRefund && !map.containsKey(id)) {
                ans.add(getCurAns(winns));
                continue;
            }
            if (!map.containsKey(id)) {
                map.put(id, new Customer(id, 0, 0));
            }
            Customer customer = map.get(id);
            if (buyOrRefund) {
                customer.buy++;
            } else {
                customer.buy--;
            }
            if (customer.buy == 0) {
                map.remove(id);
            }
            if (!cands.contains(customer) && !winns.contains(customer)) {
                if (winns.size() < k) {
                    customer.enterTime = i;
                    winns.add(customer);
                } else {
                    customer.enterTime = i;
                    cands.add(customer);
                }
            }
            cleanZeroBuy(winns);
            cleanZeroBuy(cands);
            winns.sort(new WinningComparator());
            cands.sort(new CandidateComparator());
            move(cands, winns, k, i);
            ans.add(getCurAns(winns));
        }
        return ans;
    }

    public void move(ArrayList<Customer> cands, ArrayList<Customer> winns, int k, int time) {
        if (cands.isEmpty()) {
            return;
        }
        if (winns.size() < k) {
            Customer customer = cands.get(0);
            customer.enterTime = time;
            winns.add(customer);
            cands.remove(0);
        } else {
            if (cands.get(0).buy > winns.get(0).buy) {
                Customer winn = winns.get(0);
                Customer cand = cands.get(0);
                winns.remove(0);
                cands.remove(0);
                winn.enterTime = time;
                cand.enterTime = time;
                cands.add(winn);
                winns.add(cand);
            }
        }

    }

    public void cleanZeroBuy(ArrayList<Customer> arr) {
        List<Customer> noZero = new ArrayList<Customer>();
        for (Customer c : arr) {
            if (c.buy != 0) {
                noZero.add(c);
            }
        }
        arr.clear();
        for (Customer c : noZero) {
            arr.add(c);
        }
    }

    public List<Integer> getCurAns(ArrayList<Customer> winns) {
        List<Integer> ans = new ArrayList<>();
        for (Customer c : winns) {
            ans.add(c.id);
        }
        return ans;
    }

    @Test
    public void testTopk() {
        int maxValue = 10;
        int maxLen = 100;
        int maxK = 6;
        int testTimes = 100000;
        Utils util = new Utils();
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Data testData = util.randomData(maxValue, maxLen);
            int k = (int) (Math.random() * maxK) + 1;
            int[] arr = testData.arr;
            boolean[] op = testData.op;
            List<List<Integer>> ans1 = topK(arr, op, k);
            List<List<Integer>> ans2 = compare(arr, op, k);
            if (!util.sameAnswer(ans1, ans2)) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j] + " , " + op[j]);
                }
                System.out.println(k);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");
    }

}
