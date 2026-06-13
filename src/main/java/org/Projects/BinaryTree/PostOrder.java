package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    // TC = O(N)
    // SC = O(H)
    // reverse the ansList that we get from reversePreOrder

    // reverse PreOrder = N R L
    // reverse it and we will get L R N --> post Order Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        if(root == null) {
            return ans;
        }

        stk.push(root);

        while(!stk.empty()){
            TreeNode curr = stk.pop();
            ans.add(curr.val);

            if(curr.left != null) stk.push(curr.left);
            if(curr.right != null) stk.push(curr.right);
        }

        Collections.reverse(ans);

        return ans;
    }
}
