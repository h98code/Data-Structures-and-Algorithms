package org.Projects.Recursion;

public class HeightOfBT {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // TC = O(N) --> we are visiting each node once.
    // SC = O(H) --> recursive stack space, where H is the height of the tree.
    //      worst case : O(N)
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
