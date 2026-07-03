package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class ReorderList {

    // final list should be in the order [1, n, 2, n - 1, 3, n - 2 . . . ]

    // TC = O(N)
    // SC = O(1)
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        ListNode secondHead = findMid(head);
        secondHead = reverse(secondHead);

        ListNode ptr = head;
        while(secondHead != null && ptr != null) {
            ListNode nextNode = secondHead.next;
            secondHead.next = ptr.next;
            ptr.next = secondHead;
            ptr = ptr.next.next;
            secondHead = nextNode;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        return temp;
    }

    private ListNode reverse(ListNode head) {
        ListNode left = head;
        ListNode curr = head.next;
        left.next = null;

        while(curr != null) {
            ListNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }

        return left;
    }
}
