package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> visited=new ArrayList<>();
        postOrder(root,visited);
        return visited;
    }

    public void postOrder(TreeNode cur,List<Integer> visited){
        if(cur!=null){
            if(cur.left!=null)postOrder(cur.left,visited);
            if(cur.right!=null)postOrder(cur.right,visited);
            visited.add(cur.val);
        }
    }
}
