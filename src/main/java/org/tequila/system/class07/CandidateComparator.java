package org.tequila.system.class07;

import java.util.Comparator;

/**
 * @ClassName CandidateComparator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/116:44
 * @Version 1.0
 */
public class CandidateComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.buy != c2.buy ? c2.buy - c1.buy : c1.enterTime - c2.enterTime;
    }
}
