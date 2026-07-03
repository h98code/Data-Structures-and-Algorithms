package org.Projects.Recursion;

import org.Projects.Util.ListNode;

public class ReverseLinkedList {

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
