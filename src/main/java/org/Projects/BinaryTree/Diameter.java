package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

public class Diameter {


    // TC = O(N)
    // SC = O(N)

    // post order traversal used to calculate the diameter of the binary tree,
    // we will calculate the height of the left and right subtree and update the diameter at each node.
    // instead of calculating the height of the subtrees at every node.
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];

        calcHeight(root, ans);
        return ans[0];
    }

    private int calcHeight(TreeNode root, int[] ans){
        if(root == null)
            return 0;

        int lh = calcHeight(root.left, ans);
        int rh = calcHeight(root.right, ans);

        int tempDiameter = lh + rh;
        ans[0] = Math.max(ans[0], tempDiameter);

        return Math.max(lh, rh) + 1;
    }
}
