package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> visited=new ArrayList<>();
        preOrder(root,visited);
        return visited;
    }

    private void preOrder(TreeNode cur, List<Integer> visited){
        if(cur!=null){
            if(cur.left!=null)preOrder(cur.left,visited);
            visited.add(cur.val);
            if(cur.right!=null)preOrder(cur.right,visited);
        }
    }
}
