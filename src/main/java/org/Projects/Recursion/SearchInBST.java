package org.Projects.Recursion;


public class SearchInBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // TC = O(N)
    // SC = O(HEIGHT OF THE TREE) --> recursive stack
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        if(root.val < val){
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);
    }
}
