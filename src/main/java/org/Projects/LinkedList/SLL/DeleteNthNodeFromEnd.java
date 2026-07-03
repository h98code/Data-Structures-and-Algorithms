package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class DeleteNthNodeFromEnd {
    // Approaches :
    // count the total number of nodes and then move count - n nodes in the 2nd iteration and delete

    // take 2 pointers, move the 1st pointer n times, and then move both pointers simultaneously until
    // the 1st pointer reaches the end, then delete the node next to the 2nd pointer.

    // TC = O(N)
    // SC = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        ListNode temp = head;

        for(int i=0; i<n; i++) {
            if(ptr == null) break;

            ptr = ptr.next;
        }

        if(ptr == null) return head.next;

        while(ptr.next != null) {
            ptr = ptr.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
