package org.Projects.Recursion;

public class MergeTwoLL {
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // TC = O(L1 + L2) --> since the lists are merged node by node.
    // SC = O(L1 + L2) --> recursion depth.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;

        if(list2 == null)
            return list1;

        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
