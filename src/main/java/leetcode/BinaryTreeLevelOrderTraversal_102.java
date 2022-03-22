package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        List<List<Integer>> answer=new ArrayList<>();
        List<TreeNode> temp=new ArrayList<>();
        List<TreeNode> curNodeList= new ArrayList<>();
        curNodeList.add(root);

        while(curNodeList.size()>0){
            List<TreeNode> nextNodeList=new ArrayList<>();
            List<Integer> tempAnswerList=new ArrayList<>();
            for(TreeNode cur:curNodeList){
                if(cur!=null){
                    if(cur.left != null)nextNodeList.add(cur.left);
                    if(cur.right != null)nextNodeList.add(cur.right);
                    tempAnswerList.add(cur.val);
                }
            }
            curNodeList=nextNodeList;
            answer.add(tempAnswerList);
        }
        return answer;
    }
}
