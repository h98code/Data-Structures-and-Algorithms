package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class IsPalindrome {

    // TC  = O(N) : N for finding Mid, N/2 for reversing and N/2 for simultaneous checking
    // SC = O(1)
    public boolean isPalindrome(ListNode head) {
        // break the linked list in 2 parts with 1st part having more nodes
        // reverse any part ( we will do 2nd part)
        // traverse till the end and match the nodes of the linked list
        // if match not found for any node return false

        if(head == null || head.next == null)
            return true;

        ListNode secondHead = findMid(head);
        secondHead = reverseList(secondHead);

        while(secondHead != null && head != null) {
            if(head.val != secondHead.val) {
                return false;
            }

            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = head;
        ListNode curr = prev.next;
        prev.next = null;

        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
