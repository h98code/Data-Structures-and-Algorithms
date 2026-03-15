package org.Projects.Recursion;

public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode globalHead = null;

    public ListNode reverseList(ListNode head) {
        reverseListHelper(head);
        return globalHead;
    }

    private void reverseListHelper(ListNode head){
        //base condition
        if(head == null || head.next == null){
            globalHead = head;
            return;
        }

        reverseListHelper(head.next);
        head.next.next = head;
        head.next = null;
    }
}
