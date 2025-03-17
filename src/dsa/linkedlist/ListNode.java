package dsa.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printList(){
        ListNode cur = this;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode createLinkedList(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }
}
