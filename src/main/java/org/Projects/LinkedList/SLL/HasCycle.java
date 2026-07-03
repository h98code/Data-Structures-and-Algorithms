package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class HasCycle {

    // Approaches :

    // change the value of the linked list to some other values
    // use a fake node and traverse and change the pointers to fake node
    // use a map to store the addresses of the nodes
    // use hare and tortoise

    // TC = O(N)
    // SC = O(1)
    public boolean hasCycle(ListNode head) {

        if(head == null)
            return false;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }
}
