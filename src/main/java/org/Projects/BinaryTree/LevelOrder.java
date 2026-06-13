package org.Projects.BinaryTree;

import org.Projects.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();

        if(root == null)
            return ans;

        bfsQ.add(root);

        while(!bfsQ.isEmpty()) {
            int sz = bfsQ.size();

            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<sz; i++){
                TreeNode curr = bfsQ.poll();
                temp.add(curr.val);

                if(curr.left != null) bfsQ.add(curr.left);
                if(curr.right != null) bfsQ.add(curr.right);
            }

            ans.add(temp);
        }

        return ans;
    }
}
