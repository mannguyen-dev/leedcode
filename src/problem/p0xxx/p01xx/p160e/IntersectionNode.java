package problem.p0xxx.p01xx.p160e;

import dsa.linkedlist.ListNode;
import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();

        while (headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if (hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2){
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }

        return l1;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,8,4,5};
        int[] arr2 = {5,6,1,8,4,5};
        ListNode headA = ListNode.createLinkedList(arr1);
        ListNode headB = ListNode.createLinkedList(arr2);
        UtilityClass.logResult(getIntersectionNode(headA, headB));
    }
}
