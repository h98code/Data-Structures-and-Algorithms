package org.Projects.LinkedList.SLL;

import org.Projects.Util.ListNode;

public class MergeTwoSortedLL {

    // TC  = O(m + n)
    // SC = O(1) as the links of the nodes are used to rearrange.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dh = new ListNode();
        ListNode dt = dh;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                dt.next = list1;
                list1 = list1.next;
            }else{
                dt.next = list2;
                list2 = list2.next;
            }

            dt = dt.next;
        }

        if(list1 == null){
            dt.next = list2;
        }else{
            dt.next = list1;
        }

        return dh.next;
    }

    // TC = O(m + n)
    // SC = O(m + n) recursion depth can be equal to total number of nodes
    public ListNode mergeTwoLists_recursive(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        if(list1.val <= list2.val){
            list1.next = mergeTwoLists_recursive(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists_recursive(list1, list2.next);
        return list2;
    }
}
