package org.tequila.system.class09;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author GT-R
 * @Date 2023/8/810:18
 * @Version 1.0
 */
public class Utils {
    public void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
