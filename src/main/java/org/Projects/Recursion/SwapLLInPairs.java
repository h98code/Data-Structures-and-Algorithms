package org.Projects.Recursion;

import org.Projects.Util.ListNode;

// TC = O(N)
// SC = O(N) --> recursive stack
public class SwapLLInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = head.next;
        ListNode tail = head;
        head = newHead.next;
        newHead.next = tail;
        tail.next = swapPairs(head);

        return newHead;
    }
}
