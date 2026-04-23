package org.Projects.BinaryTree;

public class Lca {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    // function returns treenode if p or q are found else return null,
    // if both are found then it returns the lca.

    // TC = O(N) PostOrder Traversal
    // SC = O(H) recursion depth
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        //get the result from the left subtree
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);

        // get the result from the right subtree
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        // process the reseult from the current node
        boolean bothChildrenPresent = (leftTree != null && rightTree != null);
        boolean isNodeP_or_Q = (root == p || root == q);

        if(bothChildrenPresent || isNodeP_or_Q)
            return root;

        return (leftTree == null) ? rightTree : leftTree;
    }
}
