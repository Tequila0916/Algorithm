package org.tequila.system.class29;

import java.util.Comparator;

/**
 * @ClassName MaxHeapComparator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/12/910:58
 * @Version 1.0
 */
public class MaxHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
