package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class AddTwoNumbersAsLL {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode fakeHead = new ListNode();
        ListNode tail = fakeHead;

        int carry = 0;

        while(head1 != null || head2 != null || carry != 0){
            int sum = carry;

            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }

            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }

            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;

            tail.next = temp;
            tail = tail.next;
        }

        return fakeHead.next;
    }
}
