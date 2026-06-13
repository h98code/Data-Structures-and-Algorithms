package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    // use a pointer to point to the current node in the inOrder traversal
    // insert all the left nodes for any given node
    // now, since the left nodes are visited, add the current node in the ans and remove it from the stack
    // point the ptr to the right child of the popped node

    // TC = O(N)
    // SC = O(H)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        TreeNode ptr = root;

        while(ptr != null || !stk.empty()){
            while(ptr != null){ // pushing the nodes till the leftmost node of the tree
                stk.push(ptr);
                ptr = ptr.left;
            }

            ptr = stk.pop(); // left nodes of the current nodes are visited

            ans.add(ptr.val); // store the value of the current node

            ptr = ptr.right; // and move to the right node
        }

        return ans;
    }
}
