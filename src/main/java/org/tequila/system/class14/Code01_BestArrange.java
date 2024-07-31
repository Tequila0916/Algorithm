package org.tequila.system.class14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Code01_BestArrange
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/2011:16
 * @Version 1.0
 */
public class Code01_BestArrange {
    public int bestArrange(Meetings[] meetings) {
        Arrays.sort(meetings, new ProgramComparator());
        int timeLine = 0;
        int result = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (timeLine <= meetings[i].start) {
                result++;
                timeLine = meetings[i].end;
            }
        }
        return result;
    }

    public class ProgramComparator implements Comparator<Meetings> {
        @Override
        public int compare(Meetings o1, Meetings o2) {
            return o1.end-o2.end;
        }
    }
}
