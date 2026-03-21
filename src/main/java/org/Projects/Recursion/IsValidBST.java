package org.Projects.Recursion;

public class IsValidBST {

    class TreeNode {
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


    //global variables to store the previous value in the inorder traversal
        // needed with helper with one arg.
    boolean isPrevSet = false;
    int prev = 0;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
//        helper(root);
//        return ans;
        return helper(root, (long)Integer.MIN_VALUE , (long)Integer.MAX_VALUE);
    }

    // TC = O(N) --> we are visiting each node once.
    // SC = O(H) --> recursive stack space, where H is the height of the tree.
    //      worst case : O(N)
    public void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        //comparing the current node value with prev value in the inorder traversal.
        if(!isPrevSet){
            isPrevSet = true;
        }else{
            if(prev >= root.val)
                ans = false;
        }
        prev = root.val;

        helper(root.right);
    }


    // TC = O(N) --> we are visiting each node once.
    // SC = O(H) --> recursive stack space, where H is the height of the tree.
    //      worst case : O(N)
    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if(root == null) return true;

        if(root.val < minValue || root.val > maxValue)
            return false;

        return helper(root.left, minValue, root.val - 1) && helper(root.right, root.val + 1, maxValue);
    }
}
