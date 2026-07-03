package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class FindMid {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
