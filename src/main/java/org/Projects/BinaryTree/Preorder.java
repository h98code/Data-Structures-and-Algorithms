package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {


    // iterative InOrder traversal
    // TC = O(N)
    // SC = O(H) where H is the height of the tree, in worst case it can be O(N) if the tree is skewed.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        if(root == null)
            return ans;

        stk.push(root);

        while(!stk.empty()){
            TreeNode curr = stk.pop();
            ans.add(curr.val);
            if(curr.right != null) stk.push(curr.right);
            if(curr.left != null) stk.push(curr.left);
        }

        return ans;
    }
}
