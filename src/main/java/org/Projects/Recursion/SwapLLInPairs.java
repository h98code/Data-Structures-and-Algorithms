package org.Projects.Recursion;

// TC = O(N)
// SC = O(N) --> recursive stack
public class SwapLLInPairs {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
