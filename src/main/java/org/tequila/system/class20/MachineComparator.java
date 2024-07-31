package org.tequila.system.class20;

import java.util.Comparator;

/**
 * @ClassName MachineComparator
 * @Description TODO
 * @Author GT-R
 * @Date 2023/9/219:51
 * @Version 1.0
 */
public class MachineComparator implements Comparator<Machine> {
    @Override
    public int compare(Machine o1, Machine o2) {
        return (o1.timePoint+o1.workTime)-(o2.timePoint+o2.workTime);
    }
}
