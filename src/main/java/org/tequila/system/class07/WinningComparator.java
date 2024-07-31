package org.tequila.system.class07;

import java.util.Comparator;

/**
 * @ClassName WinningComparator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/116:47
 * @Version 1.0
 */
public class WinningComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.buy != c2.buy ? c1.buy - c2.buy : c1.enterTime - c2.enterTime;
    }
}
