package problem.p0xxx.p83e;

import dsa.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode curNode = head;
        while (curNode != null){
            while (curNode.next != null && curNode.val == curNode.next.val) curNode.next = curNode.next.next;
            curNode = curNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3, 3};
        ListNode list = ListNode.createLinkedList(arr);
        deleteDuplicates(list).printList();
    }
}
