package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

public class Symmetric {


    // TC = O(N)
    // SC = O(Height)
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null)
            return true;

        if((r1 != null && r2 == null) || (r1 == null && r2 != null))
            return false;

        if(r1.val != r2.val)
            return false;

        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}
