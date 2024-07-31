package org.tequila.system.class07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ShowHeapGreater
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/119:02
 * @Version 1.0
 */
public class ShowHeapGreater {
    private final int k;
    private HashMap<Integer, Customer> map;
    private HeapGreater<Customer> cands;
    private HeapGreater<Customer> winns;

    public ShowHeapGreater(int k) {
        map = new HashMap<Integer, Customer>();
        cands = new HeapGreater<>(new CandidateComparator());
        winns = new HeapGreater<>(new WinningComparator());
        this.k = k;
    }

    public void operate(int time, int id, boolean buyOrRefund) {
        if (!buyOrRefund && !map.containsKey(id)) {
            return;
        }
        if (!map.containsKey(id)) {
            map.put(id, new Customer(id, 0, 0));
        }
        Customer c = map.get(id);
        if (buyOrRefund) {
            c.buy++;
        } else {
            c.buy--;
        }
        if (c.buy == 0) {
            map.remove(id);
        }
        if (!cands.contains(c) && !winns.contains(c)) {
            if (winns.size() < k) {
                c.enterTime = time;
                winns.push(c);
            } else {
                c.enterTime = time;
                cands.push(c);
            }
        } else if (cands.contains(c)) {
            if (c.buy == 0) {
                cands.remove(c);
            } else {
                cands.resign(c);
            }
        } else if (winns.contains(c)) {
            if (c.buy == 0) {
                winns.remove(c);
            } else {
                winns.resign(c);
            }
        }
        move(time);
    }

    private void move(int time) {
        if (cands.isEmpty()) {
            return;
        }
        if(winns.size()<k){
            Customer pop = cands.pop();
            pop.enterTime = time;
            winns.push(pop);
        }else {
            if (cands.peek().buy > winns.peek().buy) {
                Customer cand = cands.pop();
                Customer winn = winns.pop();
                cand.enterTime = time;
                winn.enterTime = time;
                winns.push(cand);
                cands.push(winn);
            }
        }
    }

    public List<Integer> getCurAns() {
        List<Customer> customers = winns.getAllElements();
        ArrayList<Integer> ans = new ArrayList<>();
        for(Customer c : customers){
            ans.add(c.id);
        }
        return ans;
    }
}
