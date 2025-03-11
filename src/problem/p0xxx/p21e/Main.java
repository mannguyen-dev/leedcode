package problem.p0xxx.p21e;

import dsa.linkedlist.ListNode;

public class Main {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode e1 = list1;
        ListNode e2 = list2;
        ListNode res;

        if (list1 == null && list2 == null){
            return null;
        }

        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        if (list1.val > list2.val){
            res = list2;
            e2 = list2.next;
        } else {
            res = list1;
            e1 = list1.next;
        }
        ListNode cur = res;

        while (e1 != null && e2 != null){
            if (e1.val > e2.val){
                cur.next = e2;
                e2 = e2.next;
            } else {
                cur.next = e1;
                e1 = e1.next;
            }
            cur = cur.next;
        }

        if (e1 != null){
            cur.next = e1;
        }

        if (e2 != null){
            cur.next = e2;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = null;
        int[] arr2 = {1,3,4};
        ListNode list1 = ListNode.createLinkedList(arr1);
        ListNode list2 = ListNode.createLinkedList(arr2);
        mergeTwoLists(list1, list2).printList();
    }
}
