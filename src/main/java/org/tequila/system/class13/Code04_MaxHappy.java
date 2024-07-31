package org.tequila.system.class13;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code04_MaxHappy
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/1616:47
 * @Version 1.0
 */
public class Code04_MaxHappy {

    public int maxHappy(Employee head) {
        Info allInfo = process(head);
        return Math.max(allInfo.no, allInfo.yes);
    }

    public Info process(Employee x) {
        if (x == null) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = x.happy;
        for (Employee next : x.nexts) {
            Info info = process(next);
            yes += info.no;
            no += Math.max(info.no, info.yes);
        }
        return new Info(no, yes);
    }

    public class Info {
        public int no;
        public int yes;

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }

    }
}
