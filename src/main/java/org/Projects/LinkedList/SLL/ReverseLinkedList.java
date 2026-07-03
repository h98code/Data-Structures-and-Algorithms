package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class ReverseLinkedList {

    private ListNode globalHead = null;

    // TC = O(N)
    // SC = O(1)
    public ListNode reverseList_itr(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode left = head, curr = head.next;
        left.next = null;

        while(curr != null){
            ListNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }

        return left;
    }


    // TC = O(N)
    // SC = O(N) recursion stack depth
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
