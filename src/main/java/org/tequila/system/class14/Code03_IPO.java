package org.tequila.system.class14;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Code04_IPO
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2014:09
 * @Version 1.0
 */
public class Code03_IPO {
    public int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Business> minCostQ = new PriorityQueue<>(new BusinessComparatorCapital());
        PriorityQueue<Business> maxProfitQ = new PriorityQueue<>(new BusinessComparatorProfits());
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Business(Profits[i], Capital[i]));
        }
        for (int i = 0; i < K; i++) {
            while (!minCostQ.isEmpty() && W >= minCostQ.peek().capital) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().profits;
        }
        return W;
    }

    public class BusinessComparatorCapital implements Comparator<Business> {

        @Override
        public int compare(Business o1, Business o2) {
            return o1.capital - o2.capital;
        }
    }

    public class BusinessComparatorProfits implements Comparator<Business> {

        @Override
        public int compare(Business o1, Business o2) {
            return o2.profits - o1.profits;

        }
    }
}
