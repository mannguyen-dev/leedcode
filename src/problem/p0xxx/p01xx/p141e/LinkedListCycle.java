package problem.p0xxx.p01xx.p141e;

import dsa.linkedlist.ListNode;
import problem.UtilityClass;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode fastP = head;
        ListNode slowP = head;

        while (fastP != null && fastP.next != null){
            fastP = fastP.next.next;
            slowP = slowP.next;

            if (fastP == slowP) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head =  ListNode.createLinkedList(arr);
        UtilityClass.logResult(hasCycle(head));
    }
}
