package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> visited=new ArrayList<>();
        postOrder(root,visited);
        return visited;
    }

    public void postOrder(TreeNode cur, List<Integer> visited){
        if(cur!=null){
            visited.add(cur.val);
            if(cur.left!=null)postOrder(cur.left,visited);
            if(cur.right!=null)postOrder(cur.right,visited);

        }
    }
}
